package application.communication

import application.RH.Effectif


class Statut {
    String message
    Effectif author
    Date dateCreated

    transient jmsService
    transient afterInsert = {
        jmsService.send 'grailstwitter.status', author.username
    }
    static constraints = {
        author nullable: true
    }
}
