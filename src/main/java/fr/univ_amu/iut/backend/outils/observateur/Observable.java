package fr.univ_amu.iut.backend.outils.observateur;

public interface Observable {
    public void ajoutObserver(Observer obj);
    public void effacerObserver(Observer obj);
    public void notifierObserver();
}
