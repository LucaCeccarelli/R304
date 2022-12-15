package fr.univ_amu.iut.backend.entites.exceptions;

public class ValeursPersonnagesInvalides extends IllegalArgumentException{
    public ValeursPersonnagesInvalides(String messageErreur){
        super(messageErreur);
    }

    public static ValeursPersonnagesInvalides pointsDefenseNonValides(int pointsDefenseMin, int pointsDefenseMax, int pointsDefense){
        return new ValeursPersonnagesInvalides("Points de defense non valides (%d-%d). Valeur donnee : %d".formatted(pointsDefenseMin, pointsDefenseMax, pointsDefense));
    }
}

