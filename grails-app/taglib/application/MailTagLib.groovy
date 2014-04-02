package application

class MailTagLib {
    static namespace = 'messagerie'
    
    def miniMessagerie = { attrs ->
        def mesMails = attrs.mesMail
        mesMails.eachWithIndex { mail, counter ->
            out << g.render(template: '${request.contextPath}/mail/miniInbox', model: [mailMessage: mail, messageCounter: counter])
        }
    }
}
