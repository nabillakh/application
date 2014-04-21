package application.PP

import grails.validation.ValidationException
import org.springframework.transaction.annotation.Transactional
import application.PP.*


class KanbanService {

    def springSecurityService

    def serviceMethod() {

    }  
   //--- pour la taglib------------- 
   
     private Kanban[] afficherKanban() {
       try { def query = Kanban.whereAny {                
           
           }
        def leskanban = query.list()
        
        
       
           return leskanban
        }
        catch (NullPointerException n){
            return null
        }
    }
    
    //--- pour la taglib'administration------------- 
   // mettre a jour les listes pour filtrer au niveau d'une entreprise
     private Kanban[] listeKanban() {
       def maListe = []
        maListe = Kanban.list(sort: "famille.nom", order: "desc")
        return maListe
    }
    
        //--- pour la taglib'administration------------- 
   // mettre a jour les listes pour filtrer au niveau d'une entreprise
     private Famille[] listeFamille() {
       def maListe = []
        maListe = Famille.list(sort: "nom", order: "desc")
        return maListe
    }
    
            //--- pour la taglib'administration------------- 
   // mettre a jour les listes pour filtrer au niveau d'une entreprise
     private Phase[] listePhase() {
       def maListe = []
        maListe = Phase.list(sort: "ordre", order: "desc")
        return maListe
    }
            //--- pour la taglib'administration------------- 
   // mettre a jour les listes pour filtrer au niveau d'une entreprise
     private Ordonnancement[] listeOrdo() {
       def maListe = []
        maListe = Ordonnancement.list()
        return maListe
    }
    
    
    
   //---------------------
    
    
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
            // monKanban.setOrdo(famille.getOrdo())
            def ofs = OF.findByKanban(monKanban)
            if(!ofs)  {
                for (maPhase in montrerPhasesInitiales(monKanban)) { 
                    def of = new OF(phase : maPhase, kanban : monKanban)
                    chargeInitialeOF(of)
                    
                    if(maPhase.ordre == 1) {
                        monKanban.phaseActuelle = maPhase
                    }
                    
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
            float maCharge = ((of.getKanban().getFamille().getChargePlanifiee()) * (of.getPhase().getCleRepartition()))
            of.setChargePlanifiee(maCharge)
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
    
    // permet de charger la charge d'une famille en requetant les kanbans associés
    // mettre periode temporelle
    private Float chargeFamille(Famille famille) {
        def listeCharge = []
        listeCharge = Kanban.findAll("from Kanban as b where b.famille=?", [famille])
        
    }
    // permet de charger la charge d'un kanban en requetant les kanbans associés
    // mettre periode temporelle
    private Float chargeKanbanPlanifie(Kanban kanban) {
        def listeCharge = []
        listeCharge = OF.findAll("from OF as b where b.kanban=?", [kanban])
        def charge = 0
        listeCharge.each() { monOF ->
            charge += monOF.charge
        }
        return charge
    }
    //
    //// permet de charger la charge realise d'un OF en requetant les imputations associées
    // mettre periode temporelle
    private Float chargeOFRealise(OF of) {
        def listeCharge = []
        listeCharge = OF.findAll("from Imputation as b where b.of=?", [of])
        def charge = 0
        listeCharge.each() { monImputation ->
            // test si l'imput est déclarée comme realisee
            if(monImputation.realise) {
                charge += monImputation.event.durationMinutes
            }
        }
        return charge
    }    
    //   //// permet de charger la charge deja dans l'agenda
    private Float chargeOFAgenda(OF of) {
        def listeCharge = []
        listeCharge = OF.findAll("from Imputation as b where b.of=?", [of])
        def charge = 0
        listeCharge.each() { monImputation ->
            charge += monImputation.event.durationMinutes
        }
        return charge
    }  
    //   rend les kanbans par famille
    // mettre par annee aussi
    private Kanban[] projetsFamille(Famille famille) {
        def listeProjets = []
        listeProjets = Kanban.findAll("from Kanban as b where b.famille=?", [famille])
        
        return listeProjets
    }
    
    
    
}
