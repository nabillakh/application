package application

class StatutTagLib {
    static namespace = 'twitter'
    
    def renderMessages = { attrs ->
        def messages = attrs.messages
        messages.eachWithIndex { message, counter ->
            out << g.render(template: '/status/statusMessages', model: [statusMessage: message, messageCounter: counter])
        }
    }
}
