package fr.univ_amu.iut.backend.entites.exceptions;

public class ValeursPersonnagesInvalides extends IllegalArgumentException{
    public ValeursPersonnagesInvalides(String messageErreur){
        super(messageErreur);
    }

    public static ValeursPersonnagesInvalides pointsDefenseNonValides(int pointsDefenseMin, int pointsDefenseMax, int pointsDefense){
        return new ValeursPersonnagesInvalides("Points de defense non valides (%d-%d). Valeur donnee : %d".formatted(pointsDefenseMin, pointsDefenseMax, pointsDefense));
    }
    public static ValeursPersonnagesInvalides pointsAttaqueNonValides(int pointsAttaqueMin, int pointsAttaqueMax, int pointsAttaque){
        return new ValeursPersonnagesInvalides("Points d'attaque non valides (%d-%d). Valeur donnee : %d".formatted(pointsAttaqueMin, pointsAttaqueMax, pointsAttaque));
    }
    public static ValeursPersonnagesInvalides pointsVieNonValides(int pointsVieMin, int pointsVieMax, int pointsVie){
        return new ValeursPersonnagesInvalides("Points de vie non valides (%d-%d). Valeur donnee : %d".formatted(pointsVieMin, pointsVieMax, pointsVie));
    }
}
