package fr.univ_amu.iut.backend.entites.exceptions;

/**
 * Classe ValeursPersonnagesInvalides qui étend la classe IllegalArgumentException et qui permet de gérer les exceptions liées aux valeurs des personnages (points de vie, attaque, défense).
 */
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

