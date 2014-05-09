package application.communication

import org.springframework.transaction.annotation.Transactional

import application.PP.*
import application.RH.*


class EventService {

    def kanbanService
    def springSecurityService
    
    def imputation(Event e, OF of)  {
        def monEventOf = new Imputation(event : e, of : of, realise : false)
        monEventOf.save()       
      
    }
    
    def simputer(Event e, OF of) {
        def monEventOf = new Imputation(event : e, of : of, realise : true)
        monEventOf.save()            
    }
    
        

           // liste des OF pour les event

    private OF[] mesOF() {
        def lesOF = [] 
        def per = Effectif.get(springSecurityService.principal.id)
        try {
            def query = OF.whereAny {
                affectes {per}
            }
            lesOF = query.list()
        }
        
        catch (NullPointerException n){
        }
        
        return lesOF
    }
           // liste des OF pour la to do list de la semaine

    private OF[] maToDo() {
        def lesOF = [] 
        def aujourdhui = new Date()
        def per = Effectif.get(springSecurityService.principal.id)
        try {
            def query = OF.whereAny {
                affectes {per}
                dateFinPlanifie > aujourdhui + 1
            }
            lesOF = query.list()
        }
        
        catch (NullPointerException n){
        }
        
        return lesOF
    }
    
    // associe l'organisateur aux participants à la création de l'event
    private void organiserEvent(Event e) {
        def per = Effectif.get(springSecurityService.principal.id)
        def eventEffectif = new EventEffectif(event : e, recepteur : per, participe : true)
        eventEffectif.save(flush:true)
        e.organisateur=per
        e.addToParticipants(eventEffectif)
        e.save(flush:true)
    }

     // liste d'event concernant le principal
     
    private Event[] mesEvent() {
        def lesEventEffectif = [] 
        def lesEvent = [] 
        def per = Effectif.get(springSecurityService.principal.id)
        try {
            def query = EventEffectif.whereAny {
                recepteur == per
            }
            lesEventEffectif = query.list()
            lesEventEffectif.each() { ee ->
                lesEvent.add(ee.event)            
            }
        }
        
        catch (NullPointerException n){
        }
        
        return lesEvent
    }
    
    

}