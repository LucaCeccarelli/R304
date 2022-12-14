package fr.univ_amu.iut.backend.entites;

import fr.univ_amu.iut.backend.outils.observateur.Observable;
import fr.univ_amu.iut.backend.outils.observateur.Observer;
import fr.univ_amu.iut.backend.outils.FonctionAleatoire;

import java.util.ArrayList;

public abstract class Entite {

    private Rarete rarete;
    private String nom;
    private int pointsAttaque ;
    private int pointsDefense;
    private int pointsVie;
    private String type;


    public Entite(String nom, int pointsAttaque, int pointsVie, int pointsDefense, Rarete rarete){
        this.setPointsAttaque(pointsAttaque);
        this.setPointsVie(pointsVie);
        this.setPointsDefense(pointsDefense);
        this.nom = nom;
        this.rarete = rarete;
    }

    public Rarete getRarete() {
        return rarete;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPointsAttaque() {
        return pointsAttaque;
    }

    public void setPointsAttaque(int pointsAttaque) {
        if (pointsAttaque >= 0 && pointsAttaque <= 100) {
            this.pointsAttaque = pointsAttaque;
        } else {
            throw new IllegalArgumentException("Points d'attaque non valides (1-100)");
        }
    }



    public int getPointsDefense() {
        return pointsDefense;
    }

    public void setPointsDefense(int pointsDefense) {
        if (pointsDefense >= 0 && pointsDefense <= 100) {
            this.pointsDefense = pointsDefense;
        } else {
            throw new IllegalArgumentException("Points de défense non valides (1-100)");
        }
    }

    public int getPointsVie() {
        return pointsVie;
    }

    public void setPointsVie(int pointsVie) {
        if (pointsVie >= 0 && pointsVie <= 100) {
            this.pointsVie = pointsVie;
        } else {
            throw new IllegalArgumentException("Points de vie non valides (1-100)");
        }
    }


    @Override
    public String toString() {
        return "Entite{" +
                "rarete=" + rarete +
                ", nom='" + nom + '\'' +
                ", pointsAttaque=" + pointsAttaque +
                ", pointsDefense=" + pointsDefense +
                ", pointsVie=" + pointsVie +
                '}';
    }

    public void recevoirDegats(int attaqueAdv) {
        int attaque;
        attaque = (int) (attaqueAdv*(1.01-(this.getPointsDefense()/100)));
        attaque = (int) (attaque*FonctionAleatoire.random.nextDouble(0.5, 1));
        if (this.getPointsVie() <= attaque){
            this.setPointsVie(0);
        } else {
            this.setPointsVie(this.getPointsVie()-attaque);
        }
    }

    public abstract void competence();
    public abstract String getType();
}
