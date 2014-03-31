package application.PP

class Ordonnancement {
    
    String nom
    static hasMany = [phases : Phase]
    
    static constraints = {
        phases nullable : true
    }
}
