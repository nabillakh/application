package application.PP

import grails.transaction.Transactional
import application.PP.*
import application.RH.*

@Transactional
class CompteRenduService {

    static expose = ['jms']

    def springSecurityService
    def timelineService
    def kanbanService
    
    void onMessage(newMessageUserName, Kanban monKanban) {
        try {
        log.debug "Message received. New message posted by user <${newMessageUserName}>."
        kanbanService.montrerOF(monKanban).each { uname ->
            timelineService.clearTimelineCacheForUser(uname)
        }
        }
        catch (NullPointerException n) {
            timelineService.clearTimelineCacheForUser(username)
        }
    }

    void updateCompteRendu(String message) {
        def status = new CompteRendu(message: message) 
        status.author = lookupCurrentPerson()
        status.save()
    }
    
    
    void updateCompteRendu(String message, Long kanban) {
        try {
            def leKanban = lookupCurrentKanban(kanban)
            def status = new CompteRendu(message: message, kanban:leKanban)
            status.author = lookupCurrentPerson()
            leKanban.addToCompteRendus(status)
            leKanban.save()
            status.save() 
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
