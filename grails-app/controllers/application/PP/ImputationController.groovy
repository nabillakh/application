package application.PP

import org.joda.time.DateTime
import org.joda.time.Instant

import grails.converters.JSON
import java.text.SimpleDateFormat

class ImputationController {
    def imputationService

    def index = {

    }

    def list = {
        def (startRange, endRange) = [params.long('start'), params.long('end')].collect { new Instant(it  * 1000L).toDate() }

        def imputations = Imputation.withCriteria {
            or {
                and {
                    eq("isRecurring", false)
                    between("startTime", startRange, endRange)
                }
                and {
                    eq("isRecurring", true)
                    or {
                        isNull("recurUntil")
                        ge("recurUntil", startRange)
                    }
                }
            }
        }


        // iterate through to see if we need to add additional Imputation instances because of recurring
        // imputations
        def imputationList = []

        def displayDateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

        imputations.each {imputation ->

            def dates = imputationService.findOccurrencesInRange(imputation, startRange, endRange)

            dates.each { date ->
                DateTime startTime = new DateTime(date)
                DateTime endTime = startTime.plusMinutes(imputation.durationMinutes)

                /*
                    start/end and occurrenceStart/occurrenceEnd are separate because fullCalendar will use the client's local timezone (which may be different than the server's timezone)
                    start/end are used to render the imputations on the calendar and the occurrenceStart/occurrenceEnd values are passed along to the show popup
                */

                imputationList << [
                        id: imputation.id,
                        title: imputation.title,
                        allDay: false,
                        start: displayDateFormatter.format(startTime.toDate()),
                        end: displayDateFormatter.format(endTime.toDate()),
                        occurrenceStart: startTime.toInstant().millis,
                        occurrenceEnd: endTime.toInstant().millis
                ]
            }
        }

        withFormat {
            html {
                [imputationInstanceList: imputationList]
            }
            json {
                render imputationList as JSON
            }
        }
    }

    def create = {
        def imputationInstance = new Imputation()
        imputationInstance.properties = params

        [imputationInstance: imputationInstance]
    }


    def show = {
        def imputationInstance = Imputation.get(params.id)
        def occurrenceStart = params.long('occurrenceStart') ?: new Instant(imputationInstance?.startTime)
        def occurrenceEnd = params.long('occurrenceEnd') ?: new Instant(imputationInstance?.endTime)

        if (!imputationInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'imputation.label', default: 'Imputation'), params.id])}"
            redirect(action: "index")
        }
        else {
            def model = [imputationInstance: imputationInstance, occurrenceStart: occurrenceStart, occurrenceEnd: occurrenceEnd]

            if (request.xhr) {
                render(template: "showPopup", model: model)
            }
            else {
                model
            }
        }

    }

    def save = {
        def imputationInstance = new Imputation(params)

        if (imputationInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'imputation.label', default: 'Imputation'), imputationInstance.id])}"
            redirect(action: "show", id: imputationInstance.id)
        }
        else {
            render(view: "create", model: [imputationInstance: imputationInstance])
        }

    }

    def edit = {
        def imputationInstance = Imputation.get(params.id)
        def (occurrenceStart, occurrenceEnd) = [params.long('occurrenceStart'), params.long('occurrenceEnd')]

        if (!imputationInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'imputation.label', default: 'Imputation'), params.id])}"
            redirect(action: "index")
        }
        else {
            [imputationInstance: imputationInstance, occurrenceStart: occurrenceStart, occurrenceEnd: occurrenceEnd]
        }

    }

    def update = {
        def imputationInstance = Imputation.get(params.id)

        ImputationRecurActionType editType = params.editType ? params.editType.toUpperCase() as ImputationRecurActionType : null

        Date occurrenceStartTime = params.date('startTime', ['MM/dd/yyyy hh:mm a'])
        Date occurrenceEndTime = params.date('endTime', ['MM/dd/yyyy hh:mm a'])

        def result = imputationService.updateImputation(imputationInstance, editType, occurrenceStartTime, occurrenceEndTime, params)

        if (!result.error) {
            flash.message = "${message(code: 'default.updated.message', args: [message(code: 'imputation.label', default: 'Imputation'), imputationInstance.id])}"
            redirect(action: "index")
        }
        if (result.error == 'not.found') {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'imputation.label', default: 'Imputation'), params.id])}"
            redirect(action: "index")
        }
        else if (result.error == 'has.errors') {
            render(view: "edit", model: [imputationInstance: imputationInstance])
        }

    }


    def delete = {
        def imputationInstance = Imputation.get(params.id)

        ImputationRecurActionType deleteType = params.editType ? params.deleteType.toUpperCase() as ImputationRecurActionType : null
        Date occurrenceStart = new Instant(params.long('occurrenceStart')).toDate()

        def result = imputationService.deleteImputation(imputationInstance, deleteType, occurrenceStart)

        if (!result.error) {
            redirect(action: "index")
        }
        if (result.error == 'not.found') {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'imputation.label', default: 'Imputation'), params.id])}"
            redirect(action: "index")
        }
        else if (result.error == 'has.errors') {
            redirect(action: "index")
        }
    }

    
}