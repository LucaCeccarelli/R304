package fr.univ_amu.iut.interface_application.fenetres.fenetre_fin;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class FinPartie extends BorderPane {
    private String texte ;
    public FinPartie(String texte){
        super();
        super.setId("finDePartie");
        this.texte = texte;
        messageFinPartie();
    }

    public void messageFinPartie(){
        super.setCenter(new Label(texte));
    }
}
