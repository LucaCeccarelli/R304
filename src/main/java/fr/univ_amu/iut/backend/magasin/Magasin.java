package fr.univ_amu.iut.backend.magasin;

import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.outils.Paquet;

import java.util.ArrayList;

public class Magasin{
        public Magasin(){
                ApprovisionnementMagasin.trieRarete();
        }
        private Paquet magasin = new Paquet(5);

        public ArrayList<Entite> getMagasin() {
                return magasin;
        }

        public Entite achat(String nomEntite) throws NomEntiteNonPresentDansMagasinException {
                for (int i = 0; i < magasin.size(); i++) {
                        if(magasin.get(i).getNom().equals(nomEntite)){

                                switch (magasin.get(i).getRarete()){
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


        public void initMagasin(){
                magasin = ApprovisionnementMagasin.raffrechirEntitesDansMagasin();
        }



}
