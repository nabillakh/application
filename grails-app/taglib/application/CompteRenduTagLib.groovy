package application

import application.PP.*

class CompteRenduTagLib {
    static namespace = 'compteRendus'
    
    def kanbanService
    def compteRenduService  
    def timelineService
    
    def renderMessagesKanban = { attrs ->
        def messages = timelineService.getTimelineForKanban(Kanban.get(1))
        messages.eachWithIndex { message, counter ->
            out << g.render(template: '${request.contextPath}/kanban/compteRenduMessages', model: [compteRenduMessage: message, messageCounter: counter])
        }
    }
}
