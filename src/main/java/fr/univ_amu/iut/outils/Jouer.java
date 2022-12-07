
package fr.univ_amu.iut.outils;

import fr.univ_amu.iut.joueur.Joueur;
import fr.univ_amu.iut.magasin.Magasin;
import fr.univ_amu.iut.magasin.NomEntiteNonPresentDansMagasinException;

import java.util.Scanner;


public class Jouer implements Runnable{

    private Joueur joueur1;
    private Joueur joueur2;

    public Jouer (Joueur joueur1, Joueur joueur2){
        this.joueur1 =  joueur1;
        this.joueur2 = joueur2;
    }

    public void partieAchat(Joueur j){
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

    public Joueur partieCombat(){
        int tour = 0;
        boolean fin = true;
        Scanner scanner = new Scanner(System.in);
        Joueur gagnant;
        while (fin){
            System.out.println(joueur1.getNom() + " joue ");
            System.out.println(joueur1.contenuPaquet());
            System.out.println("Choisir un champion");
            String champion = scanner.nextLine();


        }
        return gagnant;
    }

    @Override
    public void run() {
        System.out.println("--- La partie va commencer ---");
        System.out.println(joueur1.getNom()+" va au magasin ");
        partieAchat(joueur1);
        System.out.println(joueur2.getNom()+" va au magasin ");
        partieAchat(joueur2);

        System.out.println("Prearez-vous au combat");
    }
}
