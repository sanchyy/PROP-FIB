package main.Domini;

import java.util.ArrayList;

public class Aula {

    private String nom;
    private Integer capacitat;
    private ArrayList<CaracteristiquesAula> caracteristiques;

    public Aula() {
        this.nom              = null;
        this.capacitat        = 0;
        this.caracteristiques = new ArrayList<CaracteristiquesAula>();
    }

    public Aula(String nom, Integer capacitat, ArrayList<CaracteristiquesAula> caracteristiques) {
        this.nom              = nom;
        this.capacitat        = capacitat;
        this.caracteristiques = caracteristiques;
    }


    //Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCapacitat(Integer capacitat) {
        this.capacitat = capacitat;
    }

    public void setCaracteristiques(ArrayList<CaracteristiquesAula> caracteristiques) {
        this.caracteristiques = caracteristiques;
    }


    //Getters
    public String getNom() {
        return this.nom;
    }

    public Integer getCapacitat() {
        return capacitat;
    }

    public ArrayList<CaracteristiquesAula> getCaracteristiques() {
        return caracteristiques;
    }

}
