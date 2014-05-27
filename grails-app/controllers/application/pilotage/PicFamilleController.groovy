package application.pilotage



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = false)
class PicFamilleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PicFamille.list(params), model:[picFamilleInstanceCount: PicFamille.count()]
    }

    def show(PicFamille picFamilleInstance) {
        respond picFamilleInstance
    }

    def create() {
        respond new PicFamille(params)
    }

    @Transactional
    def save(PicFamille picFamilleInstance) {
        if (picFamilleInstance == null) {
            notFound()
            return
        }

        if (picFamilleInstance.hasErrors()) {
            respond picFamilleInstance.errors, view:'create'
            return
        }

        picFamilleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'picFamilleInstance.label', default: 'PicFamille'), picFamilleInstance.id])
                redirect picFamilleInstance
            }
            '*' { respond picFamilleInstance, [status: CREATED] }
        }
    }

    def edit(PicFamille picFamilleInstance) {
        respond picFamilleInstance
    }

    @Transactional
    def update(PicFamille picFamilleInstance) {
        if (picFamilleInstance == null) {
            notFound()
            return
        }

        if (picFamilleInstance.hasErrors()) {
            respond picFamilleInstance.errors, view:'edit'
            return
        }

        picFamilleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'PicFamille.label', default: 'PicFamille'), picFamilleInstance.id])
                redirect picFamilleInstance
            }
            '*'{ respond picFamilleInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(PicFamille picFamilleInstance) {

        if (picFamilleInstance == null) {
            notFound()
            return
        }

        picFamilleInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'PicFamille.label', default: 'PicFamille'), picFamilleInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'picFamilleInstance.label', default: 'PicFamille'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
