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
    
    def toDoList = {attrs -> 
    
    def maToDo = eventService.maToDo()
    def maCharge = kanbanService.chargeEffectifRealise()
    maToDo.eachWithIndex { Of, counter ->
            out << g.render(template: '/kanban/maToDo', model: [maToDo : maToDo, ofCounter: counter, maCharge : maCharge])      
        }
    
    }
}