package fr.univ_amu.iut.backend.magasin;

import fr.univ_amu.iut.backend.entites.Assassin;
import fr.univ_amu.iut.backend.entites.Rarete;
import fr.univ_amu.iut.backend.entites.Yordle;

public class InitListeChampionsExistants {
    public static void InitListe(){
        //Creation Entites
        Assassin a2 = new Assassin("Michel", 20, 50, 30, Rarete.RARE);
        Assassin a3 = new Assassin("Simon", 15, 100, 30, Rarete.LEGENDAIRE);
        Assassin a4 = new Assassin("Simon2", 50, 40, 30, Rarete.RARE);
        Assassin a1 = new Assassin("Fred1", 30, 50, 30, Rarete.RARE);
        Yordle y1 = new Yordle("Fred3", 25, 50, 30, Rarete.COMMUN);
        Yordle y2 = new Yordle("Fred2", 30, 50, 30, Rarete.LEGENDAIRE);

        //Ajout à la liste
        ApprovisionnementMagasin.ajouterALaListeDesChampionsExistants(a1);
        ApprovisionnementMagasin.ajouterALaListeDesChampionsExistants(a2);
        ApprovisionnementMagasin.ajouterALaListeDesChampionsExistants(a3);
        ApprovisionnementMagasin.ajouterALaListeDesChampionsExistants(a4);
        ApprovisionnementMagasin.ajouterALaListeDesChampionsExistants(y1);
        ApprovisionnementMagasin.ajouterALaListeDesChampionsExistants(y2);
    }
}
