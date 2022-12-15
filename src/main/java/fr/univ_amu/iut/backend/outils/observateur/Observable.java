package fr.univ_amu.iut.backend.outils.observateur;

/**
 * Interface Observable
 *
 * Cette interface définit des méthodes pour ajouter, effacer et notifier des objets Observer.
 */
public interface Observable {

    /**
     * Ajoute un objet Observer.
     *
     * @param obj L'objet Observer à ajouter.
     */
    public void ajoutObserver(Observer obj);

    /**
     * Efface un objet Observer.
     *
     * @param obj L'objet Observer à effacer.
     */
    public void effacerObserver(Observer obj);

    /**
     * Notifie les objets Observer.
     */
    public void notifierObserver();
}
