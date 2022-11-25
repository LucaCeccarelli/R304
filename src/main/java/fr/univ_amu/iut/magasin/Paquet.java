package fr.univ_amu.iut.magasin;

import fr.univ_amu.iut.entites.Entite;
import java.util.ArrayList;

public class Paquet {

    public static ArrayList<Entite> liste = new ArrayList<Entite>();

    public static ArrayList<Entite> trierParPv(ArrayList<Entite> tab) throws IllegalStateException{
        Entite temp;
        for (int i = tab.size()-1 ; i>=1 ; i--) {
            for (int j = 0; j < i; j++) {
                if(tab.get(j+1).getPointsVie()<tab.get(j).getPointsVie()) {
                    temp = tab.get(j+1);
                    tab.set(j+1, tab.get(j));
                    tab.set(j, temp);
                }
            }
        }
        return tab;
    }
}
