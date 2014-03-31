package application.PP

import groovy.transform.ToString
import application.RH.*


@ToString()
class OF {

    Kanban kanban
    Phase phase
    Float charge
    
    Date dateDebutPlanifie = new Date()
    Date dateFinPlanifie = new Date()
    
    static hasMany = [affectes : Effectif] 
    
    static constraints = {
        charge nullable : true
        affectes nullable : true
    }
}
