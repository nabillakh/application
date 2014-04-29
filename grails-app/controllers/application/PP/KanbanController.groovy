package application.PP

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import application.*
import grails.plugins.springsecurity.Secured
import grails.plugins.springsecurity.Secured

@Transactional(readOnly = true)
class KanbanController {

    def kanbanService
    def compteRenduService
    def timelineService
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
@Secured(['IS_AUTHENTICATED_FULLY'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Kanban.list(params), model:[kanbanInstanceCount: Kanban.count()]
    }
@Secured(['IS_AUTHENTICATED_FULLY'])
    def show(Kanban kanbanInstance) {
        def ofs = kanbanService.montrerOF(kanbanInstance)
        println("charger des of ok")
        def mesCR = kanbanService.afficherCRKanban(kanbanInstance)
        
        println("charger des cr ok")
        [kanbanInstance:kanbanInstance, ofs : ofs, mesCR : mesCR]
    }
@Secured(['IS_AUTHENTICATED_FULLY'])
    def create() {
        respond new Kanban(params)
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_FULLY'])
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
@Secured(['IS_AUTHENTICATED_FULLY'])
    def edit(Kanban kanbanInstance) {
        respond kanbanInstance
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_FULLY'])
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
    @Secured(['IS_AUTHENTICATED_FULLY'])
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
    @Secured(['IS_AUTHENTICATED_FULLY'])
    def updateCompteRendu(String message, Long kanban) {
        
        println("controleur updateCR" + message + kanban)
        compteRenduService.updateCompteRendu(message , kanban)
        render "<script>obtenirCompteRendu()</script>"
    }
    
    
    def obtenirCompteRendu(Long kanban) {
        println("ok")
        println(kanban)
        def monKanban = Kanban.get(kanban)
        def mesCR = kanbanService.afficherCRKanban(monKanban)
        [mesCR:mesCR.reverse()]
    }
    
    
}
