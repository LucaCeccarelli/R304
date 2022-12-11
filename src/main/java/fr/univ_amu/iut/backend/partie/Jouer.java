
package fr.univ_amu.iut.backend.partie;

import fr.univ_amu.iut.backend.joueur.Joueur;


public class Jouer implements Runnable{

    @Override
    public void run() {
        System.out.println("--- La partie va commencer ---");

        Joueur joueur1 = new Joueur("J1");
        Joueur joueur2 = new Joueur("J2");

        System.out.println(joueur1.getNom()+" va au magasin ");
        Partie.phaseAchat(joueur1);
        System.out.println(joueur2.getNom()+" va au magasin ");
        Partie.phaseAchat(joueur2);

        System.out.println("Prearez-vous au combat");
    }
}
