package application.communication

import application.RH.*

class MailEffectif {
    
    Effectif recepteur
    Mail mail
    Date dateCreated= new Date()
    
    Boolean lu = false
    Boolean archive = false
    Boolean favoris = false
 
    static constraints = {
        lu nullable : true
    }
    
    def beforeInsert = {
    }
    
}
