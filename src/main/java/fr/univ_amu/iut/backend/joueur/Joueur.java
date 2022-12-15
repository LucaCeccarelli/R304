package fr.univ_amu.iut.backend.joueur;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.outils.Paquet;

/**
 * La classe Joueur représente un joueur d'un jeu.
 */
public class Joueur {

    /**
     * Attribut correspondant au paquet du joueur.
     */
    private Paquet paquet;
    /**
     * Attribut correspondant au nom du joueur.
     */
    private String nom;

    /**
     * Construit un joueur à partir de son nom.
     *
     * @param nom le nom du joueur
     */
    public Joueur(String nom){
        this.paquet = new Paquet();
        this.nom = nom;
    }

    /**
     * Ajoute une entité au paquet du joueur.
     *
     * @param entite l'entité à ajouter
     */
    public void ajouterAuPaquet(Entite entite){
        paquet.add(entite);
    }

    /**
     * Retourne le paquet du joueur.
     *
     * @return le paquet du joueur
     */
    public Paquet getPaquet() {
        return paquet;
    }

    /**
     * Retourne une chaine de caractères correspondant à l'objet Joueur.
     *
     * @return une chaine de caractères correspondant à l'objet Joueur
     */
    @Override
    public String toString() {
        return "Joueur{" +
                "paquet=" + paquet +
                ", nom='" + nom + '\'' +
                '}';
    }
}
