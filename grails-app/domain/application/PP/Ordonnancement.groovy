package application.PP

class Ordonnancement {
    
    String nom
    Famille famille
    static hasMany = [phases : Phase]
    
    Float chargeStandard
    
    static constraints = {
        famille nullable:true
        phases nullable : true
    }
    
     static mappedBy = [famille : 'ordo']
    
}
