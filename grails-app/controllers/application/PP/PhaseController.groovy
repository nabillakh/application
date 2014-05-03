package application.PP



import static org.springframework.http.HttpStatus.*
import grails.plugins.springsecurity.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PhaseController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Phase.list(params), model:[phaseInstanceCount: Phase.count()]
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def show(Phase phaseInstance) {
        respond phaseInstance
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def create() {
        respond new Phase(params)
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def save(Phase phaseInstance) {
        if (phaseInstance == null) {
            notFound()
            return
        }

        if (phaseInstance.hasErrors()) {
            respond phaseInstance.errors, view:'create'
            return
        }

        phaseInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'phaseInstance.label', default: 'Phase'), phaseInstance.id])
                redirect phaseInstance
            }
            '*' { respond phaseInstance, [status: CREATED] }
        }
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def edit(Phase phaseInstance) {
        respond phaseInstance
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def update(Phase phaseInstance) {
        if (phaseInstance == null) {
            notFound()
            return
        }

        if (phaseInstance.hasErrors()) {
            respond phaseInstance.errors, view:'edit'
            return
        }

        phaseInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Phase.label', default: 'Phase'), phaseInstance.id])
                redirect phaseInstance
            }
            '*'{ respond phaseInstance, [status: OK] }
        }
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def delete(Phase phaseInstance) {

        if (phaseInstance == null) {
            notFound()
            return
        }

        phaseInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Phase.label', default: 'Phase'), phaseInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'phaseInstance.label', default: 'Phase'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
