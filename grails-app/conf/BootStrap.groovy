import application.RH.*
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

      def testUser = new Effectif(username: 'test', password: 'test', nom : 'Lakhmissi', prenom : 'Nabil')
      def testUser2 = new Effectif(username: 'test2', password: 'test2')
      
        maCompetence.addToEffectifs(testUser)
        maCompetence.addToEffectifs(testUser2)
        testUser.save(failOnError: true)   
        testUser2.save(failOnError: true)   

      EffectifDroit.create testUser, adminRole, true
      EffectifDroit.create testUser2, adminRole, true
                
        maCompetence.save(failOnError: true)
        
        def monMail = new Mail(author : testUser2, message:"okokokok", objet : "objet n1").save(failOnError: true)
        def monMailEffectif = new MailEffectif(mail : monMail,recepteur : testUser, lu: false, archive: false, favoris: false ).save(failOnError: true,flush: true)
                
                
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