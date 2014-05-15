package application.PP

import application.communication.*


class Imputation {
    
    OF of
    EventEffectif eventEffectif
    Float tempsImpute
    
    Boolean realise

    static constraints = {
        tempsImpute nullable : true
    }
    
}
