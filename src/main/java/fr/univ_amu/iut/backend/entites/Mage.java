package fr.univ_amu.iut.backend.entites;

/**
 * Classe représentant les Mages.
 * Les Mages sont des Entites ayant des caractéristiques limitées par rapport aux autres Entites.
 *
 *  @see Entite
 */
public class Mage extends Entite {
    /**
     * Points de défense minimum.
     */
    protected final int POINTS_DE_DEFENSE_MIN = 20;

    /**
     * Points de défense maximum.
     */
    private final int POINTS_DE_DEFENSE_MAX = 80;

    /**
     * Points d'attaque maximum.
     */
    private final int POINTS_DE_ATTAQUE_MAX = 120;

    /**
     * Points de vie maximum.
     */
    private final int POINTS_DE_VIE_MAX = 200;

    /**
     * Constructeur de la classe Mage
     *
     * @param nom Nom du Mage
     * @param pointsAttaque Points d'attaque du Mage
     * @param pointsVie Points de vie du Mage
     * @param pointsDefense Points de défense du Mage
     * @param rarete Rarete du Mage
     */
    public Mage(String nom, int pointsAttaque, int pointsVie, int pointsDefense, Rarete rarete) {
        super(nom, pointsAttaque, pointsVie, pointsDefense, rarete);
    }

    /**
     * Retourne les attributs du Mage sous forme de chaîne de caractères.
     *
     * @return Les attributs du Mage sous forme de chaîne de caractères
     */
    @Override
    public String toString() {
        return "Mage{rarete=" + getRarete() + ", nom=" + getNom()
                + ", pointsAttaque=" + getPointsAttaque()
                + ", pointsDefense=" + getPointsDefense()
                + ", pointsVie=" + getPointsVie()
                + "}";
    }

    /**
     * Retourne le type du Mage
     *
     * @return Le type du Mage (Mage)
     */
    @Override
    public String getType(){
        return "Mage";
    }

    /**
     * Retourne le points de défense minimum du Mage
     *
     * @return Le points de défense minimum du Mage
     */
    @Override
    protected int getMinDef(){
        return POINTS_DE_DEFENSE_MIN;
    }

    /**
     * Retourne le points de défense maximum du Mage
     *
     * @return Le points de défense maximum du Mage
     */
    @Override
    protected int getMaxDef(){
        return POINTS_DE_DEFENSE_MAX;
    }

    /**
     * Retourne le points d'attaque maximum du Mage
     *
     * @return Le points d'attaque maximum du Mage
     */
    @Override
    protected int getMaxAtt(){return POINTS_DE_ATTAQUE_MAX;}

    /**
     * Retourne le points de vie maximum du Mage
     *
     * @return Le points de vie maximum du Mage
     */
    @Override
    protected int getMaxVie(){
        return POINTS_DE_VIE_MAX;
    }
}