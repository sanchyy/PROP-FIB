package Domini;

import java.util.ArrayList;

public class Aula {

    private String nom;
    private Integer capacitat;
    private String tipus; // "TEORIA" o "LABORATORI"
    private ArrayList<CaracteristiquesAula> caracteristiques;

    public Aula(String nom, Integer capacitat, String tipus, ArrayList<CaracteristiquesAula> caracteristiques) {
        this.nom              = nom;
        this.capacitat        = capacitat;
        this.tipus            = tipus;
        this.caracteristiques = caracteristiques;
    }

    public String getNom() {
        return this.nom;
    }

    public ArrayList<CaracteristiquesAula> getCaracteristiques() {
        return caracteristiques;
    }

}
