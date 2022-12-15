package fr.univ_amu.iut;

import static org.junit.jupiter.api.Assertions.*;

import fr.univ_amu.iut.backend.entites.*;
import fr.univ_amu.iut.backend.outils.Paquet;
import org.junit.jupiter.api.Test;

public class TestPaquet {
    @Test
    public void trierParPv_test() {
        Paquet paquet = new Paquet();
        Assassin a1 = new Assassin("Lucie", 60, 20, 76, Rarete.LEGENDAIRE);
        Erudit e1 = new Erudit("Simon", 90, 70, 89, Rarete.LEGENDAIRE);
        Mage m1 = new Mage("Paul", 12, 50, 35, Rarete.LEGENDAIRE);
        Yordle y1 = new Yordle("Paul", 25, 100, 9, Rarete.LEGENDAIRE);
        paquet.add(a1);
        paquet.add(y1);
        paquet.add(m1);
        paquet.add(e1);

        paquet.trierParPv();

        assertEquals(a1, paquet.get(0));
        assertEquals(m1, paquet.get(1));
        assertEquals(e1, paquet.get(2));
        assertEquals(y1, paquet.get(3));
    }
}
