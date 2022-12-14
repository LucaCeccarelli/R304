package fr.univ_amu.iut.backend.outils.multijoueur.serveur;

import fr.univ_amu.iut.backend.outils.observateur.Observable;
import fr.univ_amu.iut.backend.outils.observateur.Observer;
import fr.univ_amu.iut.interface_application.fenetres.magasin.FenetreMagasin;
import javafx.scene.Scene;

public class NotifierConnexion implements Observer {
    private Scene scene;
    public NotifierConnexion(Scene scene) {
        this.scene = scene;

    }

    @Override
    public void update(Observable observable) {
        System.out.println("Un client s'est connecté");
        scene.setRoot(new FenetreMagasin());
    }
}
