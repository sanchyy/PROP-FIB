package Domain;

public class Teoria extends Assignatura {
    private Boolean projector;
    private Integer num_alumnes;

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
