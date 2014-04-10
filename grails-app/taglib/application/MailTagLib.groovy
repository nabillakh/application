package application

import application.MailService

class MailTagLib {
    static namespace = 'messagerie'
    
    def mailService
    
    
    def miniMessagerie = { attrs ->
        
       def mesEffectifsMails = mailService.afficherMail()
       def mesMails = mailService.mailInbox()
     
       def mailNonLu = mailService.mailnLu(mesEffectifsMails)
       
        mesMails.eachWithIndex { mail, counter ->
            out << g.render(template: '/mail/miniInbox', model: [mailMessage: mail, messageCounter: counter, mailNonLu : mailNonLu, mesEffectifsMails : mesEffectifsMails])
        }
    }
}
