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
    
    Float charge
    
    Ordonnancement ordo
    Phase phase
    Famille famille
    
    static hasMany = [compteRendus : CompteRendu]
    
    static constraints = {
        compteRendus nullable : true   
        ordo nullable : true
        phase nullable :true
        dateFinPlanifie nullable : true
        charge nullable :true
    }
    
   
    def beforeInsert = {             
        }
        
    transient afterInsert = {
    }
    
    static mappedBy = [compteRendus : 'kanban']
}
