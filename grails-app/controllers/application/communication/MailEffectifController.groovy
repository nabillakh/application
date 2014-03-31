package application.communication


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MailEffectifController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MailEffectif.list(params), model:[mailEffectifInstanceCount: MailEffectif.count()]
    }

    def show(MailEffectif mailEffectifInstance) {
        respond mailEffectifInstance
    }

    def create() {
        respond new MailEffectif(params)
    }

    @Transactional
    def save(MailEffectif mailEffectifInstance) {
        if (mailEffectifInstance == null) {
            notFound()
            return
        }

        if (mailEffectifInstance.hasErrors()) {
            respond mailEffectifInstance.errors, view:'create'
            return
        }

        mailEffectifInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mailEffectifInstance.label', default: 'MailEffectif'), mailEffectifInstance.id])
                redirect mailEffectifInstance
            }
            '*' { respond mailEffectifInstance, [status: CREATED] }
        }
    }

    def edit(MailEffectif mailEffectifInstance) {
        respond mailEffectifInstance
    }

    @Transactional
    def update(MailEffectif mailEffectifInstance) {
        if (mailEffectifInstance == null) {
            notFound()
            return
        }

        if (mailEffectifInstance.hasErrors()) {
            respond mailEffectifInstance.errors, view:'edit'
            return
        }

        mailEffectifInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'MailEffectif.label', default: 'MailEffectif'), mailEffectifInstance.id])
                redirect mailEffectifInstance
            }
            '*'{ respond mailEffectifInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(MailEffectif mailEffectifInstance) {

        if (mailEffectifInstance == null) {
            notFound()
            return
        }

        mailEffectifInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'MailEffectif.label', default: 'MailEffectif'), mailEffectifInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailEffectifInstance.label', default: 'MailEffectif'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
