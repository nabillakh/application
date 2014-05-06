package application.PP

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import application.*
import grails.plugins.springsecurity.Secured
import grails.plugins.springsecurity.Secured
import java.text.SimpleDateFormat
import org.joda.time.DateTime
import application.RH.*

@Transactional(readOnly = true)
class KanbanController {

    def kanbanService
    def compteRenduService
    def timelineService
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Kanban.list(params), model:[kanbanInstanceCount: Kanban.count()]
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def show(Kanban kanbanInstance) {
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
        DateTime dateLivraison = new DateTime(params.dateLivraison)
        def description = params.description
        def famille = params.famille
        def ordo = params.ordo
        def chargePlanifiee = Float.parseFloat(params.chargePlanifiee)
        def chefProjet = params.chefProjet
        def monKanban = new Kanban()
        
            monKanban.nomKanban = nomKanban
            monKanban.dateFinPlanifie = dateLivraison.toDate()
            monKanban.description = description
            monKanban.chefProjet = Effectif.get(Integer.parseInt(chefProjet))
            monKanban.famille = Famille.get(Integer.parseInt(famille))
            monKanban.ordo = Ordonnancement.get(Integer.parseInt(ordo))
            monKanban.chargePlanifiee = chargePlanifiee 
            
            monKanban.save(flush : true)
        
        
        kanbanService.requeteCreation(monKanban)        
        monKanban.save(flush : true)
        // redirect(action:"index")
        redirect(action: "gestionOf", id: monKanban.id)
         
    }
    
    def gestionOf(Kanban kanbanInstance) {
        [kanbanInstance:kanbanInstance]
    }
    
    
    def majOF() {  
        println("ancienOf.phase.nom")
        def id = Long.parseLong(params.monId)
        def ancienOf = OF.findById(id)     
        println(ancienOf.phase.nom)
        def monKanban = ancienOf.kanban
        println(monKanban.nomKanban)
        
    }
    
    
    
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def edit(Kanban kanbanInstance) {
        respond kanbanInstance
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

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def delete(Kanban kanbanInstance) {

        if (kanbanInstance == null) {
            notFound()
            return
        }

        kanbanInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Kanban.label', default: 'Kanban'), kanbanInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
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
    def updateCompteRendu(String message, Long kanban) {
        
        println("controleur updateCR" + message + kanban)
        compteRenduService.updateCompteRendu(message , kanban)
        render "<script>obtenirCompteRendu()</script>"
    }
    
    
    def obtenirCompteRendu(Long kanban) {
        println("ok")
        println(kanban)
        def monKanban = Kanban.get(kanban)
        def mesCR = kanbanService.afficherCRKanban(monKanban)
        [mesCR:mesCR.reverse()]
    }
       
}
