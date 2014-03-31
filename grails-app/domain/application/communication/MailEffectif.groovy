package application.communication

import application.RH.*

class MailEffectif {
    
    Effectif recepteur
    Mail mail
    
    Boolean lu

    static constraints = {
        lu nullable : true
    }
}
