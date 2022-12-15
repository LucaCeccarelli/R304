package fr.univ_amu.iut.interface_application.fenetres.fenetre_fin;

import javafx.scene.layout.BorderPane;

/**
 * Cette classe représente la fin d'une partie.
 */
public class FinPartie extends BorderPane {

    /**
     * Constructeur prenant en paramètre un booléen qui indique si la partie a été gagnée.
     * @param aGagne booléen indiquant si la partie a été gagnée
     */
    public FinPartie(boolean aGagne){
        super();
        choixArrierePlan(aGagne);
    }

    /**
     * Méthode qui définit selon le paramètre le style de la fin de partie.
     * @param aGagne booléen indiquant si la partie a été gagnée
     */
    public void choixArrierePlan(boolean aGagne){
        if(aGagne){
            super.setId("finDePartieVictoire");
        } else {
            super.setId("finDePartieDefaite");
        }
    }
}