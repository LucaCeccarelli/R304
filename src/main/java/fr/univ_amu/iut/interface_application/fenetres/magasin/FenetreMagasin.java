package fr.univ_amu.iut.interface_application.fenetres.magasin;

import fr.univ_amu.iut.backend.joueur.Joueur;
import fr.univ_amu.iut.backend.magasin.InitListeChampionsExistants;
import fr.univ_amu.iut.backend.magasin.Magasin;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class FenetreMagasin extends BorderPane {
    private HBox conteneurDesBoutonsChampion = new HBox();
    private Magasin magasin;
    private ArrayList<BoutonChampion> boutonsChampions = new ArrayList<>(5);
    private Joueur joueur;
    public FenetreMagasin(){
        super();
        super.setId("arrierePlanMagasin");
        joueur = new Joueur("Moi");

        InitListeChampionsExistants.InitListe();

        magasin = new Magasin();
        initBoutonsChampions();
        chargerBoutonsAchatChampions();
        super.setCenter(conteneurDesBoutonsChampion);
    }

    private void chargerBoutonsAchatChampions(){
        magasin.initMagasin(); //recharger magasin
        for (int i = 0; i < boutonsChampions.size(); i++) {
            boutonsChampions.get(i).setEntite(magasin.getMagasin().get(i)); //Ajouter le champion
        }
    }

    private void initBoutonsChampions(){
        conteneurDesBoutonsChampion.setId("listeChampions");
        for (int i = 0; i < 5; i++) {
            boutonsChampions.add(new BoutonChampion());
            boutonsChampions.get(i).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    joueur.ajouterAuPaquet(((BoutonChampion)e.getSource()).getEntite());
                    chargerBoutonsAchatChampions();
                }
            });
            conteneurDesBoutonsChampion.getChildren().add(boutonsChampions.get(i)); // ajouter le bouton à la hbox
        }
    }
}
