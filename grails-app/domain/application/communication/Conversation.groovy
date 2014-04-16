package application.communication

class Conversation {
    
    
    
    static hasMany = [mails:Mail] 
    Date lastDate 
    
    
    static constraints = {
        mails nullable : true
    }
    
    
    def beforeInsert = {
        lastDate = new Date()
        return true
    }
    
    def beforeUpdate = {
        mails.each { mail -> 
            if(mail.dateCreated >= lastDate) {
                lastDate = mail.dateCreated
            }
        }
        return true
    }
    
    
}
