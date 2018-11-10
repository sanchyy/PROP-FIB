package Domini;


public class Aula {
    //Drea
    private String nom_aula;
    private Integer capacitat;
    //private boolean caracteristiques[] = new boolean[6]; // Projector, Ubuntu, Linux/Windows, física, embeded, xarxes

    public Aula (String nom_aula, Integer capacitat) {
        this.nom_aula = nom_aula;
        this.capacitat = capacitat;
        //this.caracteristiques = caracteristiques;
    }

    public Aula() {
        this.nom_aula = null;
        this.capacitat = null;
        //this.caracteristiques = null;
    }

    // Setters

    public void setNom_aula (String nom_aula) {
        this.nom_aula = nom_aula;
    }

    public void setCapacitat (Integer capacitat) {
        this.capacitat = capacitat;
    }

    /*public void setCaracteristiques (boolean[] caracteristiques) {
        this.caracteristiques = caracteristiques;
    }*/

    // Getters

    public String getNom_aula () {
        return this.nom_aula;
    }

    public Integer getCapacitat () {
        return this.capacitat;
    }

    /*public boolean[] getCaracteristics() {
        return this.caracteristiques;
    }*/


}
