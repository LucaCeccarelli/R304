package fr.univ_amu.iut.interface_application.fenetres.outils;

import fr.univ_amu.iut.backend.entites.Entite;
import javafx.scene.control.Button;

/**
 * Cette classe représente un bouton associé à une entité.
 * Cette entité peut être affichée dans le bouton en modifiant son style et son texte.
 */
public class BoutonChampion extends Button {

    /**
     * L'entité associée au bouton
     */
    private Entite entite;

    /**
     * L'indice du bouton
     */
    private int indiceBouton;

    /**
     * Construit un bouton à partir d'une entité et d'un indice
     *
     * @param entite l'entité associée au bouton
     * @param indiceBouton l'indice du bouton
     */
    public BoutonChampion(Entite entite, int indiceBouton){
        super();
        setEntite(entite);
        this.indiceBouton = indiceBouton;
    }

    /**
     * Construit un bouton sans entité associée
     */
    public BoutonChampion(){
        super();
    }

    /**
     * Initialise le texte et le style du bouton en fonction de l'entité associée
     */
    private void initBouton(){
        super.setText("Nom : "+entite.getNom()+"\n"
                +"Type :"+entite.getType()+"\n"
                +"Vie :"+entite.getPointsVie()+"\n"
                +"Attaque :"+entite.getPointsAttaque()+"\n"
                +"Défense :"+ entite.getPointsDefense()+"\n");
        switch (entite.getRarete()){
            case COMMUN -> super.setStyle("-fx-background-color: #7ed957");
            case RARE -> super.setStyle("-fx-background-color: #8c52ff");
            case LEGENDAIRE -> super.setStyle("-fx-background-color: #fcd24f");
        }
    }

    /**
     * Retourne l'entité associée au bouton
     *
     * @return l'entité associée au bouton
     */
    public Entite getEntite() {
        return entite;
    }

    /**
     * Définit l'entité associée au bouton
     *
     * @param entite l'entité associée au bouton
     */
    public void setEntite(Entite entite) {
        this.entite = entite;
        initBouton();
    }

    /**
     * Retourne l'indice du bouton
     *
     * @return l'indice du bouton
     */
    public int getIndiceBouton() {
        return indiceBouton;
    }

    /**
     * Définit l'indice du bouton
     *
     * @param indiceBouton l'indice du bouton
     */
    public void setIndiceBouton(int indiceBouton) {
        this.indiceBouton = indiceBouton;
    }
}
