package application.communication



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EventEffectifController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EventEffectif.list(params), model:[eventEffectifInstanceCount: EventEffectif.count()]
    }

    def show(EventEffectif eventEffectifInstance) {
        respond eventEffectifInstance
    }

    def create() {
        respond new EventEffectif(params)
    }

    @Transactional
    def save(EventEffectif eventEffectifInstance) {
        if (eventEffectifInstance == null) {
            notFound()
            return
        }

        if (eventEffectifInstance.hasErrors()) {
            respond eventEffectifInstance.errors, view:'create'
            return
        }

        eventEffectifInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'eventEffectifInstance.label', default: 'EventEffectif'), eventEffectifInstance.id])
                redirect eventEffectifInstance
            }
            '*' { respond eventEffectifInstance, [status: CREATED] }
        }
    }

    def edit(EventEffectif eventEffectifInstance) {
        respond eventEffectifInstance
    }

    @Transactional
    def update(EventEffectif eventEffectifInstance) {
        if (eventEffectifInstance == null) {
            notFound()
            return
        }

        if (eventEffectifInstance.hasErrors()) {
            respond eventEffectifInstance.errors, view:'edit'
            return
        }

        eventEffectifInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'EventEffectif.label', default: 'EventEffectif'), eventEffectifInstance.id])
                redirect eventEffectifInstance
            }
            '*'{ respond eventEffectifInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(EventEffectif eventEffectifInstance) {

        if (eventEffectifInstance == null) {
            notFound()
            return
        }

        eventEffectifInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'EventEffectif.label', default: 'EventEffectif'), eventEffectifInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'eventEffectifInstance.label', default: 'EventEffectif'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
