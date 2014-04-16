package application.communication

class Conversation {
    
    
    
    static hasMany = [mails:Mail] 
    Date lastDate = new Date()
    
    
    static constraints = {
        mails nullable : true
    }
    
    
    def beforeInsert = {
    }
    
    def beforeUpdate = {
    }
    
    
}
