package application.communication
import application.RH.*
import application.communication.*


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MailController {
    def mailService  
    def springSecurityService
    
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        
       def mesEffectifsMails = mailService.afficherMail()
       def mesMails = mailService.mailInbox()
       def mesMailsSent = mailService.mailenvoyer()
       
       // params.max = Math.min(max ?: 10, 100)
       // respond Mail.list(params), model:[mailInstanceCount: Mail.count()]
        [mailList: mesMails,  mesEffectifsMails : mesEffectifsMails, mesMailsSent : mesMailsSent ]
    }

    def show(Mail mailInstance) {
        respond mailInstance
    }

    def create() {
         
        respond new Mail(params)
    }

    
    def save() {
      def author = mailService.lookupCurrentPerson()
      def monMessage = params.message
      def monObjet = params.objet
      def mail = new Mail(message : monMessage, author : author, objet : monObjet).save()
      params.recepteur.each()  {user ->
          def monMailEffectif = new MailEffectif(mail:mail,recepteur:user).save()
      }
      
        redirect action:'index'

    }

    
    def save2(Mail mailInstance) {
      def author = mailService.lookupCurrentPerson()
      mailInstance.author = author
      mailInstance.save flush:true 

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mailInstance.label', default: 'Mail'), mailInstance.id])
                redirect mailInstance
            }
            '*' { respond mailInstance, [status: CREATED] }
        }
    }
    
    def edit(Mail mailInstance) {
        respond mailInstance
    }

    @Transactional
    def update(Mail mailInstance) {
        if (mailInstance == null) {
            notFound()
            return
        }

        if (mailInstance.hasErrors()) {
            respond mailInstance.errors, view:'edit'
            return
        }

        mailInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Mail.label', default: 'Mail'), mailInstance.id])
                redirect mailInstance
            }
            '*'{ respond mailInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Mail mailInstance) {

        if (mailInstance == null) {
            notFound()
            return
        }

        mailInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Mail.label', default: 'Mail'), mailInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailInstance.label', default: 'Mail'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    
    
    
    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [MailInstanceList: Mail.list(params), MailInstanceTotal: Effectif.count()]
    }
    
    def maListe(Integer max) {
        
       def mesEffectifsMails = mailService.afficherMail()
       def mesMails = mailService.mailInbox()
       // params.max = Math.min(max ?: 10, 100)
       // respond Mail.list(params), model:[mailInstanceCount: Mail.count()]
       
       def content = messagerie.miniMessagerie mesMails:mesMails
       
       render content
       
    } 
    
    
    
}
