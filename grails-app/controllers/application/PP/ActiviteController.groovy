package application.PP

import grails.converters.JSON
import application.pilotage.*
import application.PP.*
import application.RH.*


class ActiviteController {
        
	def springSecurityService

    def activite(Integer max) {
        
        params.max = Math.min(max ?: 10, 100)
        respond Kanban.list(params), model:[KanbanInstanceCount: Kanban.count()]
    }
    
    def portefeuille(Integer max) {
        
        params.max = Math.min(max ?: 10, 100)
        respond Kanban.list(params), model:[KanbanInstanceCount: Kanban.count()]
    }
    
    def indicateur() {
        
    }
    
    def chargePIC = {
        def pics = Pic.list()
        Long nbAnnee = pics.size()
        Long nbFamille = Famille.list().size() + 1
        // hypothese nbannee = nb pic
        def picLists = new String[nbAnnee][nbFamille]
        def i = -1 // annee
        def j = 0 // famille
        
        pics.each {pic ->
            i++
            def input = pic.annee.toString()
            picLists[i][j] = input
            
            pic.picFamille.each() { maPicFamille ->
                j++
                def nom = maPicFamille.famille.nom.toString()
                def charge = maPicFamille.chargePlanifie().toString()         
                picLists[i][j] = charge
            }
            j=0
        }
        [picInstanceList: picLists]
        render picLists as JSON
    }
    
}
