package fr.univ_amu.iut;

import fr.univ_amu.iut.backend.entites.Assassin;
import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.entites.Erudit;
import fr.univ_amu.iut.backend.entites.Rarete;
import fr.univ_amu.iut.backend.joueur.Joueur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestJoueur {
    @Test
    void testAjouterAuPaquet() {
        Joueur joueur = new Joueur("Michel");
        Assassin a1 = new Assassin("Fred", 80, 20, 20, Rarete.LEGENDAIRE);
        joueur.ajouterAuPaquet(a1);
        assertEquals("Fred", joueur.getPaquet().get(0).getNom());
    }

    @Test
    void testEnleverPaquet() {
        Joueur joueur = new Joueur("Michel");
        Assassin a1 = new Assassin("Fred", 80, 20, 20, Rarete.LEGENDAIRE);
        joueur.ajouterAuPaquet(a1);
        assertEquals(1, joueur.getPaquet().size());
        joueur.enleverPaquet(a1);
        assertEquals(0, joueur.getPaquet().size());
    }

    @Test
    void testContenuPaquet() {
        Joueur joueur = new Joueur("Romain");
        Assassin a1 = new Assassin("Fred", 80, 20, 20, Rarete.LEGENDAIRE);
        Erudit e1 = new Erudit("Simon", 80, 20, 20, Rarete.LEGENDAIRE);
        joueur.ajouterAuPaquet(a1);
        joueur.ajouterAuPaquet(e1);
        assertEquals("Assassin{rarete=LEGENDAIRE, nom=Fred, pointsAttaque=80, pointsDefense=20, pointsVie=20}Erudit{rarete=LEGENDAIRE, nom=Simon, pointsAttaque=80, pointsDefense=20, pointsVie=20}", joueur.contenuPaquet());
    }

    @Test
    void testEntiteQuiALeNom() {
        Joueur joueur = new Joueur("Jean");
        Assassin a1 = new Assassin("Fred", 80, 20, 20, Rarete.LEGENDAIRE);
        Erudit e1 = new Erudit("Simon", 80, 20, 20, Rarete.LEGENDAIRE);
        joueur.ajouterAuPaquet(a1);
        joueur.ajouterAuPaquet(e1);
        assertEquals(e1, joueur.entiteQuiALeNom("Simon"));
        assertNull(joueur.entiteQuiALeNom("Hugues"));
    }
}
