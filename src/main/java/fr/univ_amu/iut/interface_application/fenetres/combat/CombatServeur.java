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
        //Attendre que le client aie envoyé son champion
        System.out.println(serveur.estEntitesRecuesVide());
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

        //Verifie si champion au combat tjr vivant
        super.verifieSiChampionVivant();
        //TODO : Separer de combat
        asPerdu();
        asGagne();
        //Verifier
    }

    public void asPerdu(){
        if(super.verifieSiTousLesChampionsSontMorts()){
            System.out.println("Tu as Perdu");
            serveur.deconnexion();
            super.getScene().setRoot(new FinPartie(false));
        }
    }
}
