package fr.univ_amu.iut.backend.magasin;

import fr.univ_amu.iut.backend.entites.Entite;

import java.util.ArrayList;

public class Magasin{
        public Magasin(){
                ApprovisionnementMagasin.trieRarete();
        }
        private ArrayList<Entite> magasin = new ArrayList<Entite>(5);

        public ArrayList<Entite> getMagasin() {
                return magasin;
        }

        public Entite achat(String nomEntite) throws NomEntiteNonPresentDansMagasinException {
                for (Entite entite : magasin) {
                        if(entite.getNom().equals(nomEntite)){
                                return entite;
                        }
                }
                throw new NomEntiteNonPresentDansMagasinException("nomEntite non present dans le magasin");
        }


        public void initMagasin(){
                magasin = ApprovisionnementMagasin.raffrechirEntitesDansMagasin();
        }



}
