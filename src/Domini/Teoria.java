package Domini;

//Sanchy
public class Teoria extends Assignatura {

    private boolean projector;
    private Integer num_hores;

    public Teoria(String nomAssig, Integer num_alumnes, Integer ngrups, Integer nsub, Integer quatri, boolean especialitat, int nivell, boolean projector, Integer num_hores) {
        super(nomAssig, num_alumnes, ngrups, nsub, quatri, nivell);
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
    public Integer getNum_alumnes () {
        return super.getNum_alumnes()/super.getNgrups();
    }

}
