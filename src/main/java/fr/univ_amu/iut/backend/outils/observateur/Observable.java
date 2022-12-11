package fr.univ_amu.iut.backend.outils.observateur;

public interface Observable {
    public void addObservale(Observer obj);
    public void removeObserver(Observer obj);
    public void notifyObserver();
}
