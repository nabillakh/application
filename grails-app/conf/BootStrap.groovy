import  application.RH.*

class BootStrap {

    def init = { servletContext ->

      def adminRole = new Droit(authority: 'ROLE_ADMIN').save(flush: true)
      def userRole = new Droit(authority: 'ROLE_USER').save(flush: true)

      def testUser = new Effectif(username: 'test', password: 'test')
      testUser.save(flush: true)

      EffectifDroit.create testUser, adminRole, true

      assert Effectif.count()== 1
      assert Droit.count() == 2
      assert EffectifDroit.count() == 1
    }
    def destroy = {
    }
        
}
