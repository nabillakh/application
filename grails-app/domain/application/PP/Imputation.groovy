package application.PP

import application.communication.*


class Imputation {
    
    OF of
    Event event
    Float tempsImpute
    
    Boolean realise

    static constraints = {
        tempsImpute nullable : true
    }
    
}
