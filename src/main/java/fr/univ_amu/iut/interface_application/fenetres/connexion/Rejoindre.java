package fr.univ_amu.iut.interface_application.fenetres.connexion;

import fr.univ_amu.iut.backend.outils.multijoueur.client.Client;
import fr.univ_amu.iut.interface_application.fenetres.magasin.FenetreMagasin;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Rejoindre extends BorderPane {
    private TextField entreeDeTexte = new TextField();
    private Label texteDeExplication = new Label("Entrez l'adresse de l'hebergeur");
    private Button rejoindre = new Button("Rejoindre");
    private static Client client;
    public Rejoindre(){
        super();
        super.setTop(texteDeExplication);
        super.setCenter(entreeDeTexte);
        initialisationBoutons();
        super.setBottom(rejoindre);
    }

    private void initialisationBoutons(){
        rejoindre.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Stuff
                client = new Client(entreeDeTexte.getText(),10013);

                try {
                    client.connexion();
                    Rejoindre.super.getScene().setRoot(new FenetreMagasin());
                } catch (IOException ex) {
                    entreeDeTexte.setText("Une erreur c'est produite, essayez à un nouveau");
                    //throw new RuntimeException(ex);
                }
            }
        });
    }

    public static Client getClient() {
        return client;
    }
}
