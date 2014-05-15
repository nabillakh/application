package application.PP

import grails.transaction.Transactional

@Transactional
class ImputationService {

    def springSecurityService
    
    def serviceMethod() {

    }
    
    def Imputation[] monImputation() {
        def per = Effectif.get(springSecurityService.principal.id)
        def imputations = Imputation.list()
        
    }
    
}
