package Domini;

//Sanchy
public class Teoria extends Assignatura {

    private boolean projector;
    private int num_alumnes;
    private int num_hores;

    public Teoria(String nomAssig, boolean quatri, boolean especialitat, int nivell, boolean projector) {
        super();
        this.projector   = projector;
        this.num_alumnes = num_alumnes;
        this.num_hores   = num_hores;
    }
/*
    public Labo(Assignatura a, int num_hores, int nLabs) {
        String nom      = a.getNomAssig();
        boolean quatri  = a.getQuatri();
        boolean espec   = a.getEspec();
        int nivell  = a.getNivell();
        int grups   = a.getGrups();

        super(nom, quatri, espec, nivell, grups);
        this.num_hores = num_hores;
        this.nLabs     = nLabs;

    }
*/
    //Setters
    public void setProjector (Boolean projector) {
        this.projector = projector;
    }

    public void setNum_alumnes (Integer num_alumnes) {
        this.num_alumnes = num_alumnes;
    }

    public void setNum_hores (Integer num_hores) {
        this.num_hores = num_hores;
    }


    //Getters
    public boolean getProjector () {
        return this.projector;
    }

    public int getNum_alumnes () {
        return this.num_alumnes;
    }

    public int getNum_hores () {
        return this.num_hores;
    }
}
