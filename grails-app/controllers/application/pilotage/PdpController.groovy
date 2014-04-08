package application.pilotage



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PdpController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Pdp.list(params), model:[pdpInstanceCount: Pdp.count()]
    }

    def show(Pdp pdpInstance) {
        respond pdpInstance
    }

    def create() {
        respond new Pdp(params)
    }

    @Transactional
    def save(Pdp pdpInstance) {
        if (pdpInstance == null) {
            notFound()
            return
        }

        if (pdpInstance.hasErrors()) {
            respond pdpInstance.errors, view:'create'
            return
        }

        pdpInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pdpInstance.label', default: 'Pdp'), pdpInstance.id])
                redirect pdpInstance
            }
            '*' { respond pdpInstance, [status: CREATED] }
        }
    }

    def edit(Pdp pdpInstance) {
        respond pdpInstance
    }

    @Transactional
    def update(Pdp pdpInstance) {
        if (pdpInstance == null) {
            notFound()
            return
        }

        if (pdpInstance.hasErrors()) {
            respond pdpInstance.errors, view:'edit'
            return
        }

        pdpInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Pdp.label', default: 'Pdp'), pdpInstance.id])
                redirect pdpInstance
            }
            '*'{ respond pdpInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Pdp pdpInstance) {

        if (pdpInstance == null) {
            notFound()
            return
        }

        pdpInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Pdp.label', default: 'Pdp'), pdpInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pdpInstance.label', default: 'Pdp'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
