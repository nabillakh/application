package application.PP



import static org.springframework.http.HttpStatus.*
import grails.plugins.springsecurity.Secured
import grails.transaction.Transactional

@Transactional(readOnly = false)
class FamilleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Famille.list(params), model:[familleInstanceCount: Famille.count()]
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def show(Famille familleInstance) {
        respond familleInstance
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def create() {
        respond new Famille(params)
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
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
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def edit(Famille familleInstance) {
        respond familleInstance
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
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
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
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
