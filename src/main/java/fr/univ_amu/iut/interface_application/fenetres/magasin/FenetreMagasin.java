package fr.univ_amu.iut.interface_application.fenetres.magasin;

import fr.univ_amu.iut.backend.joueur.Joueur;
import fr.univ_amu.iut.backend.magasin.InitListeChampionsExistants;
import fr.univ_amu.iut.backend.magasin.Magasin;
import fr.univ_amu.iut.backend.magasin.exceptions.NomEntiteNonPresentDansMagasinException;
import fr.univ_amu.iut.interface_application.fenetres.combat.CombatClient;
import fr.univ_amu.iut.interface_application.fenetres.combat.CombatServeur;
import fr.univ_amu.iut.interface_application.fenetres.connexion.Heberger;
import fr.univ_amu.iut.interface_application.fenetres.connexion.Rejoindre;
import fr.univ_amu.iut.interface_application.fenetres.outils.BoutonChampion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

/**
 * La classe FenetreMagasin est une sous-classe de BorderPane qui sert à afficher le magasin à l'utilisateur.
 * La fenêtre magasin comporte cinq boutons, un pour chaque champion disponible.
 */
public class FenetreMagasin extends BorderPane {
    /**
     * Conteneur des boutons champion
     */
    private HBox conteneurDesBoutonsChampion = new HBox();

    /**
     * Label qui affiche le nombre d'entités restantes à acheter
     */
    private Label nombreEntitesRestantesAchat = new Label("Nombre d'entitées restantes à acheter : 5");

    /**
     * Conteneur pour le label nombreEntitesRestantesAchat
     */
    private HBox entitesRestantesConteneur = new HBox();

    /**
     * Nombre d'entités restantes à acheter
     */
    private int nbEntitesRestantes = 5;

    /**
     * Instance de Magasin
     */
    private Magasin magasin;

    /**
     * Liste des boutons champion
     */
    private ArrayList<BoutonChampion> boutonsChampions = new ArrayList<>(5);

    /**
     * Instance de Joueur
     */
    private Joueur joueur;

    /**
     * Constructeur de la fenêtre magasin
     */
    public FenetreMagasin(){
        super();
        initElements();
        joueur = new Joueur("Moi");

        InitListeChampionsExistants.InitListe();

        magasin = new Magasin();
        initBoutonsChampions();
        chargerBoutonsAchatChampions();
        super.setCenter(conteneurDesBoutonsChampion);
        super.setTop(entitesRestantesConteneur);
    }

    /**
     * Charger les boutons d'achat des champions
     */
    private void chargerBoutonsAchatChampions(){
        magasin.initMagasin(); //recharger magasin
        for (int i = 0; i < boutonsChampions.size(); i++) {
            boutonsChampions.get(i).setEntite(magasin.getMagasin().get(i)); //Ajouter le champion
        }
    }

    /**
     * Initialisation des boutons champions
     */
    private void initBoutonsChampions(){
        conteneurDesBoutonsChampion.setId("listeChampions");
        for (int i = 0; i < 5; i++) {
            boutonsChampions.add(new BoutonChampion());
            boutonsChampions.get(i).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {

                    try {
                        joueur.ajouterAuPaquet(magasin.achat(((BoutonChampion)e.getSource()).getEntite().getNom()));
                        diminuerNbAchats();
                    } catch (NomEntiteNonPresentDansMagasinException ex) {
                        System.out.println("Nom de l'entite chosie non valide");
                    }

                    verifierTaillePaquet();
                    chargerBoutonsAchatChampions();
                }
            });
            conteneurDesBoutonsChampion.getChildren().add(boutonsChampions.get(i)); // ajouter le bouton à la hbox
        }
    }

    /**
     * Vérifier la taille du paquet
     */
    private void verifierTaillePaquet(){
        if(joueur.getPaquet().size()>4){
            if(Rejoindre.getClient() != null){
                FenetreMagasin.super.getScene().setRoot(new CombatClient(joueur));
            } else if (Heberger.getServeur() != null) {
                FenetreMagasin.super.getScene().setRoot(new CombatServeur(joueur));
            }
        }
    }

    /**
     * Diminuer le nombre d'achats
     */
    public void diminuerNbAchats(){
        this.nbEntitesRestantes -= 1;
        nombreEntitesRestantesAchat.setText("Nombre d'entitées restantes à acheter : " + nbEntitesRestantes);
    }

    /**
     * Initialisation des éléments
     */
    public void initElements(){
        super.setId("arrierePlanMagasin");
        nombreEntitesRestantesAchat.setId("entitesRestantes");
        entitesRestantesConteneur.setId("entitesRestantesConteneur");
        entitesRestantesConteneur.getChildren().add(nombreEntitesRestantesAchat);
    }
}