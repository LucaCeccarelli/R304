package fr.univ_amu.iut.entites;

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

    public static void main(String[] args) {
        Assassin a2 = new Assassin("Michel", 80, 50, 30, Rarete.RARE);
        Assassin a1 = new Assassin("Michou", 2, 10, 30, Rarete.COMMUN);
        a1.attaquer(a2);
        System.out.println(a2.getPointsVie());
    }
}
