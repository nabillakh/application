package application

import grails.transaction.Transactional

@Transactional
class TimelineService {
    
    static transactional = false

    void clearTimelineCacheForUser(String username) {}

    def getTimelineForUser(String username) {
        def per = Effectif.findByUsername(username)
        def query = Statut.whereAny {
            author { username == per.username }
            if(per.followed) author in per.followed
        }.order 'dateCreated', 'desc'
        def messages = query.list(max: 10)
        messages
    }
}
