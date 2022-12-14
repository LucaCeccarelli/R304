package fr.univ_amu.iut;

import fr.univ_amu.iut.backend.entites.Assassin;
import fr.univ_amu.iut.backend.entites.Entite;
import fr.univ_amu.iut.backend.entites.Rarete;
import fr.univ_amu.iut.backend.outils.multijoueur.client.Client;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        Client client = new Client("localhost",10013);
        try {
            client.connexion();
            System.out.println("cc");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}