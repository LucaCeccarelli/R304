package fr.univ_amu.iut.backend.entites;

import fr.univ_amu.iut.backend.outils.observateur.Observable;
import fr.univ_amu.iut.backend.outils.observateur.Observer;
import fr.univ_amu.iut.backend.outils.FonctionAleatoire;
import fr.univ_amu.iut.backend.outils.Paquet;

import java.util.ArrayList;

public abstract class Entite implements Observable {

    private Rarete rarete;
    private String nom;
    private int pointsAttaque ;
    private int pointsDefense;
    private int pointsVie;

    /*
    fonction pour l'Observateur
     */
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    @Override
    public void addObservale(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void removeObserver(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObserver() {
        for (Observer obj : observers) {
            obj.update(this);
        }
    }

    public Entite(String nom, int pointsAttaque, int pointsVie, int pointsDefense, Rarete rarete){
        this.setPointsAttaque(pointsAttaque);
        this.setPointsVie(pointsVie);
        this.setPointsDefense(pointsDefense);
        this.nom = nom;
        this.rarete = rarete;
        Paquet.liste.add(this);
    }

    public Rarete getRarete() {
        return rarete;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPointsAttaque() {
        return pointsAttaque;
    }

    public void setPointsAttaque(int pointsAttaque) {
        if (pointsAttaque >= 0 && pointsAttaque <= 100) {
            this.pointsAttaque = pointsAttaque;
        } else {
            throw new IllegalArgumentException("Points d'attaque non valides (1-100)");
        }
    }



    public int getPointsDefense() {
        return pointsDefense;
    }

    public void setPointsDefense(int pointsDefense) {
        if (pointsDefense >= 0 && pointsDefense <= 100) {
            this.pointsDefense = pointsDefense;
        } else {
            throw new IllegalArgumentException("Points de défense non valides (1-100)");
        }
    }

    public int getPointsVie() {
        return pointsVie;
    }

    public void setPointsVie(int pointsVie) {
        if (pointsVie >= 0 && pointsVie <= 100) {
            this.pointsVie = pointsVie;
            notifyObserver();
        } else {
            throw new IllegalArgumentException("Points de vie non valides (1-100)");
        }
    }


    @Override
    public String toString() {
        return "Entite{" +
                "rarete=" + rarete +
                ", nom='" + nom + '\'' +
                ", pointsAttaque=" + pointsAttaque +
                ", pointsDefense=" + pointsDefense +
                ", pointsVie=" + pointsVie +
                '}';
    }

    public void attaquer(Entite adversaire) {
        int attaque;
        if (this.getPointsAttaque() > adversaire.getPointsDefense()) {
            attaque = (int) ((this.getPointsAttaque() * FonctionAleatoire.random.nextDouble(0.3, 0.5)) - (adversaire.getPointsDefense()* FonctionAleatoire.random.nextDouble(0.1, 0.5)));

        } else {
            attaque = (int) (((adversaire.getPointsDefense()* FonctionAleatoire.random.nextDouble(0.1, 0.5)-this.getPointsAttaque() * FonctionAleatoire.random.nextDouble(0.3, 0.5))));
        }
        System.out.println(attaque);
        if(adversaire.getPointsVie()-attaque < 0) {
            adversaire.setPointsVie(0);
        } else {
            adversaire.setPointsVie(getPointsVie()-attaque);
        }
        System.out.println(this.getNom() + " attaque !");
    }

    public abstract void competence();

}
