package application.PP

import grails.converters.JSON
import grails.plugins.springsecurity.Secured
import org.codehaus.groovy.grails.web.json.JSONObject
import application.pilotage.*
import application.PP.*
import application.RH.*
import application.*

import org.joda.time.DateTime

class ActiviteController {
        
	def springSecurityService
        def kanbanService
    @Secured(['IS_AUTHENTICATED_FULLY'])
    def activite(Integer max) {
        
        params.max = Math.min(max ?: 10, 100)
        respond Kanban.list(params), model:[KanbanInstanceCount: Kanban.count()]
    }
    @Secured(['IS_AUTHENTICATED_FULLY'])
    def portefeuille(Integer max) {
        def listeKanban = kanbanService.listeKanban()
        def listeFamille = kanbanService.listeFamille()
        def listePhase = kanbanService.listePhase()
        def listeOrdo = kanbanService.listeOrdo()
        def monKanban = new Kanban()
        
        def monJson = []
        // asupprimer
        listeKanban.each {unKanban ->
            def liste =  new LinkedHashMap()
            liste.put("id",unKanban.id)
            liste.put("nomKanban",unKanban.nomKanban)
            monJson << liste
        } 
        
        
        [monKanban : monKanban, kanbanInstanceList: listeKanban, familleInstanceList : listeFamille, phaseInstanceList : listePhase, ordoInstanceList : listeOrdo]
    }
    @Secured(['IS_AUTHENTICATED_FULLY'])
    def nouveauKanban() {
        def nomKanban = params.nomKanban
        DateTime dateLivraison = new DateTime(params.dateLivraison)
        def description = params.description
        def famille = params.famille
        def ordo = params.ordo
        def chargePlanifiee = Float.parseFloat(params.chargePlanifiee)
        Kanban monKanban = new Kanban()
        monKanban.nomKanban = nomKanban
        monKanban.dateFinPlanifie = dateLivraison.toDate()
        monKanban.description = description
        monKanban.famille = Famille.get(Integer.parseInt(famille))
        monKanban.ordo = Ordonnancement.get(Integer.parseInt(ordo))
        monKanban.chargePlanifiee = chargePlanifiee 
        
        println("1 nom du kanban: " + monKanban.nomKanban) 
        println("1 nom dde famille avec objet: " + monKanban.famille) 
        monKanban.save(flush : true)
        
        kanbanService.requeteCreation(monKanban)
        println("2 nom du kanban: " + monKanban.nomKanban + " id2 " + monKanban.id)
        
        
        monKanban.save(flush : true)
        
        
    }
    @Secured(['IS_AUTHENTICATED_FULLY'])
    def indicateur() {
        
    }
    // envoie data pour indicateur de 
    @Secured(['IS_AUTHENTICATED_FULLY'])
    def chargePIC = {
        def pics = Pic.list()
        // hypothese nbannee = nb pic
              
        def picLists = []
        pics.each {pic ->
            def picList = new LinkedHashMap()
            picList.put("annee",pic.annee.toString())
            
            pic.picFamille.each() { maPicFamille ->
                 picList.put((maPicFamille.famille.nom.toString()),(maPicFamille.chargePlanifie()))
            }
             picLists << (picList)
        }
        
        [picInstanceList: picLists]
        render picLists as JSON
    }
    // envoie la liste de famille pour parising dans le graphe 1
    @Secured(['IS_AUTHENTICATED_FULLY'])
    def listeFamille = {
        def fams = Famille.list()
        def famLists = []
        fams.each{ fam ->
            famLists << fam.nom.toString()
        }
        
        [famInstanceList: famLists]
        render famLists as JSON
    }
    @Secured(['IS_AUTHENTICATED_FULLY'])
    def barPIC = {
        def pics = Pic.list()
        // hypothese nbannee = nb pic
              
        def picLists = []
        pics.each {pic ->
            def picList = new LinkedHashMap()
            picList.put("annee",pic.annee.toString())
            def charge = 0
            pic.picFamille.each() { maPicFamille ->
                 charge += (maPicFamille.chargePlanifie())
            }
            picList.put("charge",charge)
             picLists << (picList)
        }
        
        [picInstanceList: picLists]
        render picLists as JSON
    }
    
    
    
    
}
