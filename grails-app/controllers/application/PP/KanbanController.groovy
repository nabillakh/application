package application.PP

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import application.*
import grails.plugins.springsecurity.Secured
import grails.plugins.springsecurity.Secured
import java.text.SimpleDateFormat
import org.joda.time.DateTime
import application.RH.*
import application.communication.*

@Transactional(readOnly = true)
class KanbanController {

    def kanbanService
    def messageService
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "POST"]
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Kanban.list(params), model:[kanbanInstanceCount: Kanban.count()]
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def show(Kanban kanbanInstance) {
        println(kanbanInstance.id)
        def ofs = kanbanService.montrerOF(kanbanInstance)
        println("charger des of ok")
        def mesCR = kanbanService.afficherCRKanban(kanbanInstance)
        
        println("charger des cr ok")
        [kanbanInstance:kanbanInstance, ofs : ofs, mesCR : mesCR]
    }
    
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def create() {
        respond new Kanban(params)
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def save(Kanban kanbanInstance) {
        println("dans save")
        println(params.dateLancement)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd")
        Date dateFinPlanifie = sdf.parse(params.dateFinPlanifie)
        Date dateLancement = sdf.parse(params.dateLancement)
        kanbanInstance.setDateFinPlanifie(dateFinPlanifie)
        kanbanInstance.setDateLancement(dateLancement)
        
        println(kanbanInstance.dateFinPlanifie)
        kanbanInstance.save(flush: true)
        println(kanbanInstance.id)
        if (!kanbanInstance.save(flush: true)) {
            render(view: "create", model: [kanbanInstance: kanbanInstance])
            return
        }
            // ajouter par NL
            // permet de creer des OF a la creation d'un Kanban
            
        kanbanService.requeteCreation(kanbanInstance)

        flash.message = message(code: 'default.created.message', args: [message(code: 'kanban.label', default: 'Kanban'), kanbanInstance.id])
        // redirect(action: "show", id: kanbanInstance.id)
        redirect(action:"index")
    }
    
    def nouveauKanban() {
        def nomKanban = params.nomKanban
        println("date dans input ")
        println(params.dateLivraison)
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy")
        Date dateLivraison = sdf.parse(params.dateLivraison)
        
        println(dateLivraison)
        def description = params.description
        def famille = params.famille
        def ordo = params.ordo
        def chargePlanifiee = Float.parseFloat(params.chargePlanifiee)
        def chefProjet = params.chefProjet
        def monId = params.monId
        def monKanban 
        if(!monId) {
            println("creation de kanban avec id :" + monId)
            monKanban = new Kanban()        
            monKanban.nomKanban = nomKanban
            monKanban.dateFinPlanifie = dateLivraison
            monKanban.description = description
            monKanban.chefProjet = Effectif.get(Integer.parseInt(chefProjet))
            monKanban.famille = Famille.get(Integer.parseInt(famille))
            monKanban.ordo = Ordonnancement.get(Integer.parseInt(ordo))
            monKanban.chargePlanifiee = chargePlanifiee 
            monKanban.save(flush : true)
        }
        else {
            println("edition de kanban avec id :" + monId)
            monKanban = Kanban.get(monId)
            println(monKanban.nomKanban)  
            monKanban.nomKanban = nomKanban
            monKanban.dateFinPlanifie = dateLivraison
            monKanban.description = description
            monKanban.chefProjet = Effectif.get(Integer.parseInt(chefProjet))
            monKanban.famille = Famille.get(Integer.parseInt(famille))
            monKanban.ordo = Ordonnancement.get(Integer.parseInt(ordo))
            monKanban.chargePlanifiee = chargePlanifiee 
            monKanban.save(flush : true)
        }
        
        
        kanbanService.requeteCreation(monKanban)        
        monKanban.save(flush : true)
        // redirect(action:"index")
        redirect(action: "gestionOf", id: monKanban.id)
         
    }
    
    def gestionOf(Kanban kanbanInstance) {
        def dateLIst = []
        def mesof = new ArrayList<OF>()
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy")
        kanbanInstance.of.each() {of -> 
            mesof.add(of)
            def datedeb = sdf.format(of.dateDebutPlanifie)
             def datefin = sdf.format(of.dateFinPlanifie)
            dateLIst << [
                id: of.id,    
                start:datedeb,
                end: datefin,
                ]
        }
            
       
        // appeller la fonction qui donne le dernier mail pour chaque conversation
        mesof.sort{a,b-> a.phase.ordre<=>b.phase.ordre}
          
          
          
        [kanbanInstance:kanbanInstance,mesof:mesof,dateLIst:dateLIst]
    }
    
    // permet d'editer les OF d'un kanban
    def majOF() {  
        println("dans majOF")
        // rapatriement et conversion des variables
        
        println(params.dateDebutPlanifie)
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy")
        Date dateDebutPlanifie = sdf.parse(params.dateDebutPlanifie)
        
        println(dateDebutPlanifie)
        Date dateFinPlanifie = sdf.parse(params.dateFinPlanifie)
        println("date maj" + dateFinPlanifie)
        def id = Long.parseLong(params.monId)
        
        println(id)
        def charge = Float.parseFloat(params.charge)
       def affectes = []
        def affect = params.affectes
        
        println(affect)
        List<String> items = Arrays.asList(affect.split("\\s*,\\s*"));
        items.each() {aff->
            def affs = Effectif.findById(Long.parseLong(aff))
            affectes.add(affs)        
        }
        
        println(affectes)
        // recherche of
        def ancienOf = OF.findById(id) 
        println(ancienOf.phase.nom)
        // maj de l'of
        println("charge "+charge)
        ancienOf.setChargePlanifiee(charge)
        println(ancienOf.chargePlanifiee)
        ancienOf.setDateFinPlanifie(dateFinPlanifie)
        println(ancienOf.dateFinPlanifie)
        ancienOf.setDateDebutPlanifie(dateDebutPlanifie)
        //ancienOf.setAffectes(affectes)        
        
        println(ancienOf.dateDebutPlanifie)
        // permet d'ajouter des effectifs sur l'of et envoie un message automatiquement
        affectes.each() {nvEff ->
                println("dans boucle" + nvEff)
            if(ancienOf.affectes.find {it.id == nvEff.id}) {
            }   
            else {
                println("nv effectif" + nvEff.id)
                ancienOf.affectes.add(nvEff)
                messageService.posterMessageKanban("Vous êtes chargé d'une nouvelle activité" , ancienOf.kanban.id)
            }
        }
        
        // permet de supprimer des effectifs sur l'of et envoie un message automatiquement
        ancienOf.affectes.each() {ancienEff ->
            if(affectes.find {it.id == ancienEff.id}) {
            }   
            else {
                ancienOf.removeFromAffectes(ancienEff)
                messageService.posterMessageKanban("Vous avez été déchargé d'une activité" , ancienOf.kanban.id)
            }
        }
        
        
        
        ancienOf.save(flush:true)
        
    }
    
    
    
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def edit(Kanban kanbanInstance) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy")
        def dateFin = sdf.format(kanbanInstance.dateFinPlanifie)
        def dateDeb = sdf.format(kanbanInstance.dateLancement)
        [kanbanInstance : kanbanInstance, dateFin : dateFin, dateDeb : dateDeb]
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def update(Kanban kanbanInstance) {
        if (kanbanInstance == null) {
            notFound()
            return
        }

        if (kanbanInstance.hasErrors()) {
            respond kanbanInstance.errors, view:'edit'
            return
        }

        kanbanInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Kanban.label', default: 'Kanban'), kanbanInstance.id])
                redirect kanbanInstance
            }
            '*'{ respond kanbanInstance, [status: OK] }
        }
    }

    
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def delete() {
       
     def monId = params.kanban
     def kanbanInstance = Kanban.get(monId)
     kanbanInstance.delete flush:true
        redirect(action: "index")
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'kanbanInstance.label', default: 'Kanban'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    
    
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def obtenirKanbanEffectif() {
        println(params.effectif + "ok")
        def kanbanInstanceList = kanbanService.listeKanbanEffectif()
        [kanbanInstanceList:kanbanInstanceList]
    }
    
    
       
}