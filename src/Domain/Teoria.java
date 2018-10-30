package Domain;

import Domain.Caracteristiques;

public class Teoria extends Assignatura {
    private Boolean projector;
    private Integer num_alumnes;


    public Teoria(String nomAssig, Boolean quatri, Boolean especialitat, Integer nivell, Boolean projector) {
        super();
        this.projector = projector;
    }

    //Setters
    public void setProjector (Boolean projector) {
        this.projector = projector;
    }

    public void setNum_alumnes (Integer num_alumnes) {
        this.num_alumnes = num_alumnes;
    }

    //Getters
    public Boolean getProjector () {
        return this.projector;
    }

    public Integer getNum_alumnes () {
        return this.num_alumnes;
    }
}
