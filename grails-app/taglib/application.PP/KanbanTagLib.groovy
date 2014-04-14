package application.PP
import application.PP.KanbanService
class KanbanTagLib {
    static namespace = 'kanbans'
    
    def KanbanService
    
    
    def kanbanmini = { attrs ->
        
       
       def meskanbans = KanbanService.afficherKanban()
     
       
       
        meskanbans.eachWithIndex { kanban, counter ->
            out << g.render(template: '/kanban/minikanban', model: [meskanbans : meskanbans, kanabanCounter: counter])
        }
    }
}