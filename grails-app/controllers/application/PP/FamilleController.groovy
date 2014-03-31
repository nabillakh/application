package application.PP



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FamilleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Famille.list(params), model:[familleInstanceCount: Famille.count()]
    }

    def show(Famille familleInstance) {
        respond familleInstance
    }

    def create() {
        respond new Famille(params)
    }

    @Transactional
    def save(Famille familleInstance) {
        if (familleInstance == null) {
            notFound()
            return
        }

        if (familleInstance.hasErrors()) {
            respond familleInstance.errors, view:'create'
            return
        }

        familleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'familleInstance.label', default: 'Famille'), familleInstance.id])
                redirect familleInstance
            }
            '*' { respond familleInstance, [status: CREATED] }
        }
    }

    def edit(Famille familleInstance) {
        respond familleInstance
    }

    @Transactional
    def update(Famille familleInstance) {
        if (familleInstance == null) {
            notFound()
            return
        }

        if (familleInstance.hasErrors()) {
            respond familleInstance.errors, view:'edit'
            return
        }

        familleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Famille.label', default: 'Famille'), familleInstance.id])
                redirect familleInstance
            }
            '*'{ respond familleInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Famille familleInstance) {

        if (familleInstance == null) {
            notFound()
            return
        }

        familleInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Famille.label', default: 'Famille'), familleInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'familleInstance.label', default: 'Famille'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
