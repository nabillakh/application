package application.PP

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import application.*

@Transactional(readOnly = true)
class KanbanController {

    def kanbanService
    def compteRenduService
    def timelineService
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Kanban.list(params), model:[kanbanInstanceCount: Kanban.count()]
    }

    def show(Kanban kanbanInstance) {
        def ofs = kanbanService.montrerOF(kanbanInstance)
        def cRendus = kanbanService.afficherCRKanban(kanbanInstance)
        [kanbanInstance:kanbanInstance, ofs : ofs, cRendus : cRendus]
    }

    def create() {
        respond new Kanban(params)
    }

    @Transactional
    def save(Kanban kanbanInstance) {
        
        if (!kanbanInstance.save(flush: true)) {
            render(view: "create", model: [kanbanInstance: kanbanInstance])
            return
        }
            // ajouter par NL
            // permet de creer des OF a la creation d'un Kanban
        
        kanbanService.requeteCreation(kanbanInstance)

        flash.message = message(code: 'default.created.message', args: [message(code: 'kanban.label', default: 'Kanban'), kanbanInstance.id])
        // redirect(action: "show", id: kanbanInstance.id)
        redirect(action:"index")
    }

    def edit(Kanban kanbanInstance) {
        respond kanbanInstance
    }

    @Transactional
    def update(Kanban kanbanInstance) {
        if (kanbanInstance == null) {
            notFound()
            return
        }

        if (kanbanInstance.hasErrors()) {
            respond kanbanInstance.errors, view:'edit'
            return
        }

        kanbanInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Kanban.label', default: 'Kanban'), kanbanInstance.id])
                redirect kanbanInstance
            }
            '*'{ respond kanbanInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Kanban kanbanInstance) {

        if (kanbanInstance == null) {
            notFound()
            return
        }

        kanbanInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Kanban.label', default: 'Kanban'), kanbanInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'kanbanInstance.label', default: 'Kanban'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    def updateCompteRendu(String message, Long kanban) {
        compteRenduService.updateCompteRendu(message , kanban)
        def messages = timelineService.getTimelineForUser(springSecurityService.principal.username)
        
        def content = compteRendus.renderMessages messages: messages
        render content
    }
}
