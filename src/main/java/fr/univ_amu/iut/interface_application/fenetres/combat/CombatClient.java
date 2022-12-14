package fr.univ_amu.iut.interface_application.fenetres.combat;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.joueur.Joueur;
import fr.univ_amu.iut.backend.outils.multijoueur.client.Client;
import fr.univ_amu.iut.interface_application.fenetres.connexion.Rejoindre;

public class CombatClient extends Combat {
    private Client client;
    public CombatClient(Joueur joueur) {
        super(joueur);
        client = Rejoindre.getClient();
    }

    @Override
    public void combat() {
        client.ecouter();
        client.envoyer(super.getBoutonChampionChoisiAuCombat().getEntite().getPointsAttaque());
        while (client.estDegatsRecusVide()){

        }
        super.getBoutonChampionChoisiAuCombat().getEntite().recevoirDegats(client.getBufferRecu());

        super.verifieSiChampionVivant();

    }
}
