package application.RH



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DroitController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Droit.list(params), model:[droitInstanceCount: Droit.count()]
    }

    def show(Droit droitInstance) {
        respond droitInstance
    }

    def create() {
        respond new Droit(params)
    }

    @Transactional
    def save(Droit droitInstance) {
        if (droitInstance == null) {
            notFound()
            return
        }

        if (droitInstance.hasErrors()) {
            respond droitInstance.errors, view:'create'
            return
        }

        droitInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'droitInstance.label', default: 'Droit'), droitInstance.id])
                redirect droitInstance
            }
            '*' { respond droitInstance, [status: CREATED] }
        }
    }

    def edit(Droit droitInstance) {
        respond droitInstance
    }

    @Transactional
    def update(Droit droitInstance) {
        if (droitInstance == null) {
            notFound()
            return
        }

        if (droitInstance.hasErrors()) {
            respond droitInstance.errors, view:'edit'
            return
        }

        droitInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Droit.label', default: 'Droit'), droitInstance.id])
                redirect droitInstance
            }
            '*'{ respond droitInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Droit droitInstance) {

        if (droitInstance == null) {
            notFound()
            return
        }

        droitInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Droit.label', default: 'Droit'), droitInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'droitInstance.label', default: 'Droit'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
