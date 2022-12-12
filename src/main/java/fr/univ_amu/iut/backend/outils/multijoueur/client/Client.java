package fr.univ_amu.iut.backend.outils.multijoueur.client;

import fr.univ_amu.iut.backend.outils.multijoueur.SocketEchange;

import java.io.*;
import java.net.Socket;

public class Client extends SocketEchange {
    private String nomDomaine;
    private Socket socketClient;;

    public Client(String nomDomaine, int port) {
        super(port);
        this.nomDomaine = nomDomaine;
    }

    @Override
    public void connexion() throws IOException {
        socketClient = new Socket(nomDomaine, port);
        oout = new ObjectOutputStream(socketClient.getOutputStream());
        oin = new ObjectInputStream(socketClient.getInputStream());
    }

}
