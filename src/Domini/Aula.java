package Domini;

import java.util.ArrayList;

public class Aula {
    //Drea
    private String nom;
    private Integer capacitat;
    private String tipus; // "TEORIA" o "LABORATORI"
    private ArrayList<CaracteristiquesAula> caracteristiques;

    public Aula(String nom, Integer capacitat, String tipus, ArrayList<CaracteristiquesAula> caracteristiques) {
        this.nom = nom;
        this.capacitat = capacitat;
        this.tipus = tipus;
        this.caracteristiques = caracteristiques;
    }

    // Setters
    public void setNom (String nom_aula) {
        this.nom = nom_aula;
    }

    // Getters
    public String getNom () {
        return this.nom;
    }

    public Integer getCapacitat () {
        return this.capacitat;
    }

    public ArrayList<CaracteristiquesAula> getCaracteristiques() {
        return caracteristiques;
    }

    public String getTipus() {
        return tipus;
    }
}
