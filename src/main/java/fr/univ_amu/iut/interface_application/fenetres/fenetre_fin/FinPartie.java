package fr.univ_amu.iut.interface_application.fenetres.fenetre_fin;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class FinPartie extends BorderPane {
    public FinPartie(boolean aGagne){
        super();
        choixArrierePlan(aGagne);
    }

    public void choixArrierePlan(boolean aGagne){
        if(aGagne){
            super.setId("finDePartieVictoire");
        } else {
            super.setId("finDePartieDefaite");
        }
    }
}
