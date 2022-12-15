package fr.univ_amu.iut.interface_application.fenetres.combat;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.joueur.Joueur;
import fr.univ_amu.iut.backend.outils.multijoueur.client.Client;
import fr.univ_amu.iut.interface_application.fenetres.connexion.Rejoindre;
import fr.univ_amu.iut.interface_application.fenetres.fenetre_fin.FinPartie;

/**
 * Classe représentant le combat client
 */
public class CombatClient extends Combat {

    /**
     * Variable de type Client
     */
    private Client client;

    /**
     * Constructeur
     *
     * @param joueur le joueur qui joue
     */
    public CombatClient(Joueur joueur) {
        super(joueur);
        client = Rejoindre.getClient();
        client.ecouter();
    }

    /**
     * Fonction qui gère le combat
     */
    @Override
    public void combat() {
        client.envoyer( super.getBoutonChampionChoisiAuCombat().getEntite() );
        while (true){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(!client.estEntitesRecuesVide()){break;}
        }
        Entite entiteAdversaire = client.getBufferRecu();

        entiteAdversaire.attaquer(super.getBoutonChampionChoisiAuCombat().getEntite());
        super.verifieSiChampionVivant();

        asPerdu();
        asGagne();
    }

    /**
     * Fonction qui vérifie si le joueur a perdu
     */
    public void asPerdu(){
        if(super.verifieSiTousLesChampionsSontMorts()){
            System.out.println("Tu as Perdu");
            client.deconnexion();
            super.getScene().setRoot(new FinPartie(false));
        }
    }
}
