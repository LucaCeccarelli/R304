package fr.univ_amu.iut.backend.magasin;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.outils.FonctionAleatoire;
import fr.univ_amu.iut.backend.outils.Paquet;

public class ApprovisionnementMagasin {
    private static Paquet listeChampionsExistants = new Paquet();
    private static Paquet listeCommun = new Paquet();
    private static Paquet listeRare = new Paquet();
    private static Paquet listeLegendaire = new Paquet();

    protected static void ajouterALaListeDesChampionsExistants(Entite entite){
        listeChampionsExistants.add(entite);
    }
    protected Paquet getListeCommun(){
        return listeCommun;
    }

    protected Paquet getListeRare(){
        return listeRare;
    }

    protected Paquet getListeLegendaire(){
        return listeLegendaire;
    }

    protected static Paquet raffrechirEntitesDansMagasin(){
        Paquet magasin = new Paquet(5);

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

    private static Entite choisisEntiteAleatoirementParmisListe(Paquet listeEntite){
        return listeEntite.get(FonctionAleatoire.random.nextInt(0,listeEntite.size()));
    }

    protected static void trieRarete(){
        for (Entite entite: listeChampionsExistants) {
            switch (entite.getRarete()){
                case RARE -> listeRare.add(entite);
                case COMMUN -> listeCommun.add(entite);
                case LEGENDAIRE -> listeLegendaire.add(entite);
            }
        }

    }
}
