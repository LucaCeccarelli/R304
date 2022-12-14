package fr.univ_amu.iut.backend.outils.multijoueur.client;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.outils.Paquet;
import fr.univ_amu.iut.backend.outils.multijoueur.SocketEchange;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class Client extends SocketEchange {
    private String nomDomaine;
    private Socket socketClient;

    public Client(String nomDomaine, int port) {
        super(port);
        this.nomDomaine = nomDomaine;
    }

    @Override
    public void connexion() throws IOException {
        socketClient = new Socket(nomDomaine, port);
        dout = new DataOutputStream(socketClient.getOutputStream());
        dout.flush();
        din = new DataInputStream(socketClient.getInputStream());
    }


}
