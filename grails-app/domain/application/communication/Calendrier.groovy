package application.communication

class Calendrier {

    String nom
    
    static hasMany = [mesEvents:Event]
    
    static constraints = {
        mesEvents nullable:true
    }
}
