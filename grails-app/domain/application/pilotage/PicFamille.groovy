package application.pilotage

import application.PP.*


class PicFamille {
    
    Famille famille
    Float uniteActivite
    Integer version
    Date dateVersion
    Date dateMaj
    
    static hasMany = [pdp : Pdp]   
    
    def chargePlanifie = {
        return (famille.getChargeStandard() * uniteActivite)
    }
    
    def restantAPlanifier = {
        return uniteActivite - (float)pdp.size()
    }
    
    static constraints = {
        version nullable : true
        dateVersion nullable : true
        dateMaj nullable : true
    }
    
    static mappedBy = [pdp : 'picFamille']
    
}
