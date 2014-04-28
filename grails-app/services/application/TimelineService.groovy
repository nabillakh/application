package application

import grails.transaction.Transactional
import application.RH.*
import application.communication.*
import application.PP.*

@Transactional
class TimelineService {
    
    static transactional = false

    void clearTimelineCacheForUser(String username) {}
    
    void clearTimelineCacheForKanban(Kanban monKanban) {}

    def getTimelineForUser(String username) {
        def per = Effectif.findByUsername(username)
        try { def query = Statut.whereAny {
            author { username == per.username }
        }.order 'dateCreated', 'desc'
        def messages = query.list(max: 10)
        messages
        }
        catch (NullPointerException n){
            
        }
    }
    
    def getTimelineForOF(OF monOF) {
        try { def query = CompteRendu.whereAny {of == monOF }.order 'dateCreated', 'desc'
            
        def messages = query.list(max: 15)
        messages
        }
        catch (NullPointerException n){
            
        }
    }
    
        def getTimelineForKanban(Kanban monKanban) {
        try { def query = CompteRendu.whereAny {kanban == monKanban }.order 'dateCreated', 'desc'
            def messages = query.list(max: 15)
            messages
        }
        catch (NullPointerException n){
            
        }
    }
    
    
}
