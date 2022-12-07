package fr.univ_amu.iut.magasin;

import fr.univ_amu.iut.outils.Paquet;
import fr.univ_amu.iut.outils.FonctionAleatoire;
import fr.univ_amu.iut.entites.Entite;
import java.util.ArrayList;

public class Magasin{

        private ArrayList<Entite> listeCommun = new ArrayList<Entite>();
        private ArrayList<Entite> listeRare = new ArrayList<Entite>();
        private ArrayList<Entite> listeLegendaire = new ArrayList<Entite>();
        private ArrayList<Entite> magasin = new ArrayList<Entite>(5);



        public ArrayList<Entite> getListeCommun(){
                return listeCommun;
        }

        public ArrayList<Entite> getListeRare(){
                return listeRare;
        }

        public ArrayList<Entite> getListeLegendaire(){
                return listeLegendaire;
        }

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
                trieRarete();
                magasin.clear();
                int nbrAlea;
                int i = 0;
                while(i<5){
                        nbrAlea = FonctionAleatoire.random.nextInt(0,101);
                        if(nbrAlea<20 && listeLegendaire.isEmpty() == false){
                                magasin.add(listeLegendaire.get(FonctionAleatoire.random.nextInt(0,listeLegendaire.size())));
                                ++i;
                        } else if (nbrAlea<50 && listeRare.isEmpty() == false) {
                                magasin.add(listeRare.get(FonctionAleatoire.random.nextInt(0,listeRare.size())));
                                ++i;
                        } else if (listeCommun.isEmpty() == false){
                                magasin.add(listeCommun.get(FonctionAleatoire.random.nextInt(0,listeCommun.size())));
                                ++i;
                        }
                }
        }

        public void trieRarete(){
                for (Entite entite: Paquet.liste) {
                        switch (entite.getRarete()){
                                case RARE -> listeRare.add(entite);
                                case COMMUN -> listeCommun.add(entite);
                                case LEGENDAIRE -> listeLegendaire.add(entite);
                        }
                }

        }
}
