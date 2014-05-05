package application.pilotage

class PicTagLib {
    static namespace = 'pic'
    
    def kanbanService
    def eventService
    
    def mesPics = { attrs ->
        
       
       // def mesOF = eventService.mesOF()
       
        //mesOF.eachWithIndex { OF, counter ->
         //   out << g.render(template: '/pic/monPic', model: [mesOF : mesOF, ofCounter: counter])
        //} 
        out << g.render(template: '/pic/monPic')
    }
}
