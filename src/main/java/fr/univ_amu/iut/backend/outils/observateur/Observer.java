package fr.univ_amu.iut.backend.outils.observateur;

import fr.univ_amu.iut.backend.entites.Entite;

public interface Observer {
    public void update(Observable observable);
}

