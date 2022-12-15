package fr.univ_amu.iut.interface_application.fenetres.combat;

import fr.univ_amu.iut.backend.joueur.Joueur;
import fr.univ_amu.iut.backend.partie.Partie;
import fr.univ_amu.iut.interface_application.fenetres.fenetre_fin.FinPartie;
import fr.univ_amu.iut.interface_application.fenetres.outils.BoutonChampion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

/**
 * Classe qui gère le combat entre le joueur et l'ordinateur
 */
public abstract class Combat extends BorderPane {
    /** joueur qui va se battre */
    public Joueur joueur;
    /** Conteneur contenant les boutons de chaque champion du joueur */
    private HBox conteneurDesBoutonsChampion = new HBox();
    /** Conteneur contenant le bouton du champion choisi pour le combat */
    private HBox conteneurCombattant = new HBox();

    /** Liste des boutons des champions du joueur */
    private ArrayList<BoutonChampion> boutonsChampions = new ArrayList<>(5);
    /** Bouton du champion choisi pour le combat */
    private BoutonChampion boutonChampionChoisiAuCombat = new BoutonChampion();
    /** Bouton qui permet de lancer le combat */
    private Button combat = new Button("Se battre ! ");

    /** Label permettant l'affichage des statistiques de la partie */
    private Label statistiquesAttaque = new Label();

    /** Entier qui stocke les PV du champion avant l'attaque de l'adversaire */
    private int PVChampionAvantTour;

    /** Entier qui stocke les PV du champion après l'attaque de l'adversaire */
    private int PVChampionApresTour;

    /**
     * Constructeur de Combat
     * @param joueur joueur qui va se battre
     */
    public Combat(Joueur joueur){
        super();
        this.joueur = joueur;
        this.setId("arrierePlanCombat");
        initId();
        initBoutonCombat();
        initBoutonsChampions();
        super.setBottom(conteneurDesBoutonsChampion);
    }

    /**
     * Methode qui initialise les identifiants des composants de la classe
     */
    private void initId(){
        conteneurDesBoutonsChampion.setId("conteneurChampions");
        conteneurCombattant.setId("conteneurCombattant");
        combat.setId("boutonSeBattre");
    }

    /**
     * Methode qui initialise les propriétés du bouton combat
     */
    private void initBoutonCombat(){
        combat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                combat();
                //Recharger Affichage
                conteneurCombattant.getChildren().clear();
                afficherDegats();
            }
        });
    }

    /**
     * Methode qui initialise les boutons des champions
     */
    private void initBoutonsChampions() {
        for (int i = 0; i < joueur.getPaquet().size(); i++) {
            boutonsChampions.add(new BoutonChampion(joueur.getPaquet().get(i),i));
            boutonsChampions.get(i).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    //Choisir ce champion pour aller au combat
                    boutonChampionChoisiAuCombat.setEntite( ( (BoutonChampion) (e.getSource()) ).getEntite() );
                    boutonChampionChoisiAuCombat.setIndiceBouton( ( (BoutonChampion) (e.getSource()) ).getIndiceBouton() );
                    PVChampionAvantTour = boutonChampionChoisiAuCombat.getEntite().getPointsVie();
                    conteneurCombattant.getChildren().clear();
                    conteneurCombattant.getChildren().addAll(boutonChampionChoisiAuCombat, combat);
                    Combat.super.setCenter(conteneurCombattant);
                }
            });
            conteneurDesBoutonsChampion.getChildren().add(boutonsChampions.get(i)); // ajouter le bouton à la hbox
        }
    }

    /**
     * Methode qui vérifie si le champion choisi est vivant
     */
    public void verifieSiChampionVivant(){
        PVChampionApresTour = boutonChampionChoisiAuCombat.getEntite().getPointsVie();
        if( boutonChampionChoisiAuCombat.getEntite().getPointsVie() == 0){
            conteneurDesBoutonsChampion.getChildren().get(boutonChampionChoisiAuCombat.getIndiceBouton()).setVisible(false);
            return;
        }
        boutonsChampions.get( boutonChampionChoisiAuCombat.getIndiceBouton() ).setEntite(boutonChampionChoisiAuCombat.getEntite() );
    }

    /**
     * Methode qui détermine le déroulement du combat
     */
    public abstract void combat();

    /**
     * Methode qui retourne le bouton du champion choisi pour le combat
     * @return le bouton du champion choisi pour le combat
     */
    public BoutonChampion getBoutonChampionChoisiAuCombat() {
        return boutonChampionChoisiAuCombat;
    }

    /**
     * Methode qui vérifie si le joueur a gagné la partie
     */
    public void asGagne(){
        if(Partie.asGagne){
            super.getScene().setRoot(new FinPartie(true));
        }
    }

    /**
     * Methode qui vérifie si tous les champions sont morts
     * @return true si tous les champions sont morts, false sinon
     */
    public boolean verifieSiTousLesChampionsSontMorts(){
        int counter = 0;
        for (BoutonChampion champion: boutonsChampions) {
            if(champion.getEntite().getPointsVie() == 0){
                counter+=1;
            }
        }
        return counter == joueur.getPaquet().size();
    }

    /**
     * Methode qui permet le calcul et l'affichage des dégats causés à l'entité
     */
    public void afficherDegats(){
        int PVPerdus;
        PVPerdus = PVChampionAvantTour-PVChampionApresTour;
        if (PVPerdus <= 0){
            PVPerdus = PVChampionAvantTour;
        }
        statistiquesAttaque.setText(getBoutonChampionChoisiAuCombat().getEntite().getNom() + " a perdu " + PVPerdus + " PV");
        Combat.super.setCenter(statistiquesAttaque);
    }
}
