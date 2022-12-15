package fr.univ_amu.iut.backend.outils.multijoueur;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.outils.Paquet;
import fr.univ_amu.iut.backend.partie.Partie;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * SocketEchange est une classe qui permet d'établir une connexion entre un client et un serveur,
 * ainsi que d'envoyer et de recevoir des données entre les deux.
 */
public abstract class SocketEchange {
    /**
     * Le port utilisé pour la connexion.
     */
    protected int port;
    /**
     * Les entités reçues.
     */
    protected Paquet entitesRecues;
    /**
     * Flux de sortie pour l'envoi des données.
     */
    protected ObjectOutputStream oout;
    /**
     * Flux d'entrée pour la réception des données.
     */
    protected ObjectInputStream oin ;

    /**
     * Constructeur SocketEchange
     *
     * @param port Le port utilisé pour la connexion
     */
    public SocketEchange(int port){
        this.port = port;
    }

    /**
     * La méthode connexion() établit une connexion entre un client et un serveur.
     *
     * @throws IOException si une erreur I/O se produit
     */
    public abstract void connexion() throws IOException;

    /**
     * La méthode envoyer() envoie une entité à un serveur.
     *
     * @param entite l'entité à envoyer
     */
    public void envoyer(Entite entite){
        try {
            oout.writeObject(entite);
            oout.flush();
            Thread.sleep(500);
        } catch (IOException | InterruptedException e) {
            Partie.asGagne = true;
        }
    }

    /**
     * La méthode écouter() écoute pour les données entrantes d'un serveur et les ajoute à entitesRecues.
     */
    public void ecouter(){
        entitesRecues = new Paquet();

        Thread recevoir = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        entitesRecues.add(  ( (Entite)(oin.readObject()) ));
                    }

                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Serveur hors service");
                    Partie.asGagne = true;
                    try {
                        oout.close();
                    } catch (IOException ex) {
                        System.out.println("Vous vous etes deconnectés");
                    }

                    e.printStackTrace();
                }
            }
        });
        recevoir.start();
    }

    /**
     * La méthode getBufferRecu() récupère l'entité la plus ancienne de entitesRecues et la supprime de entitesRecues.
     *
     * @return l'entité la plus ancienne de entitesRecues
     */
    public Entite getBufferRecu(){
        Entite entiteRecue = entitesRecues.get(0);
        entitesRecues.remove(0);
        return entiteRecue;
    }

    /**
     * La méthode estEntitesRecuesVide() vérifie si entitesRecues est vide.
     *
     * @return true si entitesRecues est vide, false sinon
     */
    public boolean estEntitesRecuesVide(){
        return entitesRecues.size() == 0;
    }

    /**
     * La méthode deconnexion() ferme le flux de sortie et déconnecte le client du serveur.
     */
    public void deconnexion(){
        try {
            oout.close();
        } catch (IOException e) {
            System.out.println("Vous avez perdu");
        }
    }
}