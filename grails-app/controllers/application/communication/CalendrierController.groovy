package application.communication



import static org.springframework.http.HttpStatus.*
import grails.plugins.springsecurity.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CalendrierController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Calendrier.list(params), model:[calendrierInstanceCount: Calendrier.count()]
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def show(Calendrier calendrierInstance) {
        respond calendrierInstance
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def create() {
        respond new Calendrier(params)
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def save(Calendrier calendrierInstance) {
        if (calendrierInstance == null) {
            notFound()
            return
        }

        if (calendrierInstance.hasErrors()) {
            respond calendrierInstance.errors, view:'create'
            return
        }

        calendrierInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'calendrierInstance.label', default: 'Calendrier'), calendrierInstance.id])
                redirect calendrierInstance
            }
            '*' { respond calendrierInstance, [status: CREATED] }
        }
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def edit(Calendrier calendrierInstance) {
        respond calendrierInstance
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def update(Calendrier calendrierInstance) {
        if (calendrierInstance == null) {
            notFound()
            return
        }

        if (calendrierInstance.hasErrors()) {
            respond calendrierInstance.errors, view:'edit'
            return
        }

        calendrierInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Calendrier.label', default: 'Calendrier'), calendrierInstance.id])
                redirect calendrierInstance
            }
            '*'{ respond calendrierInstance, [status: OK] }
        }
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def delete(Calendrier calendrierInstance) {

        if (calendrierInstance == null) {
            notFound()
            return
        }

        calendrierInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Calendrier.label', default: 'Calendrier'), calendrierInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'calendrierInstance.label', default: 'Calendrier'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
