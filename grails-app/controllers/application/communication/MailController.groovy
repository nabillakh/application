package application.communication



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MailController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Mail.list(params), model:[mailInstanceCount: Mail.count()]
    }

    def show(Mail mailInstance) {
        respond mailInstance
    }

    def create() {
        respond new Mail(params)
    }

    @Transactional
    def save(Mail mailInstance) {
        if (mailInstance == null) {
            notFound()
            return
        }

        if (mailInstance.hasErrors()) {
            respond mailInstance.errors, view:'create'
            return
        }

        mailInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mailInstance.label', default: 'Mail'), mailInstance.id])
                redirect mailInstance
            }
            '*' { respond mailInstance, [status: CREATED] }
        }
    }

    def edit(Mail mailInstance) {
        respond mailInstance
    }

    @Transactional
    def update(Mail mailInstance) {
        if (mailInstance == null) {
            notFound()
            return
        }

        if (mailInstance.hasErrors()) {
            respond mailInstance.errors, view:'edit'
            return
        }

        mailInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Mail.label', default: 'Mail'), mailInstance.id])
                redirect mailInstance
            }
            '*'{ respond mailInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Mail mailInstance) {

        if (mailInstance == null) {
            notFound()
            return
        }

        mailInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Mail.label', default: 'Mail'), mailInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailInstance.label', default: 'Mail'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
