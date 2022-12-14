package fr.univ_amu.iut.backend.outils.multijoueur;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.outils.Paquet;
import fr.univ_amu.iut.backend.partie.Partie;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class SocketEchange {
    protected int port;
    protected Paquet entitesRecues;
    protected ObjectOutputStream oout;
    protected ObjectInputStream oin ;

    public SocketEchange(int port){
        this.port = port;
    }
    public abstract void connexion() throws IOException;

    public void envoyer(Entite entite){
        try {
            oout.writeObject(entite);
            oout.flush();
            Thread.sleep(500);
        } catch (IOException | InterruptedException e) {
            //throw new RuntimeException(e);
            Partie.asGagne = true;
        }
    }

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
                        throw new RuntimeException(ex);
                    }

                    e.printStackTrace();
                }
            }
        });
        recevoir.start();
    }

    public Entite getBufferRecu(){
        Entite entiteRecue = entitesRecues.get(0);
        entitesRecues.remove(0);
        return entiteRecue;
    }

    public boolean estEntitesRecuesVide(){
        return entitesRecues.size() == 0;
    }
    public void deconnexion(){
        try {
            oout.close();
        } catch (IOException e) {
            System.out.println("Vous avez perdu");
        }
    }
}
