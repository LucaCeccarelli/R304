package fr.univ_amu.iut.backend.entites;

public class Assassin extends Entite {

    public Assassin(String nom, int pointsAttaque, int pointsVie, int pointsDefense, Rarete rarete) {
        super(nom, pointsAttaque, pointsVie, pointsDefense, rarete);
    }

    @Override
    public void competence() {
        System.out.println("tue dans le dos");
    }

    @Override
    public String toString() {
        return "Assassin{rarete=" + getRarete() + ", nom=" + getNom()
                + ", pointsAttaque=" + getPointsAttaque()
                + ", pointsDefense=" + getPointsDefense()
                + ", pointsVie=" + getPointsVie()
                + "}";
    }
    @Override
    public String getType(){
     return "Assasin";
    }
}
