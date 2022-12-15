package fr.univ_amu.iut.backend.magasin.exceptions;

public class NomEntiteNonPresentDansMagasinException extends Exception{
    public NomEntiteNonPresentDansMagasinException(String messageErreur){
        super(messageErreur);
    }
}
