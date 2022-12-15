package fr.univ_amu.iut.backend.magasin;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.magasin.exceptions.NomEntiteNonPresentDansMagasinException;
import fr.univ_amu.iut.backend.outils.Paquet;

import java.util.ArrayList;

/**
 * Cette classe représente un magasin virtuel.
 * Elle permet d'acheter des entités et d'initialiser le magasin.
 */
public class Magasin{

        /**
         * Constructeur par défaut du magasin.
         * Initialise le magasin en triant par rareté.
         */
        public Magasin(){
                ApprovisionnementMagasin.trieRarete();
        }

        /**
         * Paquet qui contient les entités du magasin.
         */
        private Paquet magasin = new Paquet(5);

        /**
         * Retourne le paquet qui contient les entités du magasin.
         * @return
         *      Paquet contenant les entités du magasin.
         */
        public ArrayList<Entite> getMagasin() {
                return magasin;
        }

        /**
         * Permet d'acheter une entité du magasin.
         * @param nomEntite Nom de l'entité à acheter.
         * @return
         *      Entité achetée.
         * @throws NomEntiteNonPresentDansMagasinException
         *      Exception levée si le nom de l'entité n'est pas présent dans le magasin.
         */
        public Entite achat(String nomEntite) throws NomEntiteNonPresentDansMagasinException {
                for (int i = 0; i < magasin.size(); i++) {
                        if (magasin.get(i).getNom().equals(nomEntite)) {

                                switch (magasin.get(i).getRarete()) {
                                        case RARE -> ApprovisionnementMagasin.getListeRare().remove(magasin.get(i));
                                        case COMMUN -> ApprovisionnementMagasin.getListeCommun().remove(magasin.get(i));
                                        case LEGENDAIRE -> ApprovisionnementMagasin.getListeLegendaire().remove(magasin.get(i));
                                }

                                Entite entite = magasin.get(i);
                                magasin.remove(i);
                                return entite;
                        }
                }
                throw new NomEntiteNonPresentDansMagasinException("nomEntite non present dans le magasin");
        }

        /**
         * Permet d'initialiser le magasin.
         */
        public void initMagasin() {
                magasin = ApprovisionnementMagasin.raffrechirEntitesDansMagasin();
        }

}