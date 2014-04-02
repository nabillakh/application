package application

import grails.transaction.Transactional
import application.communication.*
import application.RH.*
import application.mail.*


@Transactional
class MailService {

   

    def springSecurityService
    
    private MailEffectif[] afficherMail() {
        def per = Effectif.get(springSecurityService.principal.id)
        try { def query = MailEffectif.whereAny {                
            recepteur { username == per.username }
        }
        def leMail = query.list(max: 10, sort:"dateCreated", order:"desc")
            return leMail
        }
        catch (NullPointerException n){
            return null
        }
    }
 
   private Mail[] mailInbox() {
       def listeMailEffectif = afficherMail()
       // le * permet de faire boucler la liste
       def listeMailInbox=listeMailEffectif*.mail 
       return listeMailInbox
   }
   
    private Mail[] mailenvoyer() {
        def perSent = Effectif.get(springSecurityService.principal.id)
        try { def query = Mail.whereAny {                
            author { username == perSent.username }
        }
        def leMailSent = query.list(max: 10, sort:"dateCreated", order:"desc")
            return leMailSent
        }
        catch (NullPointerException n){
            return null
        }
    }
    
    
     

    private lookupCurrentPerson() {
        Effectif.get(springSecurityService.principal.id)
    }
    
    private messageLu(MailEffectif mailEffectifInstance) {
        def mailEffectif = MailEffectif.get(mailEffectifInstance.id)
        mailEffectif.lu = true
        mailEffectif.save flush:true
    }
    
     private messageArchiver(MailEffectif mailEffectifInstance) {
        def mailEffectif = MailEffectif.get(mailEffectifInstance.id)
        mailEffectif.archive = true
        mailEffectif.save flush:true
    }
    
    
}