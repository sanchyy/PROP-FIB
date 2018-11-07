package Domini;

//Sanchy
public class Teoria extends Assignatura {

    private boolean projector;
    private int num_hores;

    public Teoria(String nomAssig, boolean quatri, boolean especialitat, int nivell, boolean projector) {
        super();
        this.projector   = projector;
        this.num_hores   = num_hores;
    }

    //Setters
    public void setProjector (Boolean projector) {
        this.projector = projector;
    }

    public void setNum_hores (Integer num_hores) {
        this.num_hores = num_hores;
    }


    //Getters
    public boolean getProjector () {
        return this.projector;
    }

    public int getNum_hores () {
        return this.num_hores;
    }


    //Auxiliars function
    public int getNum_alumnes () {
        return super.num_alumnes;
    }

}
