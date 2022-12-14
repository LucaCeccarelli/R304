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

public class LaunchApp extends Application {
    private BorderPane racine = new BorderPane();
    private Button rejoindre = new Button("Rejoindre");
    private Button heberger = new Button("Heberger");
    private Scene scene;
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

    private void initialisationBoutons(){
        rejoindre.getStyleClass().add("bouton_management");
        rejoindre.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Stuff
                scene.setRoot(new Rejoindre());
            }
        });
        heberger.getStyleClass().add("bouton_management");
        heberger.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Stuff
                scene.setRoot(new Heberger());
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
