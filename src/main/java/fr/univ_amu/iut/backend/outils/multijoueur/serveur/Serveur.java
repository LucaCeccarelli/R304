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

    private ArrayList<Observer> observers = new ArrayList<Observer>();

    @Override
    public void ajoutObserver(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void effacerObserver(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifierObserver() {
        for (Observer obj : observers) {
            obj.mettreAJour(this);
        }
    }

    public Serveur(int port) {
        super(port);
    }

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
