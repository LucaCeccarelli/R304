package fr.univ_amu.iut.backend.magasin.exceptions;

/**
 * Cette classe représente une exception qui est lancée lorsqu'un nom d'entité n'est pas présent dans le magasin.
 */
public class NomEntiteNonPresentDansMagasinException extends Exception{
    public NomEntiteNonPresentDansMagasinException(String messageErreur){
        super(messageErreur);
    }
}
