package application.communication

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.validation.Validateable
import java.text.SimpleDateFormat
import org.joda.time.DateTime
import grails.converters.JSON

import application.PP.*

@Transactional(readOnly = true) 
class EventController {

    def kanbanService
    def eventService
    
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured(['IS_AUTHENTICATED_FULLY'])
    def index(Integer max) {
        // envoi de la liste de kanban
        def mesOF = eventService.mesOF()
        
        params.max = Math.min(max ?: 10, 100)
        respond Event.list(params), model:[eventInstanceCount: Event.count(), mesOF : mesOF]
    }
@Secured(['IS_AUTHENTICATED_FULLY'])
    def show = {
        def eventInstance = Event.get(params.id)
        

        if (!eventInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'event.label', default: 'Event'), params.id])}"
            redirect(action: "index")
        }
        else {
            def model = [eventInstance: eventInstance, occurrenceStart: occurrenceStart, occurrenceEnd: occurrenceEnd]

            if (request.xhr) {
                render(template: "showPopup", model: model)
            }
            else {
                model
            }
        }

    }
    @Secured(['IS_AUTHENTICATED_FULLY'])
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
                        title: event.title,
                        allDay: false,
                        start: displayDateFormatter.format(startTime.toDate()),
                        end: displayDateFormatter.format(endTime.toDate()),
                ]
            }
                [eventInstanceList: eventList]
           
                render eventList as JSON 
    }
@Secured(['IS_AUTHENTICATED_FULLY'])
    def create() { 
        respond new Event(params)
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_FULLY'])
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
    
    
    @Transactional
    @Secured(['IS_AUTHENTICATED_FULLY'])
    def nouveauEvent() {
        // recupere en params le json du nouvel event. traduit en joda les dates puis cree l'event dans la bdd        
        def titre = params.title
        println(" titre : " + titre)
        DateTime debut = new DateTime(params.start)
        
        DateTime fin = new DateTime(params.end)
        
        println("debut : " + debut)
        
        println("fin : " + fin)
        
        Event eventInstance = new Event()      
            eventInstance.title = titre
            eventInstance.startTime = debut.toDate()
            eventInstance.endTime = fin.toDate()
           
        println("fin a partir de l'event: " + eventInstance.endTime) 
        
        eventInstance.save()
        
        [eventInstance : eventInstance]
        redirect action: "list" 
    }
    
    @Transactional
    @Secured(['IS_AUTHENTICATED_FULLY'])
    def nouveauEvent2() {
        // recupere en params le json du kanban planifie. traduit en joda les dates puis cree l'event dans la bdd        
        def titre = params.title
        println(" titre : " + titre)
        DateTime debut = new DateTime(new Date(params.start))
        
        DateTime fin = new DateTime(new Date(params.end))
        
        println("debut : " + debut)
        
        println("fin : " + fin)
        
        Event eventInstance = new Event()      
            eventInstance.title = titre
            eventInstance.startTime = debut.toDate()
            eventInstance.endTime = fin.toDate()
           
        println("fin a partir de l'event: " + eventInstance.endTime) 
        
        eventInstance.save()
        
        // creation de l'imputation
        
        eventService.imputation(eventInstance, OF.get(params.id))
        
        
        
        [eventInstance : eventInstance]
        redirect action: "list" 
    }
    
    
}
