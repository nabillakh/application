package application.PP



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ImputationController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Imputation.list(params), model:[imputationInstanceCount: Imputation.count()]
    }

    def show(Imputation imputationInstance) {
        respond imputationInstance
    }

    def create() {
        respond new Imputation(params)
    }

    @Transactional
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

    def edit(Imputation imputationInstance) {
        respond imputationInstance
    }

    @Transactional
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
