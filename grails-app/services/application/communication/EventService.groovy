package application.communication

import org.springframework.transaction.annotation.Transactional

import application.PP.*
import application.RH.*


class EventService {

    def kanbanService
    def springSecurityService
    
    def imputation(EventEffectif e, OF of)  {
        println("dans imputation service")
        def monEventOf = new Imputation(eventEffectif : e, of : of, realise : false, tempsImpute : 0)
        monEventOf.save()       
        println("creation de l'imputation?" + monEventOf.id)
      
    }
    
    def simputer(EventEffectif e, OF of) {
        def monEventOf = new Imputation(eventEffectif : e, of : of, realise : true, tempsImpute : 0)
        monEventOf.save()            
    }
    
        

           // liste des OF pour les event

    private OF[] mesOF(Effectif effectifInstance) {
        def lesOF = [] 
        println('event')
        
       
       println('perdddd')
       
        try {
            def query = OF.whereAny {
                affectes {}
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
    private EventEffectif organiserEvent(Event e) {
        def per = Effectif.get(springSecurityService.principal.id)
        def eventEffectif = new EventEffectif(event : e, recepteur : per, participe : true)
        eventEffectif.save(flush:true)
        e.organisateur=per
        e.addToParticipants(eventEffectif)
        e.save(flush:true)
        println("mon event effectif :" + eventEffectif.id)
        return eventEffectif
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
