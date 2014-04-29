package application.PP

import groovy.transform.ToString
import application.RH.*
import application.communication.*


@ToString(includes='nomKanban')
class Kanban {
     
    String nomKanban
    String description
    
    Date dateLancement= new Date()
    Date dateFinPlanifie= new Date()
    
    Float chargePlanifiee
    
    Ordonnancement ordo
    Phase phaseActuelle
    Famille famille 
    
    static hasMany = [compteRendus : CompteRendu, of:OF]
    
    static transients = ['chargePlanifiee']
    
    
    
    
    static constraints = {
        compteRendus nullable : true   
        ordo nullable : true
        phaseActuelle nullable :true
        dateFinPlanifie nullable : true
        chargePlanifiee nullable :true
        of nullable:true
    }
    
   
    def beforeInsert = {             
        }
        
    transient afterInsert = {
    }
    
    static mappedBy = [compteRendus : 'kanban', of : 'kanban']
}
