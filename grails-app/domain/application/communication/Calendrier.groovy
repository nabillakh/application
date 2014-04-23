package application.communication

import application.RH.*

class Calendrier {

    Effectif proprietaire
    
    static hasMany = [mesEvents:Event]
    
    static constraints = {
        mesEvents nullable:true
        proprietaire nullable : true
    }
}
