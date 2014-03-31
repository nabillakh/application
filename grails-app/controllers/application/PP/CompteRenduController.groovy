package application.PP



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CompteRenduController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CompteRendu.list(params), model:[compteRenduInstanceCount: CompteRendu.count()]
    }

    def show(CompteRendu compteRenduInstance) {
        respond compteRenduInstance
    }

    def create() {
        respond new CompteRendu(params)
    }

    @Transactional
    def save(CompteRendu compteRenduInstance) {
        if (compteRenduInstance == null) {
            notFound()
            return
        }

        if (compteRenduInstance.hasErrors()) {
            respond compteRenduInstance.errors, view:'create'
            return
        }

        compteRenduInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'compteRenduInstance.label', default: 'CompteRendu'), compteRenduInstance.id])
                redirect compteRenduInstance
            }
            '*' { respond compteRenduInstance, [status: CREATED] }
        }
    }

    def edit(CompteRendu compteRenduInstance) {
        respond compteRenduInstance
    }

    @Transactional
    def update(CompteRendu compteRenduInstance) {
        if (compteRenduInstance == null) {
            notFound()
            return
        }

        if (compteRenduInstance.hasErrors()) {
            respond compteRenduInstance.errors, view:'edit'
            return
        }

        compteRenduInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CompteRendu.label', default: 'CompteRendu'), compteRenduInstance.id])
                redirect compteRenduInstance
            }
            '*'{ respond compteRenduInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(CompteRendu compteRenduInstance) {

        if (compteRenduInstance == null) {
            notFound()
            return
        }

        compteRenduInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CompteRendu.label', default: 'CompteRendu'), compteRenduInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'compteRenduInstance.label', default: 'CompteRendu'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
