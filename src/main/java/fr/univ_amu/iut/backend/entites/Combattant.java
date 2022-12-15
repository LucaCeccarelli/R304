package fr.univ_amu.iut.backend.entites;

/**
 * La classe Combattant hérite de la classe Entite et est utilisée pour représenter un personnage dans un jeu.
 *
 * @see Entite
 */
public class Combattant extends Entite {

    /**
     * Nombre minimal de points de défense.
     */
    protected final int POINTS_DE_DEFENSE_MIN = 100;

    /**
     * Nombre maximal de points de défense.
     */
    private final int POINTS_DE_DEFENSE_MAX = 150;

    /**
     * Nombre maximal de points d'attaque.
     */
    private final int POINTS_DE_ATTAQUE_MAX = 150;

    /**
     * Nombre maximal de points de vie.
     */
    private final int POINTS_DE_VIE_MAX = 75;

    /**
     * Constructeur de la classe.
     *
     * @param nom Le nom du Combattant.
     * @param pointsAttaque Les points d'attaque du Combattant.
     * @param pointsVie Les points de vie du Combattant.
     * @param pointsDefense Les points de defense du Combattant.
     * @param rarete La rareté du Combattant.
     */
    public Combattant(String nom, int pointsAttaque, int pointsVie, int pointsDefense, Rarete rarete) {
        super(nom, pointsAttaque, pointsVie, pointsDefense, rarete);
    }

    /**
     * Retourne une chaîne de caractères avec les informations du Combattant.
     *
     * @return Une chaîne de caractères avec les informations du Combattant.
     */
    @Override
    public String toString() {
        return "Combattant{rarete=" + getRarete() + ", nom=" + getNom()
                + ", pointsAttaque=" + getPointsAttaque()
                + ", pointsDefense=" + getPointsDefense()
                + ", pointsVie=" + getPointsVie()
                + "}";
    }

    /**
     * Retourne le type du Combattant.
     *
     * @return Le type du Combattant.
     */
    @Override
    public String getType(){
        return "Combattant";
    }

    /**
     * Retourne le nombre minimal de points de défense.
     *
     * @return Le nombre minimal de points de défense.
     */
    @Override
    protected int getMinDef(){
        return POINTS_DE_DEFENSE_MIN;
    }

    /**
     * Retourne le nombre maximal de points de défense.
     *
     * @return Le nombre maximal de points de défense.
     */
    @Override
    protected int getMaxDef(){
        return POINTS_DE_DEFENSE_MAX;
    }

    /**
     * Retourne le nombre maximal de points d'attaque.
     *
     * @return Le nombre maximal de points d'attaque.
     */
    @Override
    protected int getMaxAtt(){return POINTS_DE_ATTAQUE_MAX;}

    /**
     * Retourne le nombre maximal de points de vie.
     *
     * @return Le nombre maximal de points de vie.
     */
    @Override
    protected int getMaxVie(){
        return POINTS_DE_VIE_MAX;
    }
}