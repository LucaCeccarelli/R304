package fr.univ_amu.iut.interface_application.fenetres.combat;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.joueur.Joueur;
import fr.univ_amu.iut.backend.outils.multijoueur.serveur.Serveur;
import fr.univ_amu.iut.interface_application.fenetres.connexion.Heberger;

public class CombatServeur extends Combat{
    Serveur serveur;
    public CombatServeur(Joueur joueur) {
        super(joueur);
        serveur = Heberger.getServeur();

    }

    @Override
    public void combat() {
        serveur.ecouter();
        serveur.envoyer(super.getBoutonChampionChoisiAuCombat().getEntite().getPointsAttaque());
        while (serveur.estDegatsRecusVide()){

        }
        super.getBoutonChampionChoisiAuCombat().getEntite().recevoirDegats(serveur.getBufferRecu());

        super.verifieSiChampionVivant();
    }

}
