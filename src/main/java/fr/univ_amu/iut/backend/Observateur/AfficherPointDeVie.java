package fr.univ_amu.iut.backend.Observateur;

import fr.univ_amu.iut.backend.entites.Entite;

public class AfficherPointDeVie implements Observer{

    public AfficherPointDeVie() {
    }

    @Override
    public void update(Entite entite) {
        if(entite.getPointsVie()>0){
            System.out.println(entite.getNom() + " n'a plus que " + entite.getPointsVie() + " points de vie");
        }else{
            System.out.println(entite.getNom() + " est mort (plus de point de vie)");
        }
    }
}
