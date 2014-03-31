package application

import grails.transaction.Transactional

import org.joda.time.DateTime
import org.joda.time.Days
import org.joda.time.Weeks
import static org.joda.time.DateTimeConstants.MONDAY
import static org.joda.time.DateTimeConstants.SUNDAY
import org.joda.time.Months
import org.joda.time.Years
import org.joda.time.Instant
import org.joda.time.Minutes
import application.PP.*


class ImputationService {


    def updateImputation(Imputation imputationInstance, ImputationRecurActionType actionType, Date occurrenceStartTime, Date occurrenceEndTime, def params) {
        def result = [:]

        try {
            if (!imputationInstance) {
                result = [error: 'not.found']
            }
            else if (!imputationInstance.isRecurring) {
                imputationInstance.properties = params

                if (imputationInstance.hasErrors() || !imputationInstance.save(flush: true)) {
                    result = [error: 'has.errors']
                }
            }
            else {

                DateTime occurrenceStartDateTime = new DateTime(occurrenceStartTime)
                DateTime occurrenceEndDateTime = new DateTime(occurrenceEndTime)

                switch (actionType) {
                    case ImputationRecurActionType.OCCURRENCE:
                        // Add an exclusion
                        imputationInstance.with {
                            addToExcludeDays(occurrenceStartDateTime.withTime(0, 0, 0, 0).toDate())
                            save(flush: true)
                        }

                        // single imputation
                        new Imputation(params).with {
                            startTime = occurrenceStartTime
                            endTime = occurrenceEndTime
                            isRecurring = false // ignore recurring options this is a single imputation
                            save(flush: true, failOnError: true)
                        }

                        break

                    case ImputationRecurActionType.FOLLOWING:

                        // create a new imputation for the changes following this occurrence
                        new Imputation(params).with {
                            isRecurring = true
                            startTime = occurrenceStartTime
                            endTime = occurrenceEndTime
                            recurUntil = imputationInstance.recurUntil
                            save(flush: true, failOnError: true)
                        }

                        imputationInstance.with {
                            recurUntil = occurrenceStartDateTime.withTime(0,0,0,0).toDate()
                            save(flush: true)
                        }

                        break

                    case ImputationRecurActionType.ALL:
                        // Using the date from the original startTime and endTime with the update time from the form
                        int updatedDuration = Minutes.minutesBetween(occurrenceStartDateTime, occurrenceEndDateTime).minutes

                        Date updatedStartTime = new DateTime(imputationInstance.startTime).withTime(occurrenceStartDateTime.hourOfDay, occurrenceStartDateTime.minuteOfHour, 0, 0).toDate()
                        Date updatedEndTime = new DateTime(updatedStartTime).plusMinutes(updatedDuration).toDate()

                        imputationInstance.properties = params
                        imputationInstance.startTime = updatedStartTime
                        imputationInstance.endTime = updatedEndTime

                        if (imputationInstance.hasErrors() || !imputationInstance.save(flush: true)) {
                            result = [error: 'has.errors']
                        }


                }
            }

        }
        catch (Exception ex) {
            result = [error: 'has.errors']
        }

        result
    }

    def deleteImputation(Imputation imputationInstance, ImputationRecurActionType actionType, Date occurrenceStart) {

        def result = [:]

        try {
            if (!imputationInstance) {
                result = [error: 'not.found']
            }
            if (!imputationInstance.isRecurring || actionType == ImputationRecurActionType.ALL) {
                imputationInstance.delete(flush: true)
            }
            else {
                switch (actionType) {
                    case ImputationRecurActionType.OCCURRENCE:
                        // Add an exclusion
                        imputationInstance.addToExcludeDays(new DateTime(occurrenceStart).withTime(0, 0, 0, 0).toDate())
                        imputationInstance.save(flush: true)
                        break

                    case ImputationRecurActionType.FOLLOWING:
                        imputationInstance.recurUntil = occurrenceStart
                        imputationInstance.save(flush: true)
                        break

                }

            }
        }
        catch (Exception ex) {
            result = [error: 'has.errors']
        }

        result
    }

    @Transactional(readOnly = true)
    public def findOccurrencesInRange(Imputation imputation, Date rangeStart, Date rangeEnd) {
        def dates = []

        Date currentDate
        if (imputation.isRecurring) {
            currentDate = findNextOccurrence(imputation, rangeStart)

            while (currentDate && currentDate < rangeEnd) {
                dates.add(currentDate)
                Date nextMinute = new DateTime(currentDate).plusMinutes(1).toDate()
                currentDate = findNextOccurrence(imputation, nextMinute)
            }
        }
        // One time (non-recurring) imputation
        else {
            if (imputation.startTime >= rangeStart && imputation.endTime <= rangeEnd) {
                dates.add(imputation.startTime)
            }
        }

        dates
    }

    // For repeating imputation get next occurrence after the specified date
    @Transactional(readOnly = true)
    Date findNextOccurrence(Imputation imputation, Date afterDate) {
        Date nextOccurrence

        if (!imputation.isRecurring) {
            // non-repeating imputation
            nextOccurrence = null
        } else if (imputation.recurUntil && afterDate > imputation.recurUntil) {
            // Imputation is already over
            nextOccurrence = null
        } else if (afterDate < imputation.startTime) {
            // First occurrence
            if (imputation.recurType == ImputationRecurType.WEEKLY && !(isOnRecurringDay(imputation, imputation.startTime))) {
                Date nextDay = new DateTime(imputation.startTime).plusDays(1).toDate()
                nextOccurrence = findNextOccurrence(imputation, nextDay)
            }
            else {
                nextOccurrence = imputation.startTime
            }
        } else {
            switch (imputation.recurType) {
                case ImputationRecurType.DAILY:
                    nextOccurrence = findNextDailyOccurrence(imputation, afterDate)
                    break
                case ImputationRecurType.WEEKLY:
                    nextOccurrence = findNextWeeklyOccurrence(imputation, afterDate)
                    break
                case ImputationRecurType.MONTHLY:
                    nextOccurrence = findNextMonthlyOccurrence(imputation, afterDate)
                    break
                case ImputationRecurType.YEARLY:
                    nextOccurrence = findNextYearlyOccurrence(imputation, afterDate)
                    break
            }


        }

        if (isOnExcludedDay(imputation, nextOccurrence)) {
            // Skip this occurrence and go to the next one
            nextOccurrence = findNextOccurrence(imputation, nextOccurrence)
        }
        else if (imputation.recurUntil && imputation.recurUntil <= nextOccurrence) {
            // Next occurrence happens after recurUntil date
            nextOccurrence = null
        }

        nextOccurrence
    }

    private Date findNextDailyOccurrence(Imputation imputation, Date afterDate) {
        DateTime nextOccurrence = new DateTime(imputation.startTime)

        int daysBeforeDate = Days.daysBetween(new DateTime(imputation.startTime), new DateTime(afterDate)).getDays()

        int occurrencesBeforeDate = Math.floor(daysBeforeDate / imputation.recurInterval)

        int daysToAdd = (occurrencesBeforeDate + 1) * imputation.recurInterval

        nextOccurrence = nextOccurrence.plusDays(daysToAdd)

        nextOccurrence.toDate()
    }


    private Date findNextWeeklyOccurrence(Imputation imputation, Date afterDate) {
        int weeksBeforeDate = Weeks.weeksBetween(new DateTime(imputation.startTime), new DateTime(afterDate)).getWeeks()
        int weekOccurrencesBeforeDate = Math.floor(weeksBeforeDate / imputation.recurInterval)

        DateTime lastOccurrence = new DateTime(imputation.startTime)
        lastOccurrence = lastOccurrence.plusWeeks(weekOccurrencesBeforeDate * imputation.recurInterval)
        lastOccurrence = lastOccurrence.withDayOfWeek(MONDAY)

        DateTime nextOccurrence
        if (isInSameWeek(lastOccurrence.toDate(), afterDate)) {
            nextOccurrence = lastOccurrence.plusDays(1)
        }
        else {
            nextOccurrence = lastOccurrence.plusWeeks(imputation.recurInterval)
        }

        boolean occurrenceFound = false

        while (!occurrenceFound) {
            if (nextOccurrence.toDate() > afterDate && isOnRecurringDay(imputation, nextOccurrence.toDate())) {
                occurrenceFound = true
            }
            else {
                if (nextOccurrence.getDayOfWeek() == SUNDAY) {
                    // we're about to pass into the next week
                    nextOccurrence = nextOccurrence.withDayOfWeek(MONDAY).plusWeeks(imputation.recurInterval)
                }
                else {
                    nextOccurrence = nextOccurrence.plusDays(1)
                }
            }

        }

        nextOccurrence.toDate()
    }

    private Date findNextMonthlyOccurrence(Imputation imputation, Date afterDate) {
        DateTime nextOccurrence = new DateTime(imputation.startTime)

        int monthsBeforeDate = Months.monthsBetween(new DateTime(imputation.startTime), new DateTime(afterDate)).getMonths()
        int occurrencesBeforeDate = Math.floor(monthsBeforeDate / imputation.recurInterval)
        nextOccurrence = nextOccurrence.plusMonths((occurrencesBeforeDate + 1) * imputation.recurInterval)

        nextOccurrence.toDate()
    }

    private Date findNextYearlyOccurrence(Imputation imputation, Date afterDate) {
        DateTime nextOccurrence = new DateTime(imputation.startTime)

        int yearsBeforeDate = Years.yearsBetween(new DateTime(imputation.startTime), new DateTime(afterDate)).getYears()
        int occurrencesBeforeDate = Math.floor(yearsBeforeDate / imputation.recurInterval)
        nextOccurrence = nextOccurrence.plusYears((occurrencesBeforeDate + 1) * imputation.recurInterval)

        nextOccurrence.toDate()
    }


    private boolean isInSameWeek(Date date1, Date date2) {
        DateTime dateTime1 = new DateTime(date1)
        DateTime dateTime2 = new DateTime(date2)

        ((Weeks.weeksBetween(dateTime1, dateTime2)).weeks == 0)
    }

    private boolean isOnSameDay(Date date1, Date date2) {
        DateTime dateTime1 = new DateTime(date1)
        DateTime dateTime2 = new DateTime(date2)

        ((Days.daysBetween(dateTime1, dateTime2)).days == 0)
    }

    private boolean isOnRecurringDay(Imputation imputation, Date date) {
        int day = new DateTime(date).getDayOfWeek()

        imputation.recurDaysOfWeek.find{it == day}
    }

    private def isOnExcludedDay(Imputation imputation, Date date) {
        date = (new DateTime(date)).withTime(0, 0, 0, 0).toDate()
        imputation.excludeDays?.contains(date)
    }
}