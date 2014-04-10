package application.communication



import grails.test.mixin.*
import spock.lang.*

@TestFor(MailController)
@Mock(Mail)
class MailControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.mailInstanceList
            model.mailInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.mailInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            def mail = new Mail()
            mail.validate()
            controller.save(mail)

        then:"The create view is rendered again with the correct model"
            model.mailInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            mail = new Mail(params)

            controller.save(mail)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/mail/show/1'
            controller.flash.message != null
            Mail.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def mail = new Mail(params)
            controller.show(mail)

        then:"A model is populated containing the domain instance"
            model.mailInstance == mail
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def mail = new Mail(params)
            controller.edit(mail)

        then:"A model is populated containing the domain instance"
            model.mailInstance == mail
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/mail/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def mail = new Mail()
            mail.validate()
            controller.update(mail)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.mailInstance == mail

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            mail = new Mail(params).save(flush: true)
            controller.update(mail)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/mail/show/$mail.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/mail/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def mail = new Mail(params).save(flush: true)

        then:"It exists"
            Mail.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(mail)

        then:"The instance is deleted"
            Mail.count() == 0
            response.redirectedUrl == '/mail/index'
            flash.message != null
    }
}
