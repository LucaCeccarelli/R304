package fr.univ_amu.iut;

import fr.univ_amu.iut.backend.entites.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEntite {
    @Test
    public void testRecuperationRarete(){
        Assassin a1 = new Assassin("Fred", 80, 50, 50, Rarete.LEGENDAIRE);
        Erudit e1 = new Erudit("Fred", 50, 80, 80, Rarete.RARE);
        Mage m1 = new Mage("Fred", 80, 20, 30, Rarete.COMMUN);
        assertEquals(Rarete.LEGENDAIRE, a1.getRarete());
        assertEquals(Rarete.RARE, e1.getRarete());
        assertEquals(Rarete.COMMUN, m1.getRarete());
    }

    @Test
    public void testRecuperationNom(){
        Yordle s1 = new Yordle("Fred", 80, 10, 10, Rarete.LEGENDAIRE);
        assertEquals("Fred", s1.getNom());
    }

    @Test
    public void recuperationPointsAttaque(){
        Yordle s1 = new Yordle("Fred", 80, 10, 10, Rarete.LEGENDAIRE);
        assertEquals(80, s1.getPointsAttaque());
    }

    @Test
    public void changementPointsAttaque(){
        Yordle s1 = new Yordle("Fred", 80, 10, 10, Rarete.LEGENDAIRE);
        s1.setPointsAttaque(20);
        assertEquals(20, s1.getPointsAttaque());
    }

    @Test
    public void recuperationPointsDefense(){
        Yordle s1 = new Yordle("Fred", 80, 10, 10, Rarete.LEGENDAIRE);
        assertEquals(40, s1.getPointsDefense());
    }

    @Test
    public void changementPointsDefense(){
        Yordle s1 = new Yordle("Fred", 80, 10, 10, Rarete.LEGENDAIRE);
        s1.setPointsDefense(20);
        assertEquals(20, s1.getPointsDefense());
    }

    @Test
    public void recuperationPV(){
        Yordle s1 = new Yordle("Fred", 80, 10, 10, Rarete.LEGENDAIRE);
        assertEquals(20, s1.getPointsVie());
    }

    @Test
    public void changementPV(){
        Yordle s1 = new Yordle("Fred", 80, 10, 10, Rarete.LEGENDAIRE);
        s1.setPointsVie(60);
        assertEquals(60, s1.getPointsVie());
    }

    //TODO:Tester l'attaque
}