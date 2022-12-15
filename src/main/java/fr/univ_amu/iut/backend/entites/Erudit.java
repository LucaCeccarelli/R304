package fr.univ_amu.iut.backend.entites;

/**
 * La classe Erudit hérite de la classe Entite et est utilisée pour représenter un personnage dans un jeu.
 *
 * @see Entite
 */
public class Erudit extends Entite {

    /**
     * Nombre minimal de points de défense.
     */
    protected final int POINTS_DE_DEFENSE_MIN = 75;

    /**
     * Nombre maximal de points de défense.
     */
    private final int POINTS_DE_DEFENSE_MAX = 150;

    /**
     * Nombre maximal de points d'attaque.
     */
    private final int POINTS_DE_ATTAQUE_MAX = 50;

    /**
     * Nombre maximal de points de vie.
     */
    private final int POINTS_DE_VIE_MAX = 80;

    /**
     * Constructeur de la classe Erudit
     * @param nom Le nom de l'erudit
     * @param pointsAttaque Les points d'attaque de l'erudit
     * @param pointsVie Les points de vie de l'erudit
     * @param pointsDefense Les points de défense de l'erudit
     * @param rarete La rareté de l'erudit
     */
    public Erudit(String nom, int pointsAttaque, int pointsVie, int pointsDefense, Rarete rarete) {
        super(nom, pointsAttaque, pointsVie, pointsDefense, rarete);
    }

    /**
     * Redéfinition de la méthode toString()
     * @return Une chaîne de caractère représentant l'erudit
     */
    @Override
    public String toString() {
        return "Erudit{rarete=" + getRarete() + ", nom=" + getNom()
                + ", pointsAttaque=" + getPointsAttaque()
                + ", pointsDefense=" + getPointsDefense()
                + ", pointsVie=" + getPointsVie()
                + "}";
    }

    /**
     * Redéfinition de la méthode getType()
     * @return Une chaîne de caractère représentant le type de l'erudit
     */
    @Override
    public String getType(){
        return "Erudit";
    }

    /**
     * Redéfinition de la méthode getMinDef()
     * @return Les points de défense minimum de l'erudit
     */
    @Override
    protected int getMinDef(){
        return POINTS_DE_DEFENSE_MIN;
    }

    /**
     * Redéfinition de la méthode getMaxDef()
     * @return Les points de défense maximum de l'erudit
     */
    @Override
    protected int getMaxDef(){
        return POINTS_DE_DEFENSE_MAX;
    }

    /**
     * Redéfinition de la méthode getMaxAtt()
     * @return Les points d'attaque maximum de l'erudit
     */
    @Override
    protected int getMaxAtt(){return POINTS_DE_ATTAQUE_MAX;}

    /**
     * Redéfinition de la méthode getMaxVie()
     * @return Les points de vie maximum de l'erudit
     */
    @Override
    protected int getMaxVie(){
        return POINTS_DE_VIE_MAX;
    }
}
