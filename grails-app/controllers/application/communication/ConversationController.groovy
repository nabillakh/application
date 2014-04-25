package application.communication



import static org.springframework.http.HttpStatus.*
import grails.plugins.springsecurity.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ConversationController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
@Secured(['IS_AUTHENTICATED_FULLY'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Conversation.list(params), model:[conversationInstanceCount: Conversation.count()]
    }
@Secured(['IS_AUTHENTICATED_FULLY'])
    def show(Conversation conversationInstance) {
        respond conversationInstance
    }
@Secured(['IS_AUTHENTICATED_FULLY'])
    def create() {
        respond new Conversation(params)
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_FULLY'])
    def save(Conversation conversationInstance) {
        if (conversationInstance == null) {
            notFound()
            return
        }

        if (conversationInstance.hasErrors()) {
            respond conversationInstance.errors, view:'create'
            return
        }

        conversationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'conversationInstance.label', default: 'Conversation'), conversationInstance.id])
                redirect conversationInstance
            }
            '*' { respond conversationInstance, [status: CREATED] }
        }
    }
@Secured(['IS_AUTHENTICATED_FULLY'])
    def edit(Conversation conversationInstance) {
        respond conversationInstance
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_FULLY'])
    def update(Conversation conversationInstance) {
        if (conversationInstance == null) {
            notFound()
            return
        }

        if (conversationInstance.hasErrors()) {
            respond conversationInstance.errors, view:'edit'
            return
        }

        conversationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Conversation.label', default: 'Conversation'), conversationInstance.id])
                redirect conversationInstance
            }
            '*'{ respond conversationInstance, [status: OK] }
        }
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_FULLY'])
    def delete(Conversation conversationInstance) {

        if (conversationInstance == null) {
            notFound()
            return
        }

        conversationInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Conversation.label', default: 'Conversation'), conversationInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'conversationInstance.label', default: 'Conversation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
