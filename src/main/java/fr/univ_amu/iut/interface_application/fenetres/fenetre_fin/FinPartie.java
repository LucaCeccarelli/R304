package fr.univ_amu.iut.interface_application.fenetres.fenetre_fin;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class FinPartie extends BorderPane {
    public FinPartie(){
        super();
        victoire();
    }

    public void victoire(){
        super.setCenter(new Label("Victoire"));
    }
}
