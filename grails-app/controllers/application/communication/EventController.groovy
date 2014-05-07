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
    
    def index(Integer max) {
        // envoi de la liste de kanban
        def mesOF = eventService.mesOF()
        
        params.max = Math.min(max ?: 10, 100)
        respond Event.list(params), model:[eventInstanceCount: Event.count(), mesOF : mesOF]
    }
    
    
    def showPopup = {
        
        def eventInstance = Event.get(params.id)
        
        [eventInstance: eventInstance]
        render(template: "showPopup")
        

    }

    def show = {
        def eventInstance = Event.get(params.id)
        

        if (!eventInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'event.label', default: 'Event'), params.id])}"
            redirect(action: "index")
        }
        else {
            def model = [eventInstance: eventInstance, occurrenceStart: occurrenceStart, occurrenceEnd: occurrenceEnd]

            if (request.xhr) {
                render(template: "show", model: model)
            }
            else {
                model
            }
        }

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
    
    
    @Transactional
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
    def nouveauEventKanban() {
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
    
    @Transactional
    def eventResize() {
        def displayDateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        // recupere en params le json de l'event modifie. traduit en joda les dates puis cree l'event dans la bdd        
        def monId = params.id
        println(monId)
        def eventInstance = Event.get(monId)
        println(" date de fin 0 : " + eventInstance.endTime)
        DateTime fin = new DateTime(eventInstance.endTime)
        println(" titre : " + eventInstance.title)
        println(" delta jours : " + params.decalageJour)
        println(" delta minutes : " + params.decalageMin)
        
        
        
        def decalageMin = Integer.parseInt(params.decalageMin)
        // decalageMin += 120 // pour decalage horaire
        def decalageJour = Integer.parseInt(params.decalageJour)
        
        println(" date de debut 1: " + eventInstance.startTime)
        println(" date de fin 1 : " + fin)
        DateTime fin2 = fin.plusMinutes(decalageMin)
        // fin2 = fin2.plusDays(decalageJour)
        eventInstance.endTime = fin2.toDate()
        println(" date de debut 2: " + eventInstance.startTime)
        println(" date de fin dans instance : " + eventInstance.endTime)
        eventInstance.save(flush : true)
        println(" date de debut 3: " + eventInstance.startTime)
        println(" date de fin dans instance apres save : " + eventInstance.endTime)
        
        
        // eventInstance.save()
        
        // maj de l'imputation
        
        // eventService.imputation(eventInstance, OF.get(params.id))
        
        
        
        [eventInstance : eventInstance]
        redirect action: "list" 
    }
    
    
}
