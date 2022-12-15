package fr.univ_amu.iut;

import fr.univ_amu.iut.interface_application.fenetres.connexion.Heberger;
import fr.univ_amu.iut.interface_application.fenetres.connexion.Rejoindre;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 * Classe qui définit l'application principale.
 */
public class LancerApp extends Application {
    private BorderPane racine = new BorderPane();
    private Button rejoindre = new Button("Rejoindre");
    private Button heberger = new Button("Heberger");
    private Scene scene;

    /**
     * Méthode principale pour le démarrage de l'application.
     * @param primaryStage Stage utilisé par l'application.
     */
    @Override
    public void start(Stage primaryStage) {
        initialisationBoutons();

        HBox boutons = new HBox(rejoindre,heberger);
        racine.setCenter(boutons);
        racine.setId("arrierePlan");
        boutons.setId("conteneurBoutonsAccueil");
        scene = new Scene(racine,1280,720);
        scene.getStylesheets().add("style.css");
        primaryStage.setTitle("ECS Online");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Méthode qui s'occupe de l'initialisation des boutons de l'application.
     */
    private void initialisationBoutons(){
        rejoindre.getStyleClass().add("bouton_management");
        rejoindre.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                scene.setRoot(new Rejoindre());
            }
        });
        heberger.getStyleClass().add("bouton_management");
        heberger.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                scene.setRoot(new Heberger());
            }
        });
    }

    /**
     * Méthode principale pour l'exécution de l'application.
     * @param args Arguments passés à la méthode.
     */
    public static void main(String[] args) {
        launch();
    }
}
