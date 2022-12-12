package fr.univ_amu.iut.backend.outils.multijoueur;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.outils.Paquet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class SocketEchange {
    protected String nomDomaine;
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
            throw new RuntimeException(e);
        }
    }

    public void ecouter(){
        entitesRecues = new Paquet();

        Thread recevoir = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (oin.read()!= -1){
                        entitesRecues.add(  ( (Entite)(oin.readObject()) ));
                    }
                    System.out.println("Serveur hors service");
                    oout.close();
                } catch (IOException | ClassNotFoundException e) {
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
}
