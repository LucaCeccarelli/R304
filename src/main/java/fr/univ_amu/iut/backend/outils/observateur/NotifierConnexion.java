package fr.univ_amu.iut.backend.outils.observateur;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.multijoueur.serveur.Serveur;
import fr.univ_amu.iut.interface_application.fenetres.magasin.FenetreMagasin;
import javafx.scene.Scene;

public class AfficherPointDeVie implements Observer{
    private Scene scene;
    private Thread thread;
    public AfficherPointDeVie(Scene scene,Thread thread) {
        this.scene = scene;
    }

    @Override
    public void update(Observable observable) {
        System.out.println("Un clien s'est connecté");
        scene.setRoot(new FenetreMagasin());
        thread.stop();
    }
}
