package application.communication

import org.springframework.transaction.annotation.Transactional

import application.PP.*


class EventService {

    
    def imputation(Event e, OF of)  {
        def monEventOf = new Imputation(event : e, of : of)
        monEventOf.save()       
      
    }
    
    def simputer(Event e, OF of) {
        def monEventOf = new Imputation(event : e, of : of, realise : true)
        monEventOf.save()            
    }

}