package fr.univ_amu.iut;

import static org.junit.jupiter.api.Assertions.*;

import fr.univ_amu.iut.backend.entites.Assassin;
import fr.univ_amu.iut.backend.entites.Rarete;
import fr.univ_amu.iut.backend.magasin.ApprovisionnementMagasin;
import fr.univ_amu.iut.backend.magasin.InitListeChampionsExistants;
import fr.univ_amu.iut.backend.outils.FonctionAleatoire;
import fr.univ_amu.iut.backend.outils.Paquet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestApprovisionnementMagasin {
    private static Paquet paquetTest;
    private static Assassin entiteTest;

    @BeforeEach
    void setUp() {
        InitListeChampionsExistants.InitListe();
        FonctionAleatoire.random.setSeed(0);
        paquetTest = new Paquet();
        entiteTest = new Assassin("Fred", 80, 60, 40, Rarete.LEGENDAIRE);
    }

    @Test
    void testListeChampionsExistants() {
        ApprovisionnementMagasin.ajouterALaListeDesChampionsExistants(entiteTest);
        assertTrue(ApprovisionnementMagasin.listeChampionsExistants.contains(entiteTest));
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