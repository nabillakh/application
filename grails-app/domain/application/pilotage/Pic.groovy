package application.pilotage

class Pic {

    Integer annee
    Integer version
    Date dateVersion
    Date dateMaj
    
    static hasMany = [picFamille : PicFamille]
    
    
    static constraints = {
        version nullable : true
        dateVersion nullable : true
        dateMaj nullable : true
    }
}
