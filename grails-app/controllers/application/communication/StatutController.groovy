package application.communication

import grails.plugins.springsecurity.Secured

import application.StatutService
import application.TimelineService

@Secured('IS_AUTHENTICATED_REMEMBERED')
class StatutController {


    def statutService
    def timelineService
    def springSecurityService

    def index() {
        def messages = timelineService.getTimelineForUser(springSecurityService.principal.username)
        [statusMessages: messages]
    }

    def updateStatus(String message) {
        statutService.updateStatus(message)
        def messages = timelineService.getTimelineForUser(springSecurityService.principal.username)
        
        def content = twitter.renderMessages messages: messages
        render content
    }

    def follow(long id) {
        statusService.follow id
        redirect action: 'index'
    }
}
