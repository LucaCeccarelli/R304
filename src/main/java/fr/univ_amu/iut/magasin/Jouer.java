package fr.univ_amu.iut.magasin;

import fr.univ_amu.iut.Joueur;
import java.util.Scanner;


public class Jouer implements Runnable{

    private Joueur joueur;

    public Jouer(Joueur j){
        this.joueur=j;
    }

    @Override
    public void run() {
        Magasin magasin = new Magasin();
        magasin.trieRarete();
        for (int i = 0; i<3; ++i){
            magasin.initMagasin();
            System.out.println(magasin.getMagasin());

            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter le nom de l'entité que vous voulez acheter");
            String nomEntite = myObj.nextLine();

            while (true){
                try {
                    joueur.ajouterAuPaquet(magasin.achat(nomEntite));
                    break;
                }catch (IllegalArgumentException e){
                    System.out.println("Entite non present dans le magasin");
                    continue;
                }
            }
        }
    }
}
