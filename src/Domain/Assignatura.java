package Domain;

public class Assignatura {
    //Sanchy
    private String  nomAssig;
    private boolean quatri;
    private boolean espec;
    private int     nivell;

    //constructora
    public Assignatura(String nomAssig, boolean quatri, boolean especialitat, int nivell) {
        this.nomAssig = nomAssig;
        this.quatri   = quatri;
        this.espec    = especialitat;
        this.nivell   = nivell;
    }

    //setters
    public void SetNomAssig (String nomAssig) {
        this.nomAssig = nomAssig;
    }

    public void setQuatri (boolean quatri) {
        this.quatri = quatri;
    }

    public void setEspec (boolean espec) {
        this.espec = espec;
    }

    public void setNivell (int nivell) {
        this.nivell = nivell;
    }

    //getters
    public String GetNomAssig () {
        return this.nomAssig;
    }

    public boolean GetQuatri () {
        return this.quatri;
    }

    public boolean GetEspec () {
        return this.espec;
    }

    public int GetNivell () {
        return this.nivell;
    }
}
