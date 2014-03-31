import  application.RH.*
import application.communication.*
import application.PP.*

class BootStrap {

    def init = { servletContext ->

      createData()
        
    }
    def destroy = {
    }
    
    private void createData() {
        def kanbanService
        
        def maCompetence= new Competence( nom:"developpeur")
        
        ["VBA", "Java", "PHP", "Python"].each {nomA -> 
            def competence = new Competence(nom:nomA).save(failOnError: true)
        }
        
        def adminRole = new Droit(authority: 'ROLE_ADMIN').save(flush: true)
      def userRole = new Droit(authority: 'ROLE_USER').save(flush: true)

      def testUser = new Effectif(username: 'test', password: 'test')
      def testUser2 = new Effectif(username: 'test2', password: 'test2')
      
        maCompetence.addToEffectifs(testUser)
        testUser.save(failOnError: true)     
      // def monMessage = new Statut(message : 'okokok', author :testUser, dateCreated : new Date())
      // monMessage.save(flush:true)

      EffectifDroit.create testUser, adminRole, true
                
        maCompetence.save(failOnError: true)

      assert Effectif.count()== 1
      assert Droit.count() == 2
      assert EffectifDroit.count() == 1
                
        def monOrdo = new Ordonnancement(nom : "grille1").save(failOnError: true) 
        
        def maFamille = new Famille(nom : "Famille1", ordo : monOrdo, chargeStandard : '200').save(failOnError: true)  
        
        def monKanban = new Kanban( nomKanban : "developpement fonction 1" , description : "c'est un kanban",  statut: "en cours", famille : maFamille)
        
        
        
        ["Analyse":1, "Algorithme":2, "Developpement":3, "Test":4, "Mise en prod":5].each {nomA,numA -> 
            def phase = new Phase(nom : nomA,ordre:numA, competence:maCompetence, cleRepartition : 2)
            monKanban.setPhase(phase)
            monOrdo.addToPhases(phase)
            phase.save(failOnError: true)
        }
        
        
        monKanban.setOrdo(monOrdo)
        monOrdo.save(failOnError: true)
        monKanban.save(failOnError: true)
    }
        

        
}
