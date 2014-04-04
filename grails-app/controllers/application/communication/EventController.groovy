package application.communication

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import java.text.SimpleDateFormat
import org.joda.time.DateTime
import grails.converters.JSON

@Transactional(readOnly = true)
class EventController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Event.list(params), model:[eventInstanceCount: Event.count()]
    }

    def show(Event eventInstance) {
        respond eventInstance
    }
    
    def list = {
        def events = Event.list()
        // iterate through to see if we need to add additional Event instances because of recurring
        // events
        def eventList = []

        def displayDateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

        events.each {event ->
          
            DateTime startTime = new DateTime(event.startTime)
            DateTime endTime = new DateTime(event.endTime)

                /*
                    start/end and occurrenceStart/occurrenceEnd are separate because fullCalendar will use the client's local timezone (which may be different than the server's timezone)
                    start/end are used to render the events on the calendar and the occurrenceStart/occurrenceEnd values are passed along to the show popup
                */

                eventList << [
                        id: event.id,
                        title: event.title,
                        allDay: false,
                        start: displayDateFormatter.format(startTime.toDate()),
                        end: displayDateFormatter.format(endTime.toDate()),
                        occurrenceStart: startTime.toInstant().millis,
                        occurrenceEnd: endTime.toInstant().millis
                ]
            }
                [eventInstanceList: eventList]
           
                render eventList as JSON
    }

    def create() {
        respond new Event(params)
    }

    @Transactional
    def save(Event eventInstance) {
        if (eventInstance == null) {
            notFound()
            return
        }

        if (eventInstance.hasErrors()) {
            respond eventInstance.errors, view:'create'
            return
        }

        eventInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'eventInstance.label', default: 'Event'), eventInstance.id])
                redirect eventInstance
            }
            '*' { respond eventInstance, [status: CREATED] }
        }
    }

    def edit(Event eventInstance) {
        respond eventInstance
    }

    @Transactional
    def update(Event eventInstance) {
        if (eventInstance == null) {
            notFound()
            return
        }

        if (eventInstance.hasErrors()) {
            respond eventInstance.errors, view:'edit'
            return
        }

        eventInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Event.label', default: 'Event'), eventInstance.id])
                redirect eventInstance
            }
            '*'{ respond eventInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Event eventInstance) {

        if (eventInstance == null) {
            notFound()
            return
        }

        eventInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Event.label', default: 'Event'), eventInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'eventInstance.label', default: 'Event'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
