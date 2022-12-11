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
