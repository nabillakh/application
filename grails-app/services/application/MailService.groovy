package application

import grails.transaction.Transactional
import application.communication.*
import application.RH.*
import application.mail.*


@Transactional
class MailService {

   

    def springSecurityService
   //-------mail reçu et non archivé ---------  
    private MailEffectif[] afficherMail() {
        def per = Effectif.get(springSecurityService.principal.id)
        try { def query = MailEffectif.whereAny {                
            (recepteur { username == per.username }) && (archive == false)
           }
        def leMail = query.list(max : 10,sort : "dateCreated",order:"desc")
        
            return leMail
        }
        catch (NullPointerException n){
            return null
        }
    }
    //Corbeille--------------------------
       private MailEffectif[] afficherMailArchiver() {
        def per = Effectif.get(springSecurityService.principal.id)
        try { def query = MailEffectif.whereAny {                
            (recepteur { username == per.username }) && (archive == true)
           }
        def leMail1 = query.list(max: 10, sort:"dateCreated", order:"desc")
        
        
       
           return leMail1
        }
        catch (NullPointerException n){
            return null
        }
    }
//---------- mails favoris ---------------------
    
    private MailEffectif[] afficherMailFavoris() {
        def per = Effectif.get(springSecurityService.principal.id)
        try { def query = MailEffectif.whereAny {                
            (recepteur { username == per.username }) && (favoris == true)
           }
        def leMail2 = query.list(max: 10, sort:"dateCreated", order:"desc")
        
        
       
           return leMail2
        }
        catch (NullPointerException n){
            return null
        }
    }
    
//---------------------------------------------
    
//----------- listes des recepteurs --------------    
    
    
    
   private MailEffectif[] afficherRecepteurs(MailEffectif mailEffectifInstance) {
        def mailEffectif = MailEffectif.get(mailEffectifInstance.id)
       
        try { def query = MailEffectif.whereAny {                
            ( mail { id == mailEffectif.mail.id }) 
           }
        def leMail2 = query.list(max: 10, sort:"dateCreated", order:"desc")
        
        
       
           return leMail2
        }
        catch (NullPointerException n){
            return null
        }
    } 
    
//------------------------------------------------    
    
    
//--------- liste des mails-------------
   private Mail[] mailInbox() {
       def listeMailEffectif = afficherMail()
       // le * permet de faire boucler la liste
       def listeMailInbox=listeMailEffectif*.mail 
       return listeMailInbox
   }
   
    private Mail[] mailArchiver() {
       def listeMailEffectifArchiver = afficherMailArchiver()
       // le * permet de faire boucler la liste
       def listeMailArchiver=listeMailEffectifArchiver*.mail 
       return listeMailArchiver
   }
   private Mail[] mailFavoris() {
       def listeMailEffectifFavoris = afficherMailFavoris()
       // le * permet de faire boucler la liste
       def listeMailFavoris=listeMailEffectifFavoris*.mail 
       return listeMailFavoris
   }
   //----- mails envoyés ------------
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
    
    //------- mails non lus--------------
     private MailEffectif[] mailnLu(MailEffectif[] mailNLU){
         def mailNonLu = []
         mailNLU.each() { NONLU -> 
             if(NONLU.lu == false) {
                 mailNonLu.add(NONLU)
             }
             
         }
         return mailNonLu
        
     }
     //-------- id du user connecté------------------------------------
    private lookupCurrentPerson() {
        Effectif.get(springSecurityService.principal.id)
    }
    //----------- modification des valeurs des mails------------
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
    
    private messagefavoris(MailEffectif mailEffectifInstance) {
        def mailEffectif = MailEffectif.get(mailEffectifInstance.id)
        mailEffectif.favoris = true
        mailEffectif.save flush:true
    }
    
    
}
