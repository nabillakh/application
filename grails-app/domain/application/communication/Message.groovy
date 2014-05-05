package application.communication

import application.RH.*
import application.PP.*
import application.communication.*


class Message {
    
    Effectif auteur
    Kanban kanban
    
    
    Date date = new Date()
    
    String message
    
    static constraints = {
        kanban nullable : true
    }
}
