package application.RH

class Equipe {

    String nom
    
    static hasMany = [effectifs : Effectif]
    
    static constraints = {
        effectifs nullable : true
    }
}
