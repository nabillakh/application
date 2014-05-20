package application.RH

import grails.converters.JSON
import grails.plugins.springsecurity.Secured
import org.codehaus.groovy.grails.web.json.JSONObject
import application.pilotage.*
import application.PP.*
import application.communication.*

import application.*

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EffectifController {
       def springSecurityService
        def kanbanService
        def eventService
        def messageService
        
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE", listEffectif:"GET"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Effectif.list(params), model:[effectifInstanceCount: Effectif.count()]
    }

    def show(Effectif effectifInstance) {
      
        def per = effectifInstance
        
        println('show effectif')
        println(per)
        def kanbanInstanceList = kanbanService.listeKanbanEffectif(per)
        [kanbanInstanceList:kanbanInstanceList]
        respond effectifInstance
    }
def listEffectif(){
    
    def user = Effectif.list()
 
        render user as JSON
        
}
    def create() {
        respond new Effectif(params)
    }

    @Transactional
    def save(Effectif effectifInstance) {
        if (effectifInstance == null) {
            notFound()
            return
        }

        if (effectifInstance.hasErrors()) {
            respond effectifInstance.errors, view:'create'
            return
        }

        effectifInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'effectifInstance.label', default: 'Effectif'), effectifInstance.id])
                redirect effectifInstance
            }
            '*' { respond effectifInstance, [status: CREATED] }
        }
    }

    def edit(Effectif effectifInstance) {
        respond effectifInstance
    }

    @Transactional
    def update(Effectif effectifInstance) {
        if (effectifInstance == null) {
            notFound()
            return
        }

        if (effectifInstance.hasErrors()) {
            respond effectifInstance.errors, view:'edit'
            return
        }

        effectifInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Effectif.label', default: 'Effectif'), effectifInstance.id])
                redirect effectifInstance
            }
            '*'{ respond effectifInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Effectif effectifInstance) {

        if (effectifInstance == null) {
            notFound()
            return
        }

        effectifInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Effectif.label', default: 'Effectif'), effectifInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'effectifInstance.label', default: 'Effectif'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
       
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def indicateurEffectif() {
        
        def monEffectif = Effectif.get(Integer.parseInt(params.effectif))
        def listeMessage = kanbanService.listeMessage()
        def listeEffectif = kanbanService.listeEffectif()
        
        def messagesKanbanMoyen = messageService.nbMessageKanban(listeMessage) / listeEffectif.size()
        def messagesAutreMoyen = messageService.nbMessageAutre(listeMessage) / listeEffectif.size()
        
        
        def mesMessages = messageService.listeMessageAuteurEffectif(monEffectif)
        println(mesMessages)
        def messagesKanban = messageService.nbMessageKanban(mesMessages) / 1
        println(messagesKanban)
        def messagesAutre = messageService.nbMessageAutre(mesMessages)
        
        println(messagesAutre)
        println("ok")
        
        [messagesAutreMoyen:messagesAutreMoyen, messagesKanbanMoyen:messagesKanbanMoyen, messagesKanban:messagesKanban,messagesAutre:messagesAutre]
    }   
    
    
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def information() {
        println(params.effectif + "ok 2 ")
        def monEffectif = Effectif.get(Integer.parseInt(params.effectif))
        def kanbanInstanceList = kanbanService.listeKanbanEffectif(monEffectif)
        [kanbanInstanceList:kanbanInstanceList]
    }
    
    
}
