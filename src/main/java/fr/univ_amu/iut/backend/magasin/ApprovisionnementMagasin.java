package fr.univ_amu.iut.backend.magasin;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.outils.FonctionAleatoire;
import fr.univ_amu.iut.backend.outils.Paquet;

import java.util.ArrayList;

public class ApprovisionnementMagasin {
    private static ArrayList<Entite> listeCommun = new ArrayList<Entite>();
    private static ArrayList<Entite> listeRare = new ArrayList<Entite>();
    private static ArrayList<Entite> listeLegendaire = new ArrayList<Entite>();
    protected ArrayList<Entite> getListeCommun(){
        return listeCommun;
    }

    protected ArrayList<Entite> getListeRare(){
        return listeRare;
    }

    protected ArrayList<Entite> getListeLegendaire(){
        return listeLegendaire;
    }

    protected static ArrayList<Entite> raffrechirEntitesDansMagasin(){
        ArrayList<Entite> magasin = new ArrayList<>(5);

        int nbrAlea;
        while(magasin.size()<5){
            nbrAlea = FonctionAleatoire.random.nextInt(0,101);
            if(nbrAlea<20 && listeLegendaire.isEmpty() == false){
                magasin.add( choisisEntiteAleatoirementParmisListe(listeLegendaire) );
            } else if (nbrAlea<60 && listeRare.isEmpty() == false) {
                magasin.add( choisisEntiteAleatoirementParmisListe(listeRare) );
            } else if (listeCommun.isEmpty() == false){
                magasin.add( choisisEntiteAleatoirementParmisListe(listeCommun) );
            }
        }
        return magasin;
    }

    private static Entite choisisEntiteAleatoirementParmisListe(ArrayList<Entite> listeEntite){
        return listeEntite.get(FonctionAleatoire.random.nextInt(0,listeEntite.size()));
    }

    protected static void trieRarete(){
        for (Entite entite: Paquet.liste) {
            switch (entite.getRarete()){
                case RARE -> listeRare.add(entite);
                case COMMUN -> listeCommun.add(entite);
                case LEGENDAIRE -> listeLegendaire.add(entite);
            }
        }

    }
}
