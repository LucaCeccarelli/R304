package fr.univ_amu.iut.partie;

import fr.univ_amu.iut.joueur.Joueur;
import fr.univ_amu.iut.magasin.Magasin;
import fr.univ_amu.iut.magasin.NomEntiteNonPresentDansMagasinException;

import java.util.Scanner;

public class Partie {
    public static void phaseAchat(Joueur j){
        Magasin magasin = new Magasin();
        magasin.trieRarete();

        for (int i = 0; i < 3; ++i){
            magasin.initMagasin();
            System.out.println(magasin.getMagasin());

            Scanner scanner = new Scanner(System.in);

            while(true){
                System.out.println("Choisir un champion");
                String champion = scanner.nextLine();
                try{
                    j.ajouterAuPaquet(magasin.achat(champion));
                    break;
                }catch(NomEntiteNonPresentDansMagasinException e){
                    System.out.println("Le champion n'est pas dans le magasin");
                }
            }
        }
    }

    public static Joueur phaseCombat(Joueur joueur1,Joueur joueur2){
        int tour = 0;
        boolean fin = true;
        Scanner scanner = new Scanner(System.in);
        Joueur gagnant;
        while (fin){
            System.out.println(joueur1.getNom() + " joue ");
            System.out.println(joueur1.contenuPaquet());
            System.out.println("Choisir un champion");
            String champion = scanner.nextLine();

            //TODO : Comment gagner
        }
        return joueur1;
    }

}
