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
        serveur.ecouter();
    }

    @Override
    public void combat() {
        //Attendre que le client aie envoyé son champion
        System.out.println(serveur.estEntitesRecuesVide());
        while (true){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(!serveur.estEntitesRecuesVide()){break;}
        }
        Entite entiteAdversaire = serveur.getBufferRecu();

        //Combat entre les 2
        super.getBoutonChampionChoisiAuCombat().getEntite().attaquer(entiteAdversaire);
        entiteAdversaire.attaquer(super.getBoutonChampionChoisiAuCombat().getEntite());

        //Renvoie entité modifé
        serveur.envoyer(entiteAdversaire);

        //Verifie si champion au combat tjr vivant
        super.verifieSiChampionVivant();
    }
}
