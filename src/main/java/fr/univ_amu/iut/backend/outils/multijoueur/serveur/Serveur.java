package fr.univ_amu.iut.backend.outils.multijoueur.serveur;

import fr.univ_amu.iut.backend.outils.multijoueur.SocketEchange;
import fr.univ_amu.iut.backend.outils.observateur.Observable;
import fr.univ_amu.iut.backend.outils.observateur.Observer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Classe Serveur qui implémente l'interface Observable
 */
public class Serveur extends SocketEchange implements Observable {
    /**
     * Serveur
     */
    private ServerSocket server;

    /**
     * Liste des observers
     */
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    /**
     * Ajoute un nouvel Observer à la liste des Observateurs
     *
     * @param obj L'Observer à ajouter
     */
    @Override
    public void ajoutObserver(Observer obj) {
        observers.add(obj);
    }

    /**
     * Efface un Observer de la liste des Observateurs
     *
     * @param obj L'Observer à effacer
     */
    @Override
    public void effacerObserver(Observer obj) {
        observers.remove(obj);
    }

    /**
     * Notifie tous les Observateurs de la liste
     */
    @Override
    public void notifierObserver() {
        for (Observer obj : observers) {
            obj.mettreAJour(this);
        }
    }

    /**
     * Constructeur de Serveur
     *
     * @param port Le port sur lequel le Serveur va fonctionner
     */
    public Serveur(int port) {
        super(port);
    }

    /**
     * Permet d'initier la connexion du Serveur
     *
     * @throws IOException
     */
    @Override
    public void connexion() throws IOException {
        server = new ServerSocket(super.port);
        System.out.println("Serveur de jeu lancé sur le port : " + port);
        Socket client = server.accept();
        notifierObserver();
        oout = new ObjectOutputStream(client.getOutputStream());
        oin = new ObjectInputStream(client.getInputStream());

    }
}
