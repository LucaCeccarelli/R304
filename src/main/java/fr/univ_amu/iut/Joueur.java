package fr.univ_amu.iut;

import fr.univ_amu.iut.entites.Entite;
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

    public String contenuPaquet(){
        String contenu = "";
        Iterator<Entite> iter = paquet.iterator();
        while (iter.hasNext()) {
            contenu += iter.next().toString();
        }
        return contenu;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "paquet=" + paquet +
                ", nom='" + nom + '\'' +
                '}';
    }
}
