package fr.univ_amu.iut.interface_application.fenetres.combat;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.joueur.Joueur;
import fr.univ_amu.iut.backend.outils.multijoueur.serveur.Serveur;
import fr.univ_amu.iut.interface_application.fenetres.connexion.Heberger;
import fr.univ_amu.iut.interface_application.fenetres.fenetre_fin.FinPartie;

public class CombatServeur extends Combat{
    Serveur serveur;
    public CombatServeur(Joueur joueur) {
        super(joueur);
        serveur = Heberger.getServeur();
        serveur.ecouter();
    }

    @Override
    public void combat() {
        serveur.envoyer(super.getBoutonChampionChoisiAuCombat().getEntite());
        while (true){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(!serveur.estEntitesRecuesVide()){break;}
        }
        Entite entiteAdversaire = serveur.getBufferRecu();

        entiteAdversaire.attaquer(super.getBoutonChampionChoisiAuCombat().getEntite());

        super.verifieSiChampionVivant();
        asPerdu();
        asGagne();
    }

    public void asPerdu(){
        if(super.verifieSiTousLesChampionsSontMorts()){
            System.out.println("Tu as Perdu");
            serveur.deconnexion();
            super.getScene().setRoot(new FinPartie(false));
        }
    }
}
