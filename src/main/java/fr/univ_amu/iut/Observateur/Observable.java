package fr.univ_amu.iut.Observateur;

public interface Observable {
    public void addObservale(Observer obj);
    public void removeObserver(Observer obj);
    public void notifyObserver();
}
