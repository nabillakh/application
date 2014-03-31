package application.PP

class ActiviteController {
        
	def springSecurityService

    def activite(Integer max) {
        
        params.max = Math.min(max ?: 10, 100)
        respond Kanban.list(params), model:[KanbanInstanceCount: Kanban.count()]
    }
    
    def portefeuille(Integer max) {
        
        params.max = Math.min(max ?: 10, 100)
        respond Kanban.list(params), model:[KanbanInstanceCount: Kanban.count()]
    }
    
}
