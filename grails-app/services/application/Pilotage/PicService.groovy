package application.Pilotage

import grails.transaction.Transactional
import application.PP.*
import application.pilotage.*

@Transactional
class PicService {
    
    
    def generationPicFamille(Pic pic) {
        def mesFamilles = Famille.list()
        mesFamilles.each() {fam ->
            def picFam = new PicFamille(famille : fam, uniteActivite : 24)
            generationPdp(picFam)
            pic.addToPicFamille(picFam)
            .save()
            picFam.save()
        }
    }
    
    def generationPdp(PicFamille picFam) {
        def mois = 0
        while(mois++<12) {
            def Float unite = picFam.uniteActivite / 12
            def monPdp = new Pdp(mois : mois, uniteActivite : unite)
            picFam.addToPdp(monPdp)
                .save()
            monPdp.save()
        }
    }
    
    
    def PicFamille[] listPicFamille(Pic pic) {
        def mesFamilles = Famille.list()
        def picFamListe = []
        mesFamilles.each() {fam ->
            def picFam = new PicFamille(famille : fam)
            picFamListe.add(picFam)
        }
        return picFamListe
    }  
    
}
