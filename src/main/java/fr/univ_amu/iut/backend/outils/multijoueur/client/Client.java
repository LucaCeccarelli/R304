package fr.univ_amu.iut.backend.outils.multijoueur.client;

import fr.univ_amu.iut.backend.outils.multijoueur.SocketEchange;

import java.io.*;
import java.net.Socket;

/**
 * La classe Client permet d'établir une connexion avec un serveur
 *
 * @author NomAuteur
 * @version 1.0
 */
public class Client extends SocketEchange {

    /**
     * Nom du domaine
     */
    private String nomDomaine;

    /**
     * Socket client
     */
    private Socket socketClient;

    /**
     * Constructeur
     *
     * @param  nomDomaine  Le nom du domaine
     * @param  port  Le port du serveur
     */
    public Client(String nomDomaine, int port) {
        super(port);
        this.nomDomaine = nomDomaine;
    }

    /**
     * Permet d'établir la connexion avec le serveur
     *
     * @throws IOException  Erreur de lecture / écriture
     */
    @Override
    public void connexion() throws IOException {
        socketClient = new Socket(nomDomaine, port);
        oout = new ObjectOutputStream(socketClient.getOutputStream());
        oin = new ObjectInputStream(socketClient.getInputStream());
    }

}
