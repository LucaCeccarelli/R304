package fr.univ_amu.iut.backend.magasin;

public class NomEntiteNonPresentDansMagasinException extends Exception{
    public NomEntiteNonPresentDansMagasinException(String messageErreur){
        super(messageErreur);
    }
}
