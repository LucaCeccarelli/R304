package fr.univ_amu.iut.backend.joueur;

import fr.univ_amu.iut.backend.entites.Entite;

import java.util.ArrayList;
import java.util.Iterator;

public class Joueur {
    private ArrayList<Entite> paquet;
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

    public ArrayList<Entite> getPaquet() {
        return paquet;
    }

    public Entite entiteQuiALeNom(String nom) {
        for (Entite e: paquet) {
            if(e.getNom().equals(nom)){
                return e;
            }
        }
        return null;
    }

    public void setPaquet(ArrayList<Entite> paquet) {
        this.paquet = paquet;
    }

/**
    public ArrayList<Entite> championEnVie(){
        for (Entite e: paquet) {

        }
        return null;
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
