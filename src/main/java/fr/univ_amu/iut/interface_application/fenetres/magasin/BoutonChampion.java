package fr.univ_amu.iut.interface_application.fenetres.magasin;

import fr.univ_amu.iut.backend.entites.Entite;
import javafx.scene.control.Button;

public class BoutonChampion extends Button {
    private Entite entite;

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
            case COMMUN -> super.setStyle("-fx-background-color: Green");
            case RARE -> super.setStyle("-fx-background-color: Purple");
            case LEGENDAIRE -> super.setStyle("-fx-background-color: Yellow");
        }
    }

    public Entite getEntite() {
        return entite;
    }

    public void setEntite(Entite entite) {
        this.entite = entite;
        initBouton();
    }
}
