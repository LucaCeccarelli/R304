package fr.univ_amu.iut.interface_application.fenetres.connexion;

import fr.univ_amu.iut.backend.outils.multijoueur.client.Client;
import fr.univ_amu.iut.interface_application.fenetres.magasin.FenetreMagasin;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;


/**
 * Classe representant le panneau de connexion d'un client a un serveur
 *
 * @author Nom Prénom
 */
public class Rejoindre extends BorderPane {
    private TextField entreeDeTexte = new TextField();
    private Button rejoindre = new Button("Rejoindre");

    private VBox conteneurBoutonZoneTexte = new VBox();
    private static Client client;

    /**
     * Constructeur par défaut
     */
    public Rejoindre(){
        super();
        super.setId("arrierePlan_rejoindre");
        initialisationsElements();
        initialisationBoutons();
        super.setCenter(conteneurBoutonZoneTexte);
    }

    /**
     * Initialise les boutons de connexion
     */
    private void initialisationBoutons(){
        rejoindre.getStyleClass().add("bouton_management");
        rejoindre.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                client = new Client(entreeDeTexte.getText(),10013);

                try {
                    client.connexion();
                    Rejoindre.super.getScene().setRoot(new FenetreMagasin());
                } catch (IOException ex) {
                    entreeDeTexte.setText("");
                    entreeDeTexte.setPromptText("Une erreur c'est produite, essayez à un nouveau");
                }
            }
        });
    }

    /**
     * Initialise les elements du panneau
     */
    public void initialisationsElements(){
        entreeDeTexte.setPromptText("IP de l'hébergeur");
        entreeDeTexte.setId("entreeIpRejoindre");
        conteneurBoutonZoneTexte.setId("conteneurElementsRejoindre");
        conteneurBoutonZoneTexte.getChildren().addAll(entreeDeTexte, rejoindre);
        rejoindre.setDefaultButton(true);
    }

    /**
     * Getter de la variable client
     *
     * @return le client
     */
    public static Client getClient() {
        return client;
    }
}