package application.communication



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CalendrierController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Calendrier.list(params), model:[calendrierInstanceCount: Calendrier.count()]
    }

    def show(Calendrier calendrierInstance) {
        respond calendrierInstance
    }

    def create() {
        respond new Calendrier(params)
    }

    @Transactional
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

    def edit(Calendrier calendrierInstance) {
        respond calendrierInstance
    }

    @Transactional
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
