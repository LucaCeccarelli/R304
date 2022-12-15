package fr.univ_amu.iut.backend.entites;

public class Yordle extends Entite {
    private final int POINTS_DE_DEFENSE_MAX = 10;
    private final int POINTS_DE_ATTAQUE_MAX = 500;
    private final int POINTS_DE_VIE_MAX = 10;

    public Yordle(String nom, int pointsAttaque, int pointsVie, int pointsDefense, Rarete rarete) {
        super(nom, pointsAttaque, pointsVie, pointsDefense, rarete);
    }
    @Override
    public String toString() {
        return "Yordle{rarete=" + getRarete() + ", nom=" + getNom()
                + ", pointsAttaque=" + getPointsAttaque()
                + ", pointsDefense=" + getPointsDefense()
                + ", pointsVie=" + getPointsVie()
                + "}";
    }

    @Override
    public String getType(){
        return "Yordle";
    }
    @Override
    protected int getMaxDef(){
        return POINTS_DE_DEFENSE_MAX;
    }
    @Override
    protected int getMaxAtt(){return POINTS_DE_ATTAQUE_MAX;}
    @Override
    protected int getMaxVie(){
        return POINTS_DE_VIE_MAX;
    }
}
