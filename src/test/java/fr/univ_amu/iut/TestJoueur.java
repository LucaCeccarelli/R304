package fr.univ_amu.iut;

import fr.univ_amu.iut.backend.entites.Assassin;
import fr.univ_amu.iut.backend.entites.Erudit;
import fr.univ_amu.iut.backend.entites.Rarete;
import fr.univ_amu.iut.backend.entites.Yordle;
import fr.univ_amu.iut.backend.joueur.Joueur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJoueur {
    @Test
    void testAjouterAuPaquet() {
        Joueur joueur = new Joueur("Michel");
        Yordle s1 = new Yordle("Fred", 80, 10, 10, Rarete.LEGENDAIRE);
        joueur.ajouterAuPaquet(s1);
        assertEquals("Fred", joueur.getPaquet().get(0).getNom());
    }

}