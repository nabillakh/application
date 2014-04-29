package application.PP

import groovy.transform.ToString
import application.RH.*


@ToString()
class OF {
// a retirer et passer en transient
    def kanbanService
    
    Kanban kanban
    Phase phase
    Float chargePlanifiee
    
    static transients = ['chargeRealisee','chargeAgenda', 'chargeRestantAPlanifier', 'chargeRestantARealiser']
    
    public Float getChargeRealisee() {
        kanbanService.chargeOFRealise(this)
    }
    public Float getChargeAgenda() {
        kanbanService.chargeOFAgenda(this)
    }
    public Float getChargeRestantAPlanifier() {
        chargePlanifiee - chargeAgenda
    }
    public Float getChargeRestantARealiser() {
        chargePlanifiee - chargeRealisee
    }
    
    
    Date dateDebutPlanifie = new Date()
    Date dateFinPlanifie = new Date()
    
    static hasMany = [affectes : Effectif] 
    
    static constraints = {
        chargePlanifiee nullable : true
        affectes nullable : true
    }
}
