package fr.univ_amu.iut.backend.entites;

/**
 * Classe Assassin qui est une sous-classe d'Entite.
 *
 * @see Entite
 */
public class Assassin extends Entite {
    /**
     * Les points de défense minimum pour cette classe
     */
    private final int POINTS_DE_DEFENSE_MIN = 30;

    /**
     * Les points de défense maximum pour cette classe
     */
    private final int POINTS_DE_DEFENSE_MAX = 50;

    /**
     * Les points d'attaque minimum pour cette classe
     */
    private final int POINTS_DE_ATTAQUE_MIN = 50;

    /**
     * Les points d'attaque maximum pour cette classe
     */
    private final int POINTS_DE_ATTAQUE_MAX = 150;

    /**
     * Les points de vie maximum pour cette classe
     */
    private final int POINTS_DE_VIE_MAX = 60;

    /**
     * Constructeur de la classe Assassin
     * @param nom Le nom de l'assassin
     * @param pointsAttaque Les points d'attaque de l'assassin
     * @param pointsVie Les points de vie de l'assassin
     * @param pointsDefense Les points de défense de l'assassin
     * @param rarete La rareté de l'assassin
     */
    public Assassin(String nom, int pointsAttaque, int pointsVie, int pointsDefense, Rarete rarete) {
        super(nom, pointsAttaque, pointsVie, pointsDefense, rarete);
    }

    /**
     * Méthode toString qui permet de retourner une chaîne de caractères correspondant à l'assassin
     * @return la chaîne de caractères correspondant à l'assassin
     */
    @Override
    public String toString() {
        return "Assassin{rarete=" + getRarete() + ", nom=" + getNom()
                + ", pointsAttaque=" + getPointsAttaque()
                + ", pointsDefense=" + getPointsDefense()
                + ", pointsVie=" + getPointsVie()
                + "}";
    }

    /**
     * Méthode getType qui permet de retourner le type de l'assassin
     * @return le type de l'assassin
     */
    @Override
    public String getType(){
        return "Assasin";
    }

    /**
     * Méthode getMinDef qui permet de retourner le nombre minimum de points de défense de l'assassin
     * @return le nombre minimum de points de défense de l'assassin
     */
    @Override
    protected int getMinDef(){
        return POINTS_DE_DEFENSE_MIN;
    }

    /**
     * Méthode getMaxDef qui permet de retourner le nombre maximum de points de défense de l'assassin
     * @return le nombre maximum de points de défense de l'assassin
     */
    @Override
    protected int getMaxDef(){
        return POINTS_DE_DEFENSE_MAX;
    }

    /**
     * Méthode getMinAtt qui permet de retourner le nombre minimum de points d'attaque de l'assassin
     * @return le nombre minimum de points d'attaque de l'assassin
     */
    @Override
    protected int getMinAtt(){return POINTS_DE_ATTAQUE_MIN;}

    /**
     * Méthode getMaxAtt qui permet de retourner le nombre maximum de points d'attaque de l'assassin
     * @return le nombre maximum de points d'attaque de l'assassin
     */
    @Override
    protected int getMaxAtt(){return POINTS_DE_ATTAQUE_MAX;}

    /**
     * Méthode getMaxVie qui permet de retourner le nombre maximum de points de vie de l'assassin
     * @return le nombre maximum de points de vie de l'assassin
     */
    @Override
    protected int getMaxVie(){
        return POINTS_DE_VIE_MAX;
    }
}
