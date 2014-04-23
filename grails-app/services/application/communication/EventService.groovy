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
    
    

}