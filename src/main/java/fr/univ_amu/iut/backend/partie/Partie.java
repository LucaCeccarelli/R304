package fr.univ_amu.iut.backend.partie;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.joueur.Joueur;
import fr.univ_amu.iut.backend.magasin.Magasin;
import fr.univ_amu.iut.backend.magasin.NomEntiteNonPresentDansMagasinException;

import java.util.Scanner;

public class Partie {
    protected static void phaseAchat(Joueur joueur){
        Magasin magasin = new Magasin();

        for (int i = 0; i < 3; ++i){
            magasin.initMagasin();
            System.out.println(magasin.getMagasin());

            Scanner scanner = new Scanner(System.in);

            while(true){
                System.out.println("Choisir un champion");
                String champion = scanner.nextLine();
                try{
                    joueur.ajouterAuPaquet(magasin.achat(champion));
                    break;
                }catch(NomEntiteNonPresentDansMagasinException e){
                    System.out.println("Le champion n'est pas dans le magasin");
                }
            }
        }
    }

    protected static void phaseCombat(Joueur joueur1,Joueur joueur2) throws InterruptedException {
        /**
        int tour = 0;
        boolean fin = false;
        Joueur gagnant = null;
        int scoreJ1 = 0;
        int scoreJ2 = 0;
        Entite championJ1 = null;
        Entite championJ2 = null;
        String choix;
        Scanner scanner = new Scanner(System.in);
        while (fin){
            if(tour != 0) {
                System.out.println("Continuer avec d'autres champions ? | Non pour stopper");
                if ((scanner.next().equals("Non"))) {
                    fin = true;
                }
            }
            System.out.println(joueur1.getNom() + " joue ");
            System.out.println(joueur1.contenuPaquet());
            System.out.println("Choisir un champion");
            while (championJ1.equals(null)) {
                choix = scanner.next();
                if(joueur1.contenuPaquet().contains(choix)) {
                    championJ1 = joueur1.entiteQuiALeNom(choix);
                    break;
                } else {
                    System.out.println("Nom d'entité inconnu, réessayer");
                }
            }
            System.out.println(joueur2.getNom() + " joue ");
            System.out.println(joueur2.contenuPaquet());
            System.out.println("Choisir un champion");
            while (championJ2.equals(null)) {
                choix = scanner.next();
                if(joueur2.contenuPaquet().contains(choix)) {
                    championJ2 = joueur2.entiteQuiALeNom(choix);
                    break;
                } else {
                    System.out.println("Nom d'entité inconnu, réessayer");
                }
            }
            System.out.println("Le combat commence !");
            while (championJ1.getPointsVie() != 0 && championJ2.getPointsVie() != 0) {
                championJ1.attaquer(championJ2);
                Thread.sleep(2000);
                championJ2.attaquer(championJ1);
            }
            if(championJ1.getPointsVie() == 0) {
                scoreJ2 += 1;
            } else {
                scoreJ1 += 1;
            }
            tour += 1;
            System.out.println("Vous avez fait " + tour + " tour de jeu");
            System.out.println("Le joueur 1 a tué " + scoreJ1 + " champions du joueur 2");
            System.out.println("Le joueur 2 a tué " + scoreJ2 + " champions du joueur 1");
            if (scoreJ1 > scoreJ2) {
                gagnant = joueur1;
            } else if (scoreJ2 > scoreJ1) {
                gagnant = joueur2;
            } else {
                System.out.println("Pour l'instant égalité entre les scores");
                gagnant = null;
            }
            if (tour == 5){
                System.out.println("Vous avez utilisé tous vos champions, fin du combat");
            }
        }
        if (gagnant == null) {
            System.out.println("Egalité entre les joueurs");
        }
        return gagnant;**/
    }

}
