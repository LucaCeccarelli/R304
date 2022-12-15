package fr.univ_amu.iut.backend.entites;

public class Assassin extends Entite {

    protected final int POINTS_DE_DEFENSE_MIN = 30;
    private final int POINTS_DE_DEFENSE_MAX = 50;
    private final int POINTS_DE_ATTAQUE_MIN = 50;
    private final int POINTS_DE_ATTAQUE_MAX = 150;
    private final int POINTS_DE_VIE_MAX = 60;
    public Assassin(String nom, int pointsAttaque, int pointsVie, int pointsDefense, Rarete rarete) {
        super(nom, pointsAttaque, pointsVie, pointsDefense, rarete);
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
    @Override
    protected int getMinDef(){
        return POINTS_DE_DEFENSE_MIN;
    }
    @Override
    protected int getMaxDef(){
        return POINTS_DE_DEFENSE_MAX;
    }
    @Override
    protected int getMinAtt(){return POINTS_DE_ATTAQUE_MIN;}
    @Override
    protected int getMaxAtt(){return POINTS_DE_ATTAQUE_MAX;}
    @Override
    protected int getMaxVie(){
        return POINTS_DE_VIE_MAX;
    }
}
