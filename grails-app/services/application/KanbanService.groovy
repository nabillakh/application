package application

import grails.validation.ValidationException
import org.springframework.transaction.annotation.Transactional
import application.PP.*


class KanbanService {

    def springSecurityService

    def serviceMethod() {

    }   
    // montre les phases auxquelles un kanban va passer
    @Transactional
    OF[] montrerOF(Kanban monKanban) {
        
        try{
            // requete SQL
            return OF.findAll("from OF as b where b.kanban=?", [monKanban])
        }
        catch (NullPointerException n) {
            return null
        }
    }        
    // montre les phases auxquelles un kanban va passer dans l'ordo initial
    @Transactional
    Phase[] montrerPhasesInitiales(Kanban kanban) {
        def ordo = kanban.getOrdo()
        try{
            return ordo.getPhases()
        }
        catch (NullPointerException n) {
            return null
        }
    }        
    // creation d'of automatique apres chaque saisie de kanban 
    @Transactional
    void requeteCreation(Kanban monKanban){
        try {
            def famille = monKanban.getFamille()
            monKanban.setOrdo(famille.getOrdo())
            def ofs = OF.findByKanban(monKanban)
            if(!ofs)  {
                for (maPhase in montrerPhasesInitiales(monKanban)) { 
                    def of = new OF(phase : maPhase, kanban : monKanban)
                    chargeInitialeOF(of)
                    of.save()
                }
            }
            else {
                throw new RuntimeException('il y a deja des OFs')
            }
        }
        catch(ValidationException e){
            System.out.println("ofs")
        }
    }    
    // permet de charger les OF au debut
    @Transactional
    void chargeInitialeOF(OF of) {
        try{
            float maCharge = ((of.getKanban().getFamille().getChargeStandard()) * (of.getPhase().getCleRepartition()))
            of.setCharge(maCharge)
        }
        catch(NullPointerException n ) {
            
        }
    }
    
    @Transactional
    CompteRendu[] afficherCRKanban(Kanban monKanban){
        try{
            // requete SQL
            return CompteRendu.findAll("from CompteRendu as b where b.kanban=?", [monKanban])
        }
        catch (NullPointerException n) {
            return null
        }
    }
    
}
