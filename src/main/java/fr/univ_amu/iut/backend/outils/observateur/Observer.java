package fr.univ_amu.iut.backend.outils.observateur;

/**
 * Observer est une interface qui implémente le design pattern Observer.
 * Elle définit des méthodes pour observer des objets Observable.
 */
public interface Observer {
    /**
     * Cette méthode est appelée lorsque l'état d'un objet Observable est mis à jour.
     *
     * @param observable L'objet Observable qui a été mis à jour
     */
    public void mettreAJour(Observable observable);
}

