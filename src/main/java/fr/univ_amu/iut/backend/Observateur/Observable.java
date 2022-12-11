package fr.univ_amu.iut.backend.Observateur;

public interface Observable {
    public void addObservale(Observer obj);
    public void removeObserver(Observer obj);
    public void notifyObserver();
}
