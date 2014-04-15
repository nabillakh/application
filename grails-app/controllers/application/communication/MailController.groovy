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
       def mesmailEffectifFavoris =  mailService.afficherMailFavoris()
       def mesMailsFavoris = mailService.mailFavoris()
       def mesEffectifsMails = mailService.afficherMail()
       def mesMails = mailService.mailInbox()
       def mesMailsSent = mailService.mailenvoyer()
     
       def mesEffectifMailsArchiver = mailService.afficherMailArchiver() 
       def mesMailsArchiver = mailService.mailArchiver()
       def mailNonLu = mailService.mailnLu(mesEffectifsMails)
       
       
       // params.max = Math.min(max ?: 10, 100)
       // respond Mail.list(params), model:[mailInstanceCount: Mail.count()]
        [mailList: mesMails, mailList: mesMailsArchiver, maList: mesMailsFavoris, mesmailEffectifFavoris: mesmailEffectifFavoris, mesEffectifMailsArchiver:mesEffectifMailsArchiver,  mesEffectifsMails : mesEffectifsMails, mesMailsSent : mesMailsSent, mailNonLu:mailNonLu]
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
      mail.mailPrecedent = mail
      mail.save flush:true
      def lu = false
      def archive = false 
      def favoris = false
      params.recepteur.each()  {user ->
          def monMailEffectif = new MailEffectif(mail:mail, recepteur:user, lu:lu, archive:archive, favoris:favoris ).save()
      }
      
        redirect action:'index'

    }
   //--------- Replay ----------------- 
    def Relier() {
      def authorR = mailService.lookupCurrentPerson()
      def monMessageR = params.message
      def monmailprecedentR = params.mailprecedent
      def monObjetR = params.objet
      def mailR = new Mail(message : monMessageR, author : authorR, objet : monObjetR, mailprecedent: monmailprecedentR).save()
      def lu = false
      def archive = false 
      def favoris = false
      params.recepteur.each()  {user ->
          def monMailEffectif = new MailEffectif(mail:mailR, recepteur:user, lu:lu, archive:archive, favoris:favoris ).save()
      }
      
        redirect action:'index'

    }
    
    //-------------------------------------

    
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
