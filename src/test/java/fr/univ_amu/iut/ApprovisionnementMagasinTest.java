package fr.univ_amu.iut;

import static org.junit.jupiter.api.Assertions.*;

import fr.univ_amu.iut.backend.entites.*;
import org.junit.jupiter.api.Test;

import fr.univ_amu.iut.backend.magasin.ApprovisionnementMagasin;
import fr.univ_amu.iut.backend.outils.Paquet;

public class ApprovisionnementMagasinTest {

    @Test
    void testAjouterALaListeDesChampionsExistants() {
        Yordle champion = new Yordle("Fred", 80, 20, 20, Rarete.LEGENDAIRE);
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

    @Test
    void testRaffrechirEntitesDansMagasin() {
        int expectedResult = 5;
        Paquet result = ApprovisionnementMagasin.raffrechirEntitesDansMagasin();
        assertEquals(expectedResult, result.size());
    }

    @Test
    void testTrieRarete() {
        Yordle legendaire = new Yordle("Fred", 80, 20, 20, Rarete.LEGENDAIRE);
        Assassin rare = new Assassin("Michou", 80, 20, 20, Rarete.RARE);
        Sniper commun = new Sniper("Alex", 80, 20, 20, Rarete.COMMUN);
        ApprovisionnementMagasin.listeChampionsExistants.add(legendaire);
        ApprovisionnementMagasin.listeChampionsExistants.add(rare);
        ApprovisionnementMagasin.listeChampionsExistants.add(commun);
        ApprovisionnementMagasin.trieRarete();
        assertTrue(ApprovisionnementMagasin.getListeLegendaire().contains(legendaire));
        assertTrue(ApprovisionnementMagasin.getListeRare().contains(rare));
        assertTrue(ApprovisionnementMagasin.getListeCommun().contains(commun));
    }
}
