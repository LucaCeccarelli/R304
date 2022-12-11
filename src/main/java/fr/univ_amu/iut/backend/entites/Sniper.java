package fr.univ_amu.iut.backend.entites;

public class Sniper extends Entite {

    public Sniper(String nom, int pointsAttaque, int pointsVie, int pointsDefense, Rarete rarete) {
        super(nom, pointsAttaque, pointsVie, pointsDefense, rarete);
    }

    @Override
    public void competence() {
        System.out.println("tue de loin");
    }

    @Override
    public String toString() {
        return "Sniper{rarete=" + getRarete() + ", nom=" + getNom()
                + ", pointsAttaque=" + getPointsAttaque()
                + ", pointsDefense=" + getPointsDefense()
                + ", pointsVie=" + getPointsVie()
                + "}";
    }

    @Override
    public String getType(){
        return "Sniper";
    }
}
