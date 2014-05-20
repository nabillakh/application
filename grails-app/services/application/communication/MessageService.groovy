package application.communication

import grails.transaction.Transactional
import application.RH.*
import application.PP.*

@Transactional
class MessageService {

    def springSecurityService
    
    
    void posterMessage(String message) {
        def status = new Message(message: message)
        status.auteur = lookupCurrentPerson()
        status.save()
    }
    
    
    void posterMessageKanban(String message, Long kanban) {
        try {
            
            def leKanban = lookupCurrentKanban(kanban)
            def status = new Message(message: message, kanban:leKanban)
            status.auteur = lookupCurrentPerson()
            // leKanban.addToCompteRendus(status)
            // println("leKanban compteRendus")
            // leKanban.save()
            status.save()
            println(status.id + " : nv cr")
        }
        catch(NullPointerException n) {}
    }
    
    def listeMessageAuteurEffectif(Effectif effectif) { 
        println("dans service")
        def mesMessages = Message.findAll("from Message as b where b.auteur=?", [effectif])
        return mesMessages
    }
    
    
    
    def nbMessageKanban(Message[] mesMessages) { 
        println("dans service nbMessageKanban")
        def nbMessage = 0
        mesMessages.each() {message ->
            if(message.kanban) {
                nbMessage +=1
            }
        }
        return nbMessage
        
    }
    
    
    def nbMessageAutre(Message[] mesMessages) { 
        def nbMessage = mesMessages.size() - nbMessageKanban(mesMessages)
        return nbMessage
    }
    

    private lookupCurrentPerson() {
        Effectif.get(springSecurityService.principal.id)
    }
    
    
    private lookupCurrentKanban(Long id) {
        Kanban.get(id)
    }
}
