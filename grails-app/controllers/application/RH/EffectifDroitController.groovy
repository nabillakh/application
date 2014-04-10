package application.RH



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EffectifDroitController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EffectifDroit.list(params), model:[effectifDroitInstanceCount: EffectifDroit.count()]
    }

    def show(EffectifDroit effectifDroitInstance) {
        respond effectifDroitInstance
    }

    def create() {
        respond new EffectifDroit(params)
    }

    @Transactional
    def save(EffectifDroit effectifDroitInstance) {
        if (effectifDroitInstance == null) {
            notFound()
            return
        }

        if (effectifDroitInstance.hasErrors()) {
            respond effectifDroitInstance.errors, view:'create'
            return
        }

        effectifDroitInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'effectifDroitInstance.label', default: 'EffectifDroit'), effectifDroitInstance.id])
                redirect effectifDroitInstance
            }
            '*' { respond effectifDroitInstance, [status: CREATED] }
        }
    }

    def edit(EffectifDroit effectifDroitInstance) {
        respond effectifDroitInstance
    }

    @Transactional
    def update(EffectifDroit effectifDroitInstance) {
        if (effectifDroitInstance == null) {
            notFound()
            return
        }

        if (effectifDroitInstance.hasErrors()) {
            respond effectifDroitInstance.errors, view:'edit'
            return
        }

        effectifDroitInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'EffectifDroit.label', default: 'EffectifDroit'), effectifDroitInstance.id])
                redirect effectifDroitInstance
            }
            '*'{ respond effectifDroitInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(EffectifDroit effectifDroitInstance) {

        if (effectifDroitInstance == null) {
            notFound()
            return
        }

        effectifDroitInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'EffectifDroit.label', default: 'EffectifDroit'), effectifDroitInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'effectifDroitInstance.label', default: 'EffectifDroit'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
