package fr.univ_amu.fr;

import fr.univ_amu.iut.backend.entites.*;
import fr.univ_amu.iut.backend.joueur.Joueur;
import fr.univ_amu.iut.backend.outils.FonctionAleatoire;
import fr.univ_amu.iut.entites.*;
import fr.univ_amu.iut.backend.magasin.Magasin;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestApp {
    @Test
    public void testAssassinToString() {
        Assassin a1 = new Assassin("Fred", 2, 50, 30, Rarete.RARE);
        assertEquals(a1.toString(), "Assassin{rarete=RARE, nom=Fred, pointsAttaque=2, pointsDefense=30, pointsVie=50}");
    }

    @Test
    public void testEruditToString() {
        Erudit e1 = new Erudit("Fred", 2, 50, 30, Rarete.RARE);
        assertEquals(e1.toString(), "Erudit{rarete=RARE, nom=Fred, pointsAttaque=2, pointsDefense=30, pointsVie=50}");
    }

    @Test
    public void testMageToString() {
        Mage m1 = new Mage("Fred", 2, 50, 30, Rarete.RARE);
        assertEquals(m1.toString(), "Mage{rarete=RARE, nom=Fred, pointsAttaque=2, pointsDefense=30, pointsVie=50}");
    }

    @Test
    public void testSniperToString() {
        Sniper s1 = new Sniper("Fred", 2, 50, 30, Rarete.RARE);
        assertEquals(s1.toString(), "Sniper{rarete=RARE, nom=Fred, pointsAttaque=2, pointsDefense=30, pointsVie=50}");
    }

    @Test
    public void testYordleToString() {
        Yordle y1 = new Yordle("Fred", 2, 50, 30, Rarete.RARE);
        assertEquals(y1.toString(), "Yordle{rarete=RARE, nom=Fred, pointsAttaque=2, pointsDefense=30, pointsVie=50}");
    }

    @Test
    public void testTri() {
        ArrayList<Entite> entites = new ArrayList<Entite>();
        Assassin a1 = new Assassin("Michou", 2, 10, 30, Rarete.COMMUN);
        Assassin a2 = new Assassin("Michel", 2, 50, 30, Rarete.RARE);
        Assassin a3 = new Assassin("Simon", 2, 100, 30, Rarete.LEGENDAIRE);
        Assassin a4 = new Assassin("Simon2", 2, 40, 30, Rarete.RARE);

        entites.add(a4);
        entites.add(a1);
        entites.add(a3);
        entites.add(a2);
        entites = Paquet.trierParPv(entites);

        assertEquals("[Assassin{rarete=COMMUN, nom=Michou, pointsAttaque=2, pointsDefense=30, pointsVie=10}, Assassin{rarete=RARE, nom=Simon2, pointsAttaque=2, pointsDefense=30, pointsVie=40}, Assassin{rarete=RARE, nom=Michel, pointsAttaque=2, pointsDefense=30, pointsVie=50}, Assassin{rarete=LEGENDAIRE, nom=Simon, pointsAttaque=2, pointsDefense=30, pointsVie=100}]", entites.toString());
    }


    @Test
    public void testPaquetRareteCommun(){

        Assassin a1 = new Assassin("Luca", 2, 10, 30, Rarete.COMMUN);

        Magasin m1 = new Magasin();
        m1.trieRarete();

        assertEquals("[Assassin{rarete=COMMUN, nom=Luca, pointsAttaque=2, pointsDefense=30, pointsVie=10}]",  m1.getListeCommun().toString());

    }

    @Test
    public void testPaquetRareteRare(){

        Assassin a1 = new Assassin("Fred", 2, 50, 30, Rarete.RARE);
        Assassin a2 = new Assassin("Moha", 2, 40, 30, Rarete.RARE);

        Magasin m1 = new Magasin();
        m1.trieRarete();

        assertEquals("[Assassin{rarete=RARE, nom=Fred, pointsAttaque=2, pointsDefense=30, pointsVie=50}, Assassin{rarete=RARE, nom=Moha, pointsAttaque=2, pointsDefense=30, pointsVie=40}]", m1.getListeRare().toString());

    }

    @Test
    public void testPaquetRareteLegendaire(){

        Assassin a1 = new Assassin("Fred", 2, 50, 30, Rarete.LEGENDAIRE);
        Assassin a2 = new Assassin("Moha", 2, 40, 30, Rarete.LEGENDAIRE);

        Magasin m1 = new Magasin();
        m1.trieRarete();

        assertEquals("[Assassin{rarete=LEGENDAIRE, nom=Fred, pointsAttaque=2, pointsDefense=30, pointsVie=50}, Assassin{rarete=LEGENDAIRE, nom=Moha, pointsAttaque=2, pointsDefense=30, pointsVie=40}]", m1.getListeLegendaire().toString());

    }


    @Test
    public void testPaquet(){

        Assassin a1 = new Assassin("Fred", 2, 50, 30, Rarete.LEGENDAIRE);
        Assassin a2 = new Assassin("Moha", 2, 40, 30, Rarete.RARE);

        Magasin m1 = new Magasin();

        assertEquals("[Assassin{rarete=LEGENDAIRE, nom=Fred, pointsAttaque=2, pointsDefense=30, pointsVie=50}, Assassin{rarete=RARE, nom=Moha, pointsAttaque=2, pointsDefense=30, pointsVie=40}]", Paquet.liste.toString());

    }

    @Test
    public void testMagasin(){
        FonctionAleatoire.random.setSeed(1);
        Assassin a1 = new Assassin("Michou", 2, 10, 30, Rarete.COMMUN);
        Mage a2 = new Mage("Michel", 2, 50, 30, Rarete.RARE);
        Assassin a3 = new Assassin("Simon", 2, 100, 30, Rarete.LEGENDAIRE);
        Sniper a4 = new Sniper("Si", 2, 40, 30, Rarete.RARE);
        Yordle a5 = new Yordle("Fred", 2, 50, 30, Rarete.LEGENDAIRE);

        Magasin m1 = new Magasin();
        m1.trieRarete();
        m1.initMagasin();
        assertEquals("[Assassin{rarete=COMMUN, nom=Michou, pointsAttaque=2, pointsDefense=30, pointsVie=10}, Mage{rarete=RARE, nom=Michel, pointsAttaque=2, pointsDefense=30, pointsVie=50}, Assassin{rarete=COMMUN, nom=Michou, pointsAttaque=2, pointsDefense=30, pointsVie=10}, Sniper{rarete=RARE, nom=Si, pointsAttaque=2, pointsDefense=30, pointsVie=40}, Mage{rarete=RARE, nom=Michel, pointsAttaque=2, pointsDefense=30, pointsVie=50}]",m1.getMagasin().toString());

    }

    @Test
    public void testAchat(){
        FonctionAleatoire.random.setSeed(1);
        Assassin a1 = new Assassin("Michou", 2, 10, 30, Rarete.COMMUN);
        Mage a2 = new Mage("Michel", 2, 50, 30, Rarete.RARE);
        Assassin a3 = new Assassin("Simon", 2, 100, 30, Rarete.LEGENDAIRE);
        Sniper a4 = new Sniper("Si", 2, 40, 30, Rarete.RARE);
        Yordle a5 = new Yordle("Fred", 2, 50, 30, Rarete.LEGENDAIRE);

        Magasin m1 = new Magasin();
        m1.trieRarete();
        m1.initMagasin();
        Entite entite= m1.achat("Michou");
        System.out.println(entite);
        assertEquals("Assassin{rarete=COMMUN, nom=Michou, pointsAttaque=2, pointsDefense=30, pointsVie=10}", entite.toString());

    }

    @Test
    public void testInitJoueur(){
        Joueur j1 = new Joueur("Fred");
        assertEquals("Joueur{paquet=[], nom='Fred'}", j1.toString());
    }

    @Test
    public void testAjoutPaquetJoueur(){
        Joueur j1 = new Joueur("Fred");
        Assassin a1 = new Assassin("Michou", 2, 10, 30, Rarete.COMMUN);
        Mage a2 = new Mage("Michel", 2, 50, 30, Rarete.RARE);
        Assassin a3 = new Assassin("Simon", 2, 100, 30, Rarete.LEGENDAIRE);
        Sniper a4 = new Sniper("Si", 2, 40, 30, Rarete.RARE);
        Yordle a5 = new Yordle("Fred", 2, 50, 30, Rarete.LEGENDAIRE);

        j1.ajouterAuPaquet(a1);
        j1.ajouterAuPaquet(a2);
        j1.ajouterAuPaquet(a3);
        j1.ajouterAuPaquet(a4);
        j1.ajouterAuPaquet(a5);

        assertEquals("Joueur{paquet=[Assassin{rarete=COMMUN, nom=Michou, pointsAttaque=2, pointsDefense=30, pointsVie=10}, Mage{rarete=RARE, nom=Michel, pointsAttaque=2, pointsDefense=30, pointsVie=50}, Assassin{rarete=LEGENDAIRE, nom=Simon, pointsAttaque=2, pointsDefense=30, pointsVie=100}, Sniper{rarete=RARE, nom=Si, pointsAttaque=2, pointsDefense=30, pointsVie=40}, Yordle{rarete=LEGENDAIRE, nom=Fred, pointsAttaque=2, pointsDefense=30, pointsVie=50}], nom='Fred'}", j1.toString());
    }

    @Test
    public void testTriePaquetJoueur(){
        Joueur j1 = new Joueur("Fred");
        Assassin a1 = new Assassin("Michou", 2, 10, 30, Rarete.COMMUN);
        Mage a2 = new Mage("Michel", 2, 50, 30, Rarete.RARE);
        Assassin a3 = new Assassin("Simon", 2, 100, 30, Rarete.LEGENDAIRE);
        Sniper a4 = new Sniper("Si", 2, 40, 30, Rarete.RARE);
        Yordle a5 = new Yordle("Fred", 2, 50, 30, Rarete.LEGENDAIRE);

        j1.ajouterAuPaquet(a1);
        j1.ajouterAuPaquet(a2);
        j1.ajouterAuPaquet(a3);
        j1.ajouterAuPaquet(a4);
        j1.ajouterAuPaquet(a5);

        assertEquals("Assassin{rarete=COMMUN, nom=Michou, pointsAttaque=2, pointsDefense=30, pointsVie=10}Mage{rarete=RARE, nom=Michel, pointsAttaque=2, pointsDefense=30, pointsVie=50}Assassin{rarete=LEGENDAIRE, nom=Simon, pointsAttaque=2, pointsDefense=30, pointsVie=100}Sniper{rarete=RARE, nom=Si, pointsAttaque=2, pointsDefense=30, pointsVie=40}Yordle{rarete=LEGENDAIRE, nom=Fred, pointsAttaque=2, pointsDefense=30, pointsVie=50}", j1.contenuPaquet());

    }
}
