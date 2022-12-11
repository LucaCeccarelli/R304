package fr.univ_amu.iut.backend.joueur;

import fr.univ_amu.iut.backend.entites.Entite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Joueur {
    private List<Entite> paquet;
    private String nom;

    public Joueur(String nom){
        this.paquet = new ArrayList<Entite>();
        this.nom = nom;
    }
    public void ajouterAuPaquet(Entite entite){
        paquet.add(entite);
    }

    public void enleverPaquet(Entite entite){paquet.remove(entite);}

    public String contenuPaquet(){
        String contenu = "";
        Iterator<Entite> iter = paquet.iterator();
        while (iter.hasNext()) {
            contenu += iter.next().toString();
        }
        return contenu;
    }
/**
    public ArrayList<Entite> championEnVie(){
        for (Entite e: paquet) {

        }
    }
**/
    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "paquet=" + paquet +
                ", nom='" + nom + '\'' +
                '}';
    }
}
