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
                effectif == per
            }
            
        def imputations = query.list()    
        
    }
    
    def Imputation[] monImputationEntreDates(Date deb, Date fin) {
        def per = Effectif.get(springSecurityService.principal.id)
        // def imputations = Imputation.list()
        
            Calendar calDeb = Calendar.getInstance();
            Calendar calFin = Calendar.getInstance();
            calDeb.setTime(deb);
            calFin.setTime(fin);
            
        def query = Imputation.whereAny {
                effectif == per    
            }            
        def imputations = query.list()
        
        def mesImput = []
        imputations.each() { imput ->
            Date debutEvent = imput.eventEffectif.event.startTime
            Date finEvent = imput.eventEffectif.event.endTime
            
            Calendar calDebutEvent = Calendar.getInstance();
            Calendar calFinEvent = Calendar.getInstance();
            calDebutEvent.setTime(debutEvent);
            calFinEvent.setTime(finEvent);          
            
            if((calDebutEvent.compareTo(calFin)<0)) {
                if((calFinEvent.compareTo(calDeb)<0)) {
                    mesImput.add(imput)
                }
            }
        }
        return mesImput
        
    }
    
    def monImputationEntreDatesOF(Date deb, Date fin, Imputation[] mesImput) {
        
        def lignes = []
        
        def mesOF = [] // a extraire des imputations
        mesImput.each() { imputation ->
            mesOF.add(imputation.of)
        }
        mesOF.unique()
        
        
        
        mesOF.each() { of ->
            def uneLigne = new LinkedHashMap()
            
            uneLigne.put("Of",of)
            uneLigne.put("Lundi","of")
            uneLigne.put("Mardi","of")
            uneLigne.put("Mercredi","of")
            uneLigne.put("Jeudi","of")
            uneLigne.put("Vendredi","of")  
            uneLigne.put("Samedi","of")
            uneLigne.put("Dimanche","of")  
            
            lignes << (uneLigne)
        }
        
        
       // println("montrer la hashmap : " + lignes)
        lignes.each() { ligne -> 
                println(ligne.get("Lundi"))
                println(ligne.get("Of"))
            }       
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
