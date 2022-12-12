package fr.univ_amu.iut.backend.outils.multijoueur.serveur;

import fr.univ_amu.iut.backend.outils.multijoueur.SocketEchange;
import fr.univ_amu.iut.backend.outils.observateur.Observable;
import fr.univ_amu.iut.backend.outils.observateur.Observer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Serveur extends SocketEchange implements Observable {
    private ServerSocket server;

    /*
    fonction pour l'Observateur
     */
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    @Override
    public void addObserver(Observer obj) {
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
    // fin observer

    public Serveur(int port) {
        super(port);
    }

    @Override
    public void connexion() throws IOException {
            server = new ServerSocket(super.port);
            System.out.println("Serveur de jeu lancé sur le port : " + port);
            Socket client = server.accept();
            notifyObserver();
            oout = new ObjectOutputStream(client.getOutputStream());
            oin = new ObjectInputStream(client.getInputStream());

    }
}
