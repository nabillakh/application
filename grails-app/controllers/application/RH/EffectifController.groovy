package application.RH



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EffectifController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Effectif.list(params), model:[effectifInstanceCount: Effectif.count()]
    }

    def show(Effectif effectifInstance) {
        respond effectifInstance
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
}
