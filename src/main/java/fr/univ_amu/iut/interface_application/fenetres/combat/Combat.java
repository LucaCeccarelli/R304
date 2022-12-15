package fr.univ_amu.iut.interface_application.fenetres.combat;

import fr.univ_amu.iut.backend.joueur.Joueur;
import fr.univ_amu.iut.backend.partie.Partie;
import fr.univ_amu.iut.interface_application.fenetres.fenetre_fin.FinPartie;
import fr.univ_amu.iut.interface_application.fenetres.magasin.BoutonChampion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public abstract class Combat extends BorderPane {
    public Joueur joueur;
    private HBox conteneurDesBoutonsChampion = new HBox();

    private HBox conteneurCombattant = new HBox();
    private ArrayList<BoutonChampion> boutonsChampions = new ArrayList<>(5);
    private BoutonChampion boutonChampionChoisiAuCombat = new BoutonChampion();
    private Button combat = new Button("Se battre ! ");
    public Combat(Joueur joueur){
        super();
        this.joueur = joueur;
        this.setId("arrierePlanCombat");
        initId();
        initBoutonCombat();
        initBoutonsChampions();
        super.setBottom(conteneurDesBoutonsChampion);
    }
    private void initId(){
        conteneurDesBoutonsChampion.setId("conteneurChampions");
        conteneurCombattant.setId("conteneurCombattant");
        combat.setId("boutonSeBattre");
    }
    private void initBoutonCombat(){
        combat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                combat();
                //Recharger Affichage
                conteneurCombattant.getChildren().clear();
                Combat.super.setCenter(null);
            }
        });
    }

    private void initBoutonsChampions() {
        for (int i = 0; i < joueur.getPaquet().size(); i++) {
            boutonsChampions.add(new BoutonChampion(joueur.getPaquet().get(i),i));
            boutonsChampions.get(i).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    //Choisir ce champion pour aller au combat
                    boutonChampionChoisiAuCombat.setEntite( ( (BoutonChampion) (e.getSource()) ).getEntite() );
                    boutonChampionChoisiAuCombat.setIndiceBouton( ( (BoutonChampion) (e.getSource()) ).getIndiceBouton() );
                    conteneurCombattant.getChildren().clear();
                    conteneurCombattant.getChildren().addAll(boutonChampionChoisiAuCombat, combat);
                    Combat.super.setCenter(conteneurCombattant);
                }
            });
            conteneurDesBoutonsChampion.getChildren().add(boutonsChampions.get(i)); // ajouter le bouton à la hbox
        }
    }
    public void verifieSiChampionVivant(){
        if( boutonChampionChoisiAuCombat.getEntite().getPointsVie() == 0){
            conteneurDesBoutonsChampion.getChildren().get(boutonChampionChoisiAuCombat.getIndiceBouton()).setVisible(false);
            return;
        }
        boutonsChampions.get( boutonChampionChoisiAuCombat.getIndiceBouton() ).setEntite(boutonChampionChoisiAuCombat.getEntite() );
    }

    public abstract void combat();

    public BoutonChampion getBoutonChampionChoisiAuCombat() {
        return boutonChampionChoisiAuCombat;
    }

    public void asGagne(){
        if(Partie.asGagne){
            super.getScene().setRoot(new FinPartie(true));
        }
    }

    public boolean verifieSiTousLesChampionsSontMorts(){
        int counter = 0;
        for (BoutonChampion champion: boutonsChampions) {
            if(champion.getEntite().getPointsVie() == 0){
                counter+=1;
            }
        }
        return counter == joueur.getPaquet().size();
    }
}
