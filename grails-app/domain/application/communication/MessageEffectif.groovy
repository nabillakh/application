package application.communication
import application.RH.*
import application.PP.*
import application.communication.*
class MessageEffectif {

    
    Effectif recepteur
    Boolean lu 
    Boolean valider
    static constraints = {
        
        
        lu nullable : true
        valider nullable : true
        
    }
}
