package Domini;

public class Aula {
    //Drea
    private String nom;
    private Integer capacitat;
    //private boolean caracteristiques[] = new boolean[6]; // Projector, Ubuntu, Linux/Windows, física, embeded, xarxes

    public Aula() {
        this.nom = null;
        this.capacitat = null;
    }

    public Aula(String nom, Integer capacitat) {
        this.nom = nom;
        this.capacitat = capacitat;
    }

    // Setters

    public void setNom (String nom_aula) {
        this.nom = nom_aula;
    }

    /*public void setCaracteristiques (boolean[] caracteristiques) {
        this.caracteristiques = caracteristiques;
    }*/

    // Getters

    public String getNom_aula () {
        return this.nom;
    }

    public Integer getCapacitat () {
        return this.capacitat;
    }

    /*public boolean[] getCaracteristics() {
        return this.caracteristiques;
    }*/


}
