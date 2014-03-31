package application

import grails.transaction.Transactional
import application.communication.*
import application.RH.*
import application.mail.*


@Transactional
class MailService {

   

    def springSecurityService
    
    
 private afficherMail() {
        def per = Effectif.get(springSecurityService.principal.id)
        try { def query = MailEffectif.whereAny {                
            recepteur { username == per.username }
        }
        def leMail = query.list(max: 10)
        leMail
        }
        catch (NullPointerException n){
            
        }
 }
 
   private mailInbox() {
       def listeMailEffectif = afficherMail()
       def listeMailInbox
       listeMailEffectif.each() { unMailEffectif ->
           listeMailInbox.add(unMailEffectif.mail)
       }
       return listeMailInbox
   }

    private lookupCurrentPerson() {
        Effectif.get(springSecurityService.principal.id)
    }
}
