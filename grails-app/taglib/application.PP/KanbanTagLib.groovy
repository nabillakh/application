package application.PP
import application.PP.KanbanService
class KanbanTagLib {
    static namespace = 'kanbans'
    
    def kanbanService
    def eventService
    
    def kanbanmini = { attrs ->
        
       
       def mesOF = eventService.mesOF()
       
        mesOF.eachWithIndex { OF, counter ->
            out << g.render(template: '/kanban/minikanban', model: [mesOF : mesOF, ofCounter: counter])
        }
    }
}