package fr.univ_amu.iut.backend.entites;

import fr.univ_amu.iut.backend.entites.exceptions.ValeursPersonnagesInvalides;
import fr.univ_amu.iut.backend.outils.FonctionAleatoire;

import java.io.Serializable;

public abstract class Entite implements Serializable {
    /**
     * Les points de défense minimum pour cette classe
     */
    protected final int POINTS_DE_DEFENSE_MIN = 0;

    /**
     * Nombre maximal de points de défense.
     */
    private final int POINTS_DE_DEFENSE_MAX = 100;

    /**
     * Les points d'attaque minimum pour cette classe
     */
    private final int POINTS_DE_ATTAQUE_MIN = 10;

    /**
     * Nombre maximal de points d'attaque.
     */
    private final int POINTS_DE_ATTAQUE_MAX = 100;

    /**
     * Les points de vie minimum pour cette classe
     */
    private final int POINTS_DE_VIE_MIN = 0;

    /**
     * Nombre maximal de points de vie.
     */
    private final int POINTS_DE_VIE_MAX = 100;

    /**
     * La rarete de l'entité
     */
    private Rarete rarete;

    /**
     * Le nom de l'entité
     */
    private String nom;

    /**
     * Les points d'attaque de l'entité
     */
    private int pointsAttaque ;

    /**
     * Les points de defense de l'entité
     */
    private int pointsDefense;

    /**
     * Les points de vie de l'entité
     */
    private int pointsVie;

    /**
     * Constructeur de la classe Entité.
     *
     * @param nom Le nom de l'entité.
     * @param pointsAttaque Les points d'attaque de l'entité.
     * @param pointsVie Les points de vie de l'entité.
     * @param pointsDefense Les points de defense de l'entité.
     * @param rarete La rareté de l'entité.
     */
    public Entite(String nom, int pointsAttaque, int pointsVie, int pointsDefense, Rarete rarete){
        this.setPointsAttaque(pointsAttaque);
        this.setPointsVie(pointsVie);
        this.setPointsDefense(pointsDefense);
        this.nom = nom;
        this.rarete = rarete;
    }

    /**
     * Permet de récupérer la rareté de l'entité
     * @return la rareté de l'entité
     */
    public Rarete getRarete() {
        return rarete;
    }

    /**
     * Permet de récupérer le nom de l'entité
     * @return le nom de l'entité
     */
    public String getNom() {
        return nom;
    }

    /**
     * Permet de récupérer les points d'attaque de l'entité
     * @return les points d'attaque de l'entité
     */
    public int getPointsAttaque() {
        return pointsAttaque;
    }

    /**
     * Permet de modifier les points d'attaque de l'entité
     * @param pointsAttaque les points d'attaque de l'entité
     * @throws ValeursPersonnagesInvalides si les points d'attaque ne sont pas compris entre getMinAtt() et getMaxAtt()
     */
    public void setPointsAttaque(int pointsAttaque) {
        if (pointsAttaque < getMinAtt() || pointsAttaque > getMaxAtt()) {
            throw ValeursPersonnagesInvalides.pointsAttaqueNonValides(
                    getMinAtt(),
                    getMaxAtt(),
                    pointsAttaque);
        }
        this.pointsAttaque = pointsAttaque;
    }

    /**
     * Permet de récupérer les points de défense de l'entité
     * @return les points de défense de l'entité
     */
    public int getPointsDefense() {
        return pointsDefense;
    }

    /**
     * Permet de modifier les points de défense de l'entité
     * @param pointsDefense les points de défense de l'entité
     * @throws ValeursPersonnagesInvalides si les points de défense ne sont pas compris entre getMinDef() et getMaxDef()
     */
    public void setPointsDefense(int pointsDefense) {
        if (pointsDefense < getMinDef() || pointsDefense > getMaxDef()) {
            throw ValeursPersonnagesInvalides.pointsDefenseNonValides(
                    getMinDef(),
                    getMaxDef(),
                    pointsDefense);
        }
        this.pointsDefense = pointsDefense;

    }

    /**
     * Permet de récupérer les points de vie de l'entité
     * @return les points de vie de l'entité
     */
    public int getPointsVie() {
        return pointsVie;
    }

    /**
     * Permet de modifier les points de vie de l'entité
     * @param pointsVie les points de vie de l'entité
     * @throws ValeursPersonnagesInvalides si les points de vie ne sont pas compris entre getMinVie() et getMaxVie()
     */
    public void setPointsVie(int pointsVie) {
        if (pointsVie < getMinVie() || pointsVie > getMaxVie()) {
            throw ValeursPersonnagesInvalides.pointsVieNonValides(
                    getMinVie(),
                    getMaxVie(),
                    pointsVie);
        }
        this.pointsVie = pointsVie;
    }

    /**
     * Permet de récupérer les informations de l'entité sous forme de chaîne de caractères
     * @return les informations de l'entité sous forme de chaîne de caractères
     */
    @Override
    public String toString() {
        return "Entite{" +
                "rarete=" + rarete +
                ", nom='" + nom + '\'' +
                ", pointsAttaque=" + pointsAttaque +
                ", pointsDefense=" + pointsDefense +
                ", pointsVie=" + pointsVie +
                '}';
    }

    /**
     * Permet à l'entité d'attaquer un adversaire
     * @param adversaire l'entité adversaire
     */
    public void attaquer(Entite adversaire) {
        int attaque;
        attaque = (int) (this.pointsAttaque*(1.01-(adversaire.getPointsDefense()/150)));
        attaque = (int) (attaque*FonctionAleatoire.random.nextDouble(0.5, 1));
        if (adversaire.getPointsVie() <= attaque){
            adversaire.setPointsVie(0);
        } else {
            adversaire.setPointsVie(adversaire.getPointsVie()-attaque);
        }
    }

    /**
     * Permet de récupérer le type de l'entité
     * @return le type de l'entité
     */
    public abstract String getType();

    /**
     * Permet de récupérer le minimum de points de défense
     * @return le minimum de points de défense
     */
    protected int getMinDef(){
        return POINTS_DE_DEFENSE_MIN;
    }

    /**
     * Permet de récupérer le maximum de points de défense
     * @return le maximum de points de défense
     */
    protected int getMaxDef(){
        return POINTS_DE_DEFENSE_MAX;
    }

    /**
     * Permet de récupérer le minimum de points d'attaque
     * @return le minimum de points d'attaque
     */
    protected int getMinAtt(){return POINTS_DE_ATTAQUE_MIN;}

    /**
     * Permet de récupérer le maximum de points d'attaque
     * @return le maximum de points d'attaque
     */
    protected int getMaxAtt(){return POINTS_DE_ATTAQUE_MAX;}

    /**
     * Permet de récupérer le minimum de points de vie
     * @return le minimum de points de vie
     */
    protected int getMinVie(){
        return POINTS_DE_VIE_MIN;
    }

    /**
     * Permet de récupérer le maximum de points de vie
     * @return le maximum de points de vie
     */
    protected int getMaxVie(){
        return POINTS_DE_VIE_MAX;
    }
}
