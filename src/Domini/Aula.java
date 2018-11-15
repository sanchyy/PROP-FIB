package Domini;

import java.util.ArrayList;

public class Aula {

    private String nom;
    private Integer capacitat;
    private String tipus; // "TEORIA" o "LABORATORI"
    private ArrayList<CaracteristiquesAula> caracteristiques;

    public Aula() {
        this.nom              = null;
        this.capacitat        = 0;
        this.tipus            = null;
        this.caracteristiques = new ArrayList<CaracteristiquesAula>();
    }

    public Aula(String nom, Integer capacitat, String tipus, ArrayList<CaracteristiquesAula> caracteristiques) {
        this.nom              = nom;
        this.capacitat        = capacitat;
        this.tipus            = tipus;
        this.caracteristiques = caracteristiques;
    }


    //Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCapacitat(Integer capacitat) {
        this.capacitat = capacitat;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public void setCaracteristiques(ArrayList<CaracteristiquesAula> caracteristiques) {
        this.caracteristiques = caracteristiques;
    }


    //Getters
    public String getNom() {
        return nom;
    }

    public Integer getCapacitat() {
        return capacitat;
    }

    public String getTipus() {
        return tipus;
    }

    public ArrayList<CaracteristiquesAula> getCaracteristiques() {
        return caracteristiques;
    }

}