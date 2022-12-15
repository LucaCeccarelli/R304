package fr.univ_amu.iut;

import fr.univ_amu.iut.backend.entites.Assassin;
import fr.univ_amu.iut.backend.entites.Erudit;
import fr.univ_amu.iut.backend.entites.Rarete;
import fr.univ_amu.iut.backend.entites.Yordle;
import fr.univ_amu.iut.backend.joueur.Joueur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.univ_amu.iut.backend.entites.Entite;
public class TestJoueur {

        private Joueur joueur;
        private Assassin entite;

        @BeforeEach
        void setUp() {
            joueur = new Joueur("Test");
            entite = new Assassin("Fred", 80, 60, 40, Rarete.LEGENDAIRE);
        }

        @Test
        void testAjouterAuPaquet() {
            joueur.ajouterAuPaquet(entite);
            assertTrue(joueur.getPaquet().contains(entite));
        }

        @Test
        void testToString() {
            joueur.ajouterAuPaquet(entite);
            assertEquals("Joueur{paquet=Paquet : Assassin{rarete=LEGENDAIRE, nom=Fred, pointsAttaque=80, pointsDefense=40, pointsVie=60}, nom='Test'}", joueur.toString());
        }

}