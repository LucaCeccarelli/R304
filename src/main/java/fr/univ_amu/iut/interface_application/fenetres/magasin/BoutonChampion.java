package fr.univ_amu.iut.interface_application.fenetres.magasin;

import fr.univ_amu.iut.backend.entites.Entite;
import javafx.scene.control.Button;

public class BoutonChampion extends Button {
    private Entite entite;
    private int indiceBouton;

    public BoutonChampion(Entite entite, int indiceBouton){
        super();
        setEntite(entite);
        this.indiceBouton = indiceBouton;
    }
    public BoutonChampion(Entite entite){
        super();
        setEntite(entite);
    }

    public BoutonChampion(){
        super();
    }

    private void initBouton(){
        super.setText("Nom : "+entite.getNom()+"\n"
                +"Type :"+entite.getType()+"\n" );
        switch (entite.getRarete()){
            case COMMUN -> super.setStyle("-fx-background-color: #7ed957");
            case RARE -> super.setStyle("-fx-background-color: #8c52ff");
            case LEGENDAIRE -> super.setStyle("-fx-background-color: #fcd24f");
        }
    }

    public Entite getEntite() {
        return entite;
    }

    public void setEntite(Entite entite) {
        this.entite = entite;
        initBouton();
    }

    public int getIndiceBouton() {
        return indiceBouton;
    }
}
