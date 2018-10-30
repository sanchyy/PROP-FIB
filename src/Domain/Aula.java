package Domain;
import Domain.Caracteristiques;


public class Aula {
    //Drea
    private String nom_aula;
    private Integer capacitat;

    public Aula (String nom_aula, Integer capacitat) {
        this.nom_aula = nom_aula;
        this.capacitat = capacitat;
        //this.caracteristics = caracteristics;
    }

    // Setters

    public void setNom_aula (String nom_aula) {
        this.nom_aula = nom_aula;
    }

    public void setCapacitat (Integer capacitat) {
        this.capacitat = capacitat;
    }

    public void setCaracteristiques (Boolean[] caracteristics) {
        this.caracteristics = caracteristics;
    }

    // Getters

    public String getNom_aula () {
        return this.nom_aula;
    }

    public Integer getCapacitat () {
        return this.capacitat;
    }

    public Boolean[] getCaracteristics() {
        return this.caracteristics;
    }
}
