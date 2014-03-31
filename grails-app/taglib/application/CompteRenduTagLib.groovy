package application

class CompteRenduTagLib {
    static namespace = 'compteRendus'
    
    def renderMessages = { attrs ->
        def messages = attrs.messages
        messages.eachWithIndex { message, counter ->
            out << g.render(template: '${request.contextPath}/kanban/compteRenduMessages', model: [compteRenduMessage: message, messageCounter: counter])
        }
    }
}
