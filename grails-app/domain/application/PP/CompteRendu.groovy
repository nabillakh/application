package application.PP

import application.RH.*


class CompteRendu {
    String message
    Effectif author
    OF of
    Kanban kanban
    Date dateCreated

    static constraints = {
        kanban nullable : true
        of nullable : true
    }
}