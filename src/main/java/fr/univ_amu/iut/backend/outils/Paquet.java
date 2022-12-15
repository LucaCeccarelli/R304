package fr.univ_amu.iut.backend.outils;

import fr.univ_amu.iut.backend.entites.Entite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe Paquet qui hérite de la classe ArrayList pour manipuler des entités.
 */
public class Paquet extends ArrayList<Entite> {

    /**
     * Constructeur par défaut.
     */
    public Paquet(){
        super();
    }

    /**
     * Constructeur qui prend en paramètre la capacité initiale.
     *
     * @param capaciteIntiale La capacité initiale du paquet
     */
    public Paquet(int capaciteIntiale){
        super(capaciteIntiale);
    }

    /**
     * Trie les entités du paquet par leur points de vie.
     *
     * @throws IllegalStateException Si le tri est impossible
     */
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

    /**
     * Retourne une chaîne de caractères représentant le contenu du paquet.
     *
     * @return Une chaîne représentant le contenu du paquet.
     */
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
