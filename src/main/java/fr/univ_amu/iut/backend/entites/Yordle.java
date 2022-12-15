package fr.univ_amu.iut.backend.entites;

/**
 * Classe représentant les Yordles.
 * Les Yordles sont des Entites ayant des caractéristiques limitées par rapport aux autres Entites.
 *
 *  @see Entite
 */
public class Yordle extends Entite {

    /**
     * Points de défense maximum.
     */
    private final int POINTS_DE_DEFENSE_MAX = 10;

    /**
     * Points d'attaque maximum.
     */
    private final int POINTS_DE_ATTAQUE_MAX = 500;

    /**
     * Points de vie maximum.
     */
    private final int POINTS_DE_VIE_MAX = 10;

    /**
     * Constructeur de la classe Yordle
     *
     * @param nom Nom du Yordle
     * @param pointsAttaque Points d'attaque du Yordle
     * @param pointsVie Points de vie du Yordle
     * @param pointsDefense Points de défense du Yordle
     * @param rarete Rarete du Yordle
     */
    public Yordle(String nom, int pointsAttaque, int pointsVie, int pointsDefense, Rarete rarete) {
        super(nom, pointsAttaque, pointsVie, pointsDefense, rarete);
    }

    /**
     * Retourne les attributs du Yordle sous forme de chaîne de caractères.
     *
     * @return Les attributs du Yordle sous forme de chaîne de caractères
     */
    @Override
    public String toString() {
        return "Yordle{rarete=" + getRarete() + ", nom=" + getNom()
                + ", pointsAttaque=" + getPointsAttaque()
                + ", pointsDefense=" + getPointsDefense()
                + ", pointsVie=" + getPointsVie()
                + "}";
    }

    /**
     * Retourne le type du Yordle
     *
     * @return Le type du Yordle (Yordle)
     */
    @Override
    public String getType(){
        return "Yordle";
    }

    /**
     * Retourne le points de défense minimum du Yordle
     *
     * @return Le points de défense minimum du Yordle
     */
    @Override
    protected int getMaxDef(){
        return POINTS_DE_DEFENSE_MAX;
    }

    /**
     * Retourne le points de défense maximum du Yordle
     *
     * @return Le points de défense maximum du Yordle
     */
    @Override
    protected int getMaxAtt(){return POINTS_DE_ATTAQUE_MAX;}

    /**
     * Retourne le points de vie maximum du Yordle
     *
     * @return Le points de vie maximum du Yordle
     */
    @Override
    protected int getMaxVie(){
        return POINTS_DE_VIE_MAX;
    }
}
