package fr.univ_amu.iut;

import fr.univ_amu.iut.backend.entites.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEntite {
    @Test
    public void testRecuperationRarete(){
        Assassin a1 = new Assassin("Fred", 80, 20, 20, Rarete.LEGENDAIRE);
        Erudit e1 = new Erudit("Fred", 80, 20, 20, Rarete.RARE);
        Mage m1 = new Mage("Fred", 80, 20, 20, Rarete.COMMUN);
        assertEquals(Rarete.LEGENDAIRE, a1.getRarete());
        assertEquals(Rarete.RARE, e1.getRarete());
        assertEquals(Rarete.COMMUN, m1.getRarete());
    }

    @Test
    public void testRecuperationNom(){
        Sniper s1 = new Sniper("Fred", 80, 20, 20, Rarete.LEGENDAIRE);
        assertEquals("Fred", s1.getNom());
    }

    @Test
    public void testChangementNom(){
        Yordle y1 = new Yordle("Fred", 80, 20, 20, Rarete.LEGENDAIRE);
        assertEquals("Fred", y1.getNom());
        y1.setNom("Nils");
        assertEquals("Nils", y1.getNom());
    }

    @Test
    public void recuperationPointsAttaque(){
        Assassin a1 = new Assassin("Fred", 80, 20, 40, Rarete.LEGENDAIRE);
        assertEquals(80, a1.getPointsAttaque());
    }

    @Test
    public void changementPointsAttaque(){
        Assassin a1 = new Assassin("Fred", 80, 20, 40, Rarete.LEGENDAIRE);
        a1.setPointsAttaque(20);
        assertEquals(20, a1.getPointsAttaque());
    }

    @Test
    public void recuperationPointsDefense(){
        Assassin a1 = new Assassin("Fred", 80, 20, 40, Rarete.LEGENDAIRE);
        assertEquals(40, a1.getPointsDefense());
    }

    @Test
    public void changementPointsDefense(){
        Assassin a1 = new Assassin("Fred", 80, 20, 40, Rarete.LEGENDAIRE);
        a1.setPointsDefense(20);
        assertEquals(20, a1.getPointsDefense());
    }

    @Test
    public void recuperationPV(){
        Assassin a1 = new Assassin("Fred", 80, 20, 40, Rarete.LEGENDAIRE);
        assertEquals(20, a1.getPointsVie());
    }

    @Test
    public void changementPV(){
        Assassin a1 = new Assassin("Fred", 80, 20, 40, Rarete.LEGENDAIRE);
        a1.setPointsVie(60);
        assertEquals(60, a1.getPointsVie());
    }

    //TODO:Tester l'attaque
}
