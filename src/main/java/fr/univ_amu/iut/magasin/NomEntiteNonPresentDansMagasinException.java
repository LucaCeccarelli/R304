package fr.univ_amu.iut.magasin;

public class NomEntiteNonPresentDansMagasinException extends Exception{
    public NomEntiteNonPresentDansMagasinException(String messageErreur){
        super(messageErreur);
    }
}
