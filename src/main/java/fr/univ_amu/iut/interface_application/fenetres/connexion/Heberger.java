package fr.univ_amu.iut.interface_application.fenetres.connexion;

import fr.univ_amu.iut.backend.outils.multijoueur.serveur.Serveur;
import fr.univ_amu.iut.backend.outils.multijoueur.serveur.NotifierConnexion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.*;
import java.util.Enumeration;

public class Heberger extends BorderPane {
    private Button heberger = new Button("Cliquez ici pour heberger la partie");
    private Label texteDeAttente = new Label("En attente que un autre joueur vous rejoigne ...");

    private Label IPLocale = new Label();
    private VBox texteAttenteIPLocale = new VBox();
    public static Serveur serveur;
    public Heberger() {
        super();
        super.setId("arrierePlan_heberger");
        initialisationBoutons();
        super.setCenter(heberger);
        initialisationTexteEtIp();
    }

    private void initialisationBoutons(){
        heberger.getStyleClass().add("bouton_management");
        heberger.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Stuff
                Heberger.super.setCenter(texteAttenteIPLocale);
                serveur = new Serveur(10013);
                Thread receive = new Thread(new Runnable() {
                    String msg;

                    @Override
                    public void run() {
                        try {
                            serveur.connexion();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                NotifierConnexion notifierConnexion = new NotifierConnexion(Heberger.super.getScene());
                serveur.ajoutObserver(notifierConnexion);
                receive.start();
            }
        });
    }

    public void initialisationTexteEtIp()  {
        texteAttenteIPLocale.setId("conteneurIPTexteHeberger");

        try {
            IPLocale.setText("Votre adresse IP est : " + recupererIpLocale().toString().substring(1));
        } catch (UnknownHostException e) {
            System.out.println("Impossible de recuperer votre adresse IP");;
        }

        texteAttenteIPLocale.getChildren().addAll(texteDeAttente, IPLocale);
    }

    public InetAddress recupererIpLocale() throws UnknownHostException {
        try {
            for (Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces(); interfaces.hasMoreElements();) {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (networkInterface.isLoopback() || !networkInterface.isUp())
                    continue;

                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    if (addr.isLoopbackAddress())
                        continue;

                    if (addr instanceof Inet4Address)
                        return addr;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return InetAddress.getLocalHost();
    }

    public static Serveur getServeur() {
        return serveur;
    }
}
