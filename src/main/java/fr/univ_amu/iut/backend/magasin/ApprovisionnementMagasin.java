package fr.univ_amu.iut.backend.magasin;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.outils.FonctionAleatoire;
import fr.univ_amu.iut.backend.outils.Paquet;

/**
 * Cette classe permet d'approvisionner le magasin de l'application avec des champions déjà existants,
 * tout en triant les champions en fonction de leur rareté.
 */
public class ApprovisionnementMagasin {

    /**
     * Liste des champions déjà existants
     */
    private static Paquet listeChampionsExistants = new Paquet();
    /**
     * Liste des champions communs
     */
    private static Paquet listeCommun = new Paquet();
    /**
     * Liste des champions rares
     */
    private static Paquet listeRare = new Paquet();
    /**
     * Liste des champions légendaires
     */
    private static Paquet listeLegendaire = new Paquet();

    /**
     * Ajoute une entité à la liste des champions existants
     *
     * @param entite L'entité à ajouter
     */
    protected static void ajouterALaListeDesChampionsExistants(Entite entite){
        listeChampionsExistants.add(entite);
    }

    /**
     * Retourne la liste des champions communs
     *
     * @return La liste des champions communs
     */
    protected static Paquet getListeCommun(){
        return listeCommun;
    }

    /**
     * Retourne la liste des champions rares
     *
     * @return La liste des champions rares
     */
    protected static Paquet getListeRare(){
        return listeRare;
    }

    /**
     * Retourne la liste des champions légendaires
     *
     * @return La liste des champions légendaires
     */
    protected static Paquet getListeLegendaire(){
        return listeLegendaire;
    }

    /**
     * Rafraîchit les entités présentes dans le magasin
     *
     * @return Le paquet contenant les champion du magasin
     */
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

    /**
     * Choisi aléatoirement une entité parmi une liste
     *
     * @param listeEntite La liste des entités
     * @return L'entité choisie aléatoirement
     */
    private static Entite choisisEntiteAleatoirementParmisListe(Paquet listeEntite){
        return listeEntite.get(FonctionAleatoire.random.nextInt(0,listeEntite.size()));
    }

    /**
     * Trie les champions existants par rareté
     */
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