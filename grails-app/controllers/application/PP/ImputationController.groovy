package application.PP



import static org.springframework.http.HttpStatus.*
import grails.plugins.springsecurity.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)

class ImputationController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Imputation.list(params), model:[imputationInstanceCount: Imputation.count()]
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def show(Imputation imputationInstance) {
        respond imputationInstance
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def create() {
        respond new Imputation(params)
    }

    @Transactional
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def save(Imputation imputationInstance) {
        if (imputationInstance == null) {
            notFound()
            return
        }

        if (imputationInstance.hasErrors()) {
            respond imputationInstance.errors, view:'create'
            return
        }

        imputationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'imputationInstance.label', default: 'Imputation'), imputationInstance.id])
                redirect imputationInstance
            }
            '*' { respond imputationInstance, [status: CREATED] }
        }
    }

    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def edit(Imputation imputationInstance) {
    
        respond imputationInstance
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def update(Imputation imputationInstance) {
        if (imputationInstance == null) {
            notFound()
            return
        }

        if (imputationInstance.hasErrors()) {
            respond imputationInstance.errors, view:'edit'
            return
        }

        imputationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Imputation.label', default: 'Imputation'), imputationInstance.id])
                redirect imputationInstance
            }
            '*'{ respond imputationInstance, [status: OK] }
        }
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def delete(Imputation imputationInstance) {

        if (imputationInstance == null) {
            notFound()
            return
        }

        imputationInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Imputation.label', default: 'Imputation'), imputationInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'imputationInstance.label', default: 'Imputation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
