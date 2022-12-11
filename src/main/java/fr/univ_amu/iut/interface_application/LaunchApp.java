package fr.univ_amu.iut.interface_application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LaunchApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("aa");
        StackPane s = new StackPane();
        primaryStage.setScene(new Scene(s));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
