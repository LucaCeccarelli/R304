package fr.univ_amu.iut.backend.outils.multijoueur;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.outils.Paquet;

import java.io.*;
import java.util.ArrayList;

public abstract class SocketEchange {
    protected int port;
    protected ArrayList<Integer> degatsRecus;
    protected DataOutputStream dout;
    protected DataInputStream din ;

    public SocketEchange(int port){
        this.port = port;
    }
    public abstract void connexion() throws IOException;

    public void envoyer(int attaqueAdv){
        try {
            dout.writeInt(attaqueAdv);
            dout.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ecouter(){
        degatsRecus = new ArrayList<>();

        Thread recevoir = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (din.available()>0){
                        int degats = din.readInt();
                        degatsRecus.add(degats);
                        System.out.println(degats);
                    }
                    System.out.println("Serveur hors service");
                    dout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        recevoir.start();
    }

    public int getBufferRecu(){
        int degatRecu = degatsRecus.get(0);
        degatsRecus.remove(0);
        return degatRecu;
    }

    public boolean estDegatsRecusVide(){
        return degatsRecus.size() == 0;
    }
}
