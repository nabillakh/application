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
            println("dans message service")
            def leKanban = lookupCurrentKanban(kanban)
            println("reconstruction kanban" + leKanban.nomKanban)
            def status = new Message(message: message, kanban:leKanban)
            status.auteur = lookupCurrentPerson()
            println("auteur : " + status.auteur.nom)
            println("kanban associe : " + status.kanban.nomKanban)
            // leKanban.addToCompteRendus(status)
            // println("leKanban compteRendus")
            // leKanban.save()
            status.save()
            println(status.id + " : nv cr")
        }
        catch(NullPointerException n) {}
        
        
    }
    
    

    private lookupCurrentPerson() {
        Effectif.get(springSecurityService.principal.id)
    }
    
    
    private lookupCurrentKanban(Long id) {
        Kanban.get(id)
    }
}
