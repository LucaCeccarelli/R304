package fr.univ_amu.iut.backend.outils.observateur;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.multijoueur.serveur.Serveur;
import javafx.scene.Scene;

public interface Observer {
    public void update(Observable observable);
}

