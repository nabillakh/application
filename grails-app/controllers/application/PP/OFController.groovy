package application.PP



import static org.springframework.http.HttpStatus.*
import grails.plugins.springsecurity.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class OFController {


    def compteRenduService
    def timelineService
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond OF.list(params), model:[OFInstanceCount: OF.count()]
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def show(OF OFInstance) {
        respond OFInstance
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def create() {
        respond new OF(params)
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def save(OF OFInstance) {
        if (OFInstance == null) {
            notFound()
            return
        }

        if (OFInstance.hasErrors()) {
            respond OFInstance.errors, view:'create'
            return
        }

        OFInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'OFInstance.label', default: 'OF'), OFInstance.id])
                redirect OFInstance
            }
            '*' { respond OFInstance, [status: CREATED] }
        }
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def edit(OF OFInstance) {
        respond OFInstance
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def update(OF OFInstance) {
        if (OFInstance == null) {
            notFound()
            return
        }

        if (OFInstance.hasErrors()) {
            respond OFInstance.errors, view:'edit'
            return
        }

        OFInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'OF.label', default: 'OF'), OFInstance.id])
                redirect OFInstance
            }
            '*'{ respond OFInstance, [status: OK] }
        }
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def delete(OF OFInstance) {

        if (OFInstance == null) {
            notFound()
            return
        }

        OFInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'OF.label', default: 'OF'), OFInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'OFInstance.label', default: 'OF'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
