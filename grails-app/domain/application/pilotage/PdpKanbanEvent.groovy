package application.pilotage

import application.PP.*
import application.communication.*


class PdpKanbanEvent {
    
    Kanban kanban
    Pdp pdp
    
    Boolean kanbanReel
    
    static hasMany = [imputations : Event]

    static constraints = {
        
    }   
    
    def beforeInsert = {
        kanbanVide = false
        return true
    }
    
    def beforeUpdate = {
        dateMaj = new Date()
        return true
    }
}
