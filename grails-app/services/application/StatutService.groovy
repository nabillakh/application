package application

import grails.transaction.Transactional
import application.communication.*

@Transactional
class StatutService {

 static expose = ['jms']

    def springSecurityService
    def timelineService
    
    void onMessage(newMessageUserName) {
        log.debug "Message received. New message posted by user <${newMessageUserName}>."
        def following = Effectif.where {
            followed.username == newMessageUserName
        }.property('username').list()
        following.each { uname ->
            timelineService.clearTimelineCacheForUser(uname)
        }
    }

    void updateStatus(String message) {
        def status = new Statut(message: message) 
        status.author = lookupCurrentPerson()
        status.save()
        timelineService.clearTimelineCacheForUser(status.author.username)
    }

    void follow(long personId) {
        def person = Effectif.get(personId)
        if (person) {
            def currentUser = lookupCurrentPerson()
            currentUser.addToFollowed(person)
            timelineService.clearTimelineCacheForUser(currentUser.username)
        }
    }

    private lookupCurrentPerson() {
        Effectif.get(springSecurityService.principal.id)
    }
}
