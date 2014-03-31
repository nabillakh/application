package application.PP
import groovy.transform.ToString


@ToString(includes= 'nom')
class Famille {

    String nom
    
    Ordonnancement ordo
    
    Float chargeStandard
    
    
    static constraints = {
    }
}
