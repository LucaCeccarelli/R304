package fr.univ_amu.iut;

import static org.junit.jupiter.api.Assertions.*;

import fr.univ_amu.iut.backend.entites.*;
import fr.univ_amu.iut.backend.outils.Paquet;
import org.junit.jupiter.api.Test;

public class TestPaquet {
    @Test
    public void trierParPv_test() {
        Paquet paquet = new Paquet();
        Assassin a1 = new Assassin("Fred", 80, 50, 50, Rarete.LEGENDAIRE);
        Erudit e1 = new Erudit("Fred", 50, 80, 80, Rarete.RARE);
        Mage m1 = new Mage("Fred", 80, 20, 30, Rarete.COMMUN);
        paquet.add(a1);
        paquet.add(e1);
        paquet.add(m1);

        paquet.trierParPv();

        assertEquals(m1, paquet.get(0));
        assertEquals(a1, paquet.get(1));
        assertEquals(e1, paquet.get(2));
    }
}