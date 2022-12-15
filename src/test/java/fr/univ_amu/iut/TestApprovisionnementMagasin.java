package fr.univ_amu.iut;

import static org.junit.jupiter.api.Assertions.*;

import fr.univ_amu.iut.backend.entites.*;
import org.junit.jupiter.api.Test;

import fr.univ_amu.iut.backend.magasin.ApprovisionnementMagasin;
import fr.univ_amu.iut.backend.outils.Paquet;

public class TestApprovisionnementMagasin {

    @Test
    void testAjouterALaListeDesChampionsExistants() {
        Yordle champion = new Yordle("Fred", 80, 10, 10, Rarete.LEGENDAIRE);
        ApprovisionnementMagasin.ajouterALaListeDesChampionsExistants(champion);
        assertTrue(ApprovisionnementMagasin.listeChampionsExistants.contains(champion));
    }


    @Test
    void testGetListeCommun() {
        Paquet expectedResult = new Paquet();
        Paquet result = ApprovisionnementMagasin.getListeCommun();
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetListeRare() {
        Paquet expectedResult = new Paquet();
        Paquet result = ApprovisionnementMagasin.getListeRare();
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetListeLegendaire() {
        Paquet expectedResult = new Paquet();
        Paquet result = ApprovisionnementMagasin.getListeLegendaire();
        assertEquals(expectedResult, result);
    }
}