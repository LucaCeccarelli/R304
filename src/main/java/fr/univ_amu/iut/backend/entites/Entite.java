package fr.univ_amu.iut.backend.entites;

import fr.univ_amu.iut.backend.entites.exceptions.ValeursPersonnagesInvalides;
import fr.univ_amu.iut.backend.outils.FonctionAleatoire;

import java.io.Serializable;

public abstract class Entite implements Serializable {
    protected final int POINTS_DE_DEFENSE_MIN = 0;
    private final int POINTS_DE_DEFENSE_MAX = 100;
    private final int POINTS_DE_ATTAQUE_MIN = 10;
    private final int POINTS_DE_ATTAQUE_MAX = 100;
    private final int POINTS_DE_VIE_MIN = 0;
    private final int POINTS_DE_VIE_MAX = 100;
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

    public int getPointsAttaque() {
        return pointsAttaque;
    }

    public void setPointsAttaque(int pointsAttaque) {
        if (pointsAttaque < getMinAtt() || pointsAttaque > getMaxAtt()) {
            throw ValeursPersonnagesInvalides.pointsAttaqueNonValides(
                    getMinAtt(),
                    getMaxAtt(),
                    pointsAttaque);
        }
        this.pointsAttaque = pointsAttaque;
    }



    public int getPointsDefense() {
        return pointsDefense;
    }

    public void setPointsDefense(int pointsDefense) {
        if (pointsDefense < getMinDef() || pointsDefense > getMaxDef()) {
            throw ValeursPersonnagesInvalides.pointsDefenseNonValides(
                    getMinDef(),
                    getMaxDef(),
                    pointsDefense);
        }
        this.pointsDefense = pointsDefense;

    }

    public int getPointsVie() {
        return pointsVie;
    }

    public void setPointsVie(int pointsVie) {
        if (pointsDefense < getMinVie() || pointsDefense > getMaxVie()) {
            throw ValeursPersonnagesInvalides.pointsDefenseNonValides(
                    getMinVie(),
                    getMaxVie(),
                    pointsVie);
        }
        this.pointsVie = pointsVie;
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

    public void attaquer(Entite adversaire) {
        int attaque;
        attaque = (int) (this.pointsAttaque*(1.01-(adversaire.getPointsDefense()/100)));
        attaque = (int) (attaque*FonctionAleatoire.random.nextDouble(0.5, 1));
        if (adversaire.getPointsVie() <= attaque){
            adversaire.setPointsVie(0);
        } else {
            adversaire.setPointsVie(adversaire.getPointsVie()-attaque);
        }
    }
    public abstract String getType();
    protected int getMinDef(){
        return POINTS_DE_DEFENSE_MIN;
    }
    protected int getMaxDef(){
        return POINTS_DE_DEFENSE_MAX;
    }
    protected int getMinAtt(){return POINTS_DE_ATTAQUE_MIN;}
    protected int getMaxAtt(){return POINTS_DE_ATTAQUE_MAX;}
    protected int getMinVie(){
        return POINTS_DE_VIE_MIN;
    }
    protected int getMaxVie(){
        return POINTS_DE_VIE_MAX;
    }
}
