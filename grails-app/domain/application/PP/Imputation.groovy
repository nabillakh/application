package application.PP

import application.communication.*


class Imputation {
    
    OF of
    Event event
    
    Boolean realise

    static constraints = {
    }
    
    
    def beforeInsert = {             
        realise = false
        return true
    }
}
