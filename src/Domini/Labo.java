package Domini;

//Sanchy
public class Labo extends Assignatura {

    private int num_alumnes;
    private int num_hores;
    private int nLabs;
    private boolean[] necessita;


    public Labo(String nomAssig, boolean quatri, boolean especialitat, int nivell, int num_hores, int nLabs, boolean[] necessita) {
        super();
        this.num_hores = num_hores;
        this.nLabs     = nLabs;
        this.necessita = necessita;
    }
/*
    public Labo(Assignatura a, int num_hores, int nLabs, boolean[] necessita) {
        String nom      = a.getNomAssig();
        boolean quatri  = a.getQuatri();
        boolean espec   = a.getEspec();
        int nivell      = a.getNivell();
        int grups       = a.getGrups();

        super(nom, quatri, espec, nivell, grups,);
        this.num_hores = num_hores;
        this.nLabs     = nLabs;
        this.necessita = nec;

    }
*/
    //Setters

    public void setNum_alumnes (int num_alumnes) {
        this.num_alumnes = num_alumnes;
    }

    public void setNum_hores (int num_hores) {
        this.num_hores = num_hores;
    }

    public void setnLabs (int nLabs) {
        this.nLabs = nLabs;
    }

    public void setNecessita(boolean[] necessita) {
        this.necessita = necessita;
    }

    public boolean[] getNecessita() {
        return necessita;
    }

    //Getters
    public Integer getNum_alumnes () {
        return num_alumnes;
    }

    public Integer getNum_hores () {
        return num_hores;
    }

    public Integer getnLabs () {
        return nLabs;
    }

    public boolean hoNecesita (int i) {
        return necessita[i];
    }

    public void canviNecessitat(int i, boolean b) {
        necessita[i] = b;
    }
}
