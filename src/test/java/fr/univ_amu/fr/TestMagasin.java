package fr.univ_amu.fr;

import fr.univ_amu.iut.RandomFunct;
import fr.univ_amu.iut.entites.*;
import fr.univ_amu.iut.magasin.Magasin;
import fr.univ_amu.iut.magasin.Paquet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMagasin {
    @Test
    public void testPaquetRareteCommun(){

        Assassin a1 = new Assassin("Luca", 2, 10, 30, Rarete.COMMUN);

        Magasin m1 = new Magasin();
        m1.trieRarete();

        assertEquals("[Assassin{rarete=COMMUN, nom=Luca, pointsAttaque=2, pointsDefense=30, pointsVie=10}]", m1.getListeCommun().toString());

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
        RandomFunct.random.setSeed(1);
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
        RandomFunct.random.setSeed(1);
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

}
