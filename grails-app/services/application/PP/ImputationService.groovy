package application.PP

import grails.transaction.Transactional
import application.RH.*

@Transactional
class ImputationService {

    def springSecurityService
    
    def serviceMethod() {

    }
    
    def Imputation[] monImputation() {
        def per = Effectif.get(springSecurityService.principal.id)
        // def imputations = Imputation.list()
        
        def query = Imputation.whereAny {
                effectif {per}
            }
            
        def imputations = query.list()
        
        
    }
    
    def Date premierJour(int annee, int semaine) {
        
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.WEEK_OF_YEAR, semaine);
        calendar.set(Calendar.YEAR, annee);
        // permet d'avoir le premier jour de la semaine de la date en cours
        Date premierJour = calendar.getTime();
        return premierJour
    }
    
    def Date dernierJour(int annee, int semaine) {
        
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.WEEK_OF_YEAR, semaine);
        calendar.set(Calendar.YEAR, annee);
        calendar.add(Calendar.DATE,7)
        // permet d'avoir le premier jour de la semaine de la date en cours
        Date dernierJour = calendar.getTime();
        return dernierJour
    }
    
}
