package application.PP

import application.RH.*
import groovy.transform.ToString

@ToString(includes='nom') 
class Phase {

    String nom
    Long ordre
    Float cleRepartition
    
    Competence competence    
    Ordonnancement monOrdo
    
    static hasMany = [kanbans : Kanban]
    
    
    static constraints = {
        kanbans nullable : true
        cleRepartition nullable : true
        competence nullable : true
    }
    
    static mappedBy = [kanbans : 'phase']
}
