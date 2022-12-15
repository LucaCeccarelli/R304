package fr.univ_amu.iut.backend.joueur;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.outils.Paquet;
public class Joueur {
    private Paquet paquet;
    private String nom;

    public Joueur(String nom){
        this.paquet = new Paquet();
        this.nom = nom;
    }
    public void ajouterAuPaquet(Entite entite){
        paquet.add(entite);
    }

    public Paquet getPaquet() {
        return paquet;
    }
    @Override
    public String toString() {
        return "Joueur{" +
                "paquet=" + paquet +
                ", nom='" + nom + '\'' +
                '}';
    }
}
