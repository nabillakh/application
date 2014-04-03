package application

import org.springframework.transaction.annotation.Transactional

import org.joda.time.DateTime 
import org.joda.time.Days
import org.joda.time.Weeks
import static org.joda.time.DateTimeConstants.MONDAY
import static org.joda.time.DateTimeConstants.SUNDAY
import org.joda.time.Months
import org.joda.time.Years
import org.joda.time.Instant
import org.joda.time.Minutes
import application.communication.*


class EventService {


    def updateEvent(Event eventInstance, EventRecurActionType actionType, Date occurrenceStartTime, Date occurrenceEndTime, def params) {
        def result = [:]

        try {
            if (!eventInstance) {
                result = [error: 'not.found']
            }
            else if (!eventInstance.isRecurring) {
                eventInstance.properties = params

                if (eventInstance.hasErrors() || !eventInstance.save(flush: true)) {
                    result = [error: 'has.errors']
                }
            }
            else {

                DateTime occurrenceStartDateTime = new DateTime(occurrenceStartTime)
                DateTime occurrenceEndDateTime = new DateTime(occurrenceEndTime)

                switch (actionType) {
                    case EventRecurActionType.OCCURRENCE:
                        // Add an exclusion
                        eventInstance.with {
                            addToExcludeDays(occurrenceStartDateTime.withTime(0, 0, 0, 0).toDate())
                            save(flush: true)
                        }

                        // single event
                        new Event(params).with {
                            startTime = occurrenceStartTime
                            endTime = occurrenceEndTime
                            isRecurring = false // ignore recurring options this is a single event
                            save(flush: true, failOnError: true)
                        }

                        break

                    case EventRecurActionType.FOLLOWING:

                        // create a new event for the changes following this occurrence
                        new Event(params).with {
                            isRecurring = true
                            startTime = occurrenceStartTime
                            endTime = occurrenceEndTime
                            recurUntil = eventInstance.recurUntil
                            save(flush: true, failOnError: true)
                        }

                        eventInstance.with {
                            recurUntil = occurrenceStartDateTime.withTime(0,0,0,0).toDate()
                            save(flush: true)
                        }

                        break

                    case EventRecurActionType.ALL:
                        // Using the date from the original startTime and endTime with the update time from the form
                        int updatedDuration = Minutes.minutesBetween(occurrenceStartDateTime, occurrenceEndDateTime).minutes

                        Date updatedStartTime = new DateTime(eventInstance.startTime).withTime(occurrenceStartDateTime.hourOfDay, occurrenceStartDateTime.minuteOfHour, 0, 0).toDate()
                        Date updatedEndTime = new DateTime(updatedStartTime).plusMinutes(updatedDuration).toDate()

                        eventInstance.properties = params
                        eventInstance.startTime = updatedStartTime
                        eventInstance.endTime = updatedEndTime

                        if (eventInstance.hasErrors() || !eventInstance.save(flush: true)) {
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

    def deleteEvent(Event eventInstance, EventRecurActionType actionType, Date occurrenceStart) {

        def result = [:]

        try {
            if (!eventInstance) {
                result = [error: 'not.found']
            }
            if (!eventInstance.isRecurring || actionType == EventRecurActionType.ALL) {
                eventInstance.delete(flush: true)
            }
            else {
                switch (actionType) {
                    case EventRecurActionType.OCCURRENCE:
                        // Add an exclusion
                        eventInstance.addToExcludeDays(new DateTime(occurrenceStart).withTime(0, 0, 0, 0).toDate())
                        eventInstance.save(flush: true)
                        break

                    case EventRecurActionType.FOLLOWING:
                        eventInstance.recurUntil = occurrenceStart
                        eventInstance.save(flush: true)
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
    public def findOccurrencesInRange(Event event, Date rangeStart, Date rangeEnd) {
        def dates = []

        Date currentDate
        if (event.isRecurring) {
            currentDate = findNextOccurrence(event, rangeStart)

            while (currentDate && currentDate < rangeEnd) {
                dates.add(currentDate)
                Date nextMinute = new DateTime(currentDate).plusMinutes(1).toDate()
                currentDate = findNextOccurrence(event, nextMinute)
            }
        }
        // One time (non-recurring) event
        else {
            if (event.startTime >= rangeStart && event.endTime <= rangeEnd) {
                dates.add(event.startTime)
            }
        }

        dates
    }

    // For repeating event get next occurrence after the specified date
    @Transactional(readOnly = true)
    Date findNextOccurrence(Event event, Date afterDate) {
        Date nextOccurrence

        if (!event.isRecurring) {
            // non-repeating event
            nextOccurrence = null
        } else if (event.recurUntil && afterDate > event.recurUntil) {
            // Event is already over
            nextOccurrence = null
        } else if (afterDate < event.startTime) {
            // First occurrence
            if (event.recurType == EventRecurType.WEEKLY && !(isOnRecurringDay(event, event.startTime))) {
                Date nextDay = new DateTime(event.startTime).plusDays(1).toDate()
                nextOccurrence = findNextOccurrence(event, nextDay)
            }
            else {
                nextOccurrence = event.startTime
            }
        } else {
            switch (event.recurType) {
                case EventRecurType.DAILY:
                    nextOccurrence = findNextDailyOccurrence(event, afterDate)
                    break
                case EventRecurType.WEEKLY:
                    nextOccurrence = findNextWeeklyOccurrence(event, afterDate)
                    break
                case EventRecurType.MONTHLY:
                    nextOccurrence = findNextMonthlyOccurrence(event, afterDate)
                    break
                case EventRecurType.YEARLY:
                    nextOccurrence = findNextYearlyOccurrence(event, afterDate)
                    break
            }


        }

        if (isOnExcludedDay(event, nextOccurrence)) {
            // Skip this occurrence and go to the next one
            nextOccurrence = findNextOccurrence(event, nextOccurrence)
        }
        else if (event.recurUntil && event.recurUntil <= nextOccurrence) {
            // Next occurrence happens after recurUntil date
            nextOccurrence = null
        }

        nextOccurrence
    }

    private Date findNextDailyOccurrence(Event event, Date afterDate) {
        DateTime nextOccurrence = new DateTime(event.startTime)

        int daysBeforeDate = Days.daysBetween(new DateTime(event.startTime), new DateTime(afterDate)).getDays()

        int occurrencesBeforeDate = Math.floor(daysBeforeDate / event.recurInterval)

        int daysToAdd = (occurrencesBeforeDate + 1) * event.recurInterval

        nextOccurrence = nextOccurrence.plusDays(daysToAdd)

        nextOccurrence.toDate()
    }


    private Date findNextWeeklyOccurrence(Event event, Date afterDate) {
        int weeksBeforeDate = Weeks.weeksBetween(new DateTime(event.startTime), new DateTime(afterDate)).getWeeks()
        int weekOccurrencesBeforeDate = Math.floor(weeksBeforeDate / event.recurInterval)

        DateTime lastOccurrence = new DateTime(event.startTime)
        lastOccurrence = lastOccurrence.plusWeeks(weekOccurrencesBeforeDate * event.recurInterval)
        lastOccurrence = lastOccurrence.withDayOfWeek(MONDAY)

        DateTime nextOccurrence
        if (isInSameWeek(lastOccurrence.toDate(), afterDate)) {
            nextOccurrence = lastOccurrence.plusDays(1)
        }
        else {
            nextOccurrence = lastOccurrence.plusWeeks(event.recurInterval)
        }

        boolean occurrenceFound = false

        while (!occurrenceFound) {
            if (nextOccurrence.toDate() > afterDate && isOnRecurringDay(event, nextOccurrence.toDate())) {
                occurrenceFound = true
            }
            else {
                if (nextOccurrence.getDayOfWeek() == SUNDAY) {
                    // we're about to pass into the next week
                    nextOccurrence = nextOccurrence.withDayOfWeek(MONDAY).plusWeeks(event.recurInterval)
                }
                else {
                    nextOccurrence = nextOccurrence.plusDays(1)
                }
            }

        }

        nextOccurrence.toDate()
    }

    private Date findNextMonthlyOccurrence(Event event, Date afterDate) {
        DateTime nextOccurrence = new DateTime(event.startTime)

        int monthsBeforeDate = Months.monthsBetween(new DateTime(event.startTime), new DateTime(afterDate)).getMonths()
        int occurrencesBeforeDate = Math.floor(monthsBeforeDate / event.recurInterval)
        nextOccurrence = nextOccurrence.plusMonths((occurrencesBeforeDate + 1) * event.recurInterval)

        nextOccurrence.toDate()
    }

    private Date findNextYearlyOccurrence(Event event, Date afterDate) {
        DateTime nextOccurrence = new DateTime(event.startTime)

        int yearsBeforeDate = Years.yearsBetween(new DateTime(event.startTime), new DateTime(afterDate)).getYears()
        int occurrencesBeforeDate = Math.floor(yearsBeforeDate / event.recurInterval)
        nextOccurrence = nextOccurrence.plusYears((occurrencesBeforeDate + 1) * event.recurInterval)

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

    private boolean isOnRecurringDay(Event event, Date date) {
        int day = new DateTime(date).getDayOfWeek()

        event.recurDaysOfWeek.find{it == day}
    }

    private def isOnExcludedDay(Event event, Date date) {
        date = (new DateTime(date)).withTime(0, 0, 0, 0).toDate()
        event.excludeDays?.contains(date)
    }
}