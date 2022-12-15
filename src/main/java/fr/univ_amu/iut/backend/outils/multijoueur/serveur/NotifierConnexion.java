package fr.univ_amu.iut.backend.outils.multijoueur.serveur;

import fr.univ_amu.iut.backend.outils.observateur.Observable;
import fr.univ_amu.iut.backend.outils.observateur.Observer;
import fr.univ_amu.iut.interface_application.fenetres.magasin.FenetreMagasin;
import javafx.scene.Scene;

/**
 * Cette classe représente un observateur de connexion.
 * Il est notifié lorsqu'un client se connecte.
 */
public class NotifierConnexion implements Observer {
    private Scene scene;

    /**
     * Constructeur pour objets de la classe NotifierConnexion
     *
     * @param scene La scène à afficher lorsque le client se connecte
     */
    public NotifierConnexion(Scene scene) {
        this.scene = scene;

    }

    /**
     * Implémentation de la méthode mettreAJour de l'interface Observer.
     *
     * @param observable L'objet observable qui a été modifié
     */
    @Override
    public void mettreAJour(Observable observable) {
        System.out.println("Un client s'est connecté");
        scene.setRoot(new FenetreMagasin());
    }
}
