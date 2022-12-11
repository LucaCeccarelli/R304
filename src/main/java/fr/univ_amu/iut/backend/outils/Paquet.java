package fr.univ_amu.iut.backend.outils;

import fr.univ_amu.iut.backend.entites.Entite;

import java.util.ArrayList;
import java.util.Iterator;

public class Paquet extends ArrayList<Entite> {
    public Paquet(){
        super();
    }

    public Paquet(int capaciteIntiale){
        super(capaciteIntiale);
    }
    public void trierParPv() throws IllegalStateException{
        Entite temp;
        for (int i = this.size()-1 ; i>=1 ; i--) {
            for (int j = 0; j < i; j++) {
                if(this.get(j+1).getPointsVie()<this.get(j).getPointsVie()) {
                    temp = this.get(j+1);
                    this.set(j+1, this.get(j));
                    this.set(j, temp);
                }
            }
        }
    }

    @Override
    public String toString() {
        trierParPv();

        StringBuilder contenu = new StringBuilder("Paquet : ");
        Iterator<Entite> iter = this.iterator();
        while (iter.hasNext()) {
            contenu.append( iter.next().toString());
        }
        return contenu.toString();
    }
}
