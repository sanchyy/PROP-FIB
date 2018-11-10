package Domini;

//Sanchy
public class Teoria extends Assignatura {

    private boolean projector;
    private Integer numHores;

    public Teoria(String nomAssig, Integer num_alumnes, Integer ngrups, Integer nsub, Integer quatri, boolean especialitat, int nivell, boolean projector, Integer numHores) {
        super(nomAssig, num_alumnes, ngrups, nsub, quatri, nivell);
        this.projector   = projector;
        this.numHores    = numHores;
    }

    //Setters
    public void setProjector (Boolean projector) {
        this.projector = projector;
    }

    public void setNumHores (Integer num_hores) {
        this.numHores = numHores;
    }


    //Getters
    public boolean getProjector () {
        return this.projector;
    }

    public int getNumHores () {
        return this.numHores;
    }


    //Auxiliars function
    public Integer getNumAlumnes () {
        return super.getNumAlumnes()/super.getNgrups();
    }

}
