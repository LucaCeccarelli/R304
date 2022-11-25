package fr.univ_amu.iut;

import fr.univ_amu.iut.entites.Assassin;
import fr.univ_amu.iut.entites.Entite;
import fr.univ_amu.iut.entites.Rarete;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Entite> entites = new ArrayList<Entite>();

        Assassin a2 = new Assassin("Michel", 2, 50, 30, Rarete.RARE);
        Assassin a3 = new Assassin("Simon", 2, 100, 30, Rarete.LEGENDAIRE);
        Assassin a4 = new Assassin("Simon2", 2, 40, 30, Rarete.RARE);

        Assassin a1 = new Assassin("Fred", 2, 50, 30, Rarete.RARE);

        System.out.println(a1.toString());
/*
        Joueur j1 = new Joueur("Jean");
        Thread t1 = new Thread(new Magasin(j1));
        t1.start();
  */

        //Collections.sort();


    }
}