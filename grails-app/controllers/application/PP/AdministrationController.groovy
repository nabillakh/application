package application.PP

class AdministrationController {

    def kanbanService
    
    def index() { }
    
    def ressource() {
        render view:'ressource'
    }
    
    def activite(Integer max) {
        // mettre a jour les listes pour filtrer au niveau d'une entreprise
        def listeKanban = kanbanService.listeKanban()
        def listeFamille = kanbanService.listeFamille()
        def listePhase = kanbanService.listePhase()
        def listeOrdo = kanbanService.listeOrdo()
        
        [kanbanInstanceList: listeKanban, familleInstanceList : listeFamille, phaseInstanceList : listePhase, ordoInstanceList : listeOrdo]
    }
}
