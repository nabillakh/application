package application.communication

import grails.transaction.Transactional
import application.RH.*

@Transactional
class MessageService {

    def springSecurityService
    
    
    void posterMessage(String message) {
        def status = new Message(message: message)
        status.auteur = lookupCurrentPerson()
        status.save()
    }
    
    

    private lookupCurrentPerson() {
        Effectif.get(springSecurityService.principal.id)
    }
}
