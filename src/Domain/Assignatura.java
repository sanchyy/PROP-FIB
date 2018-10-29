package Domain;

public class Assignatura {
    //Sanchy
    private String  nomAssig;
    private Boolean quatri;
    private Boolean espec;
    private Integer nivell;

    //Constructora
    public Assignatura(String nomAssig, Boolean quatri, Boolean especialitat, Integer nivell) {
        this.nomAssig = nomAssig;
        this.quatri   = quatri;
        this.espec    = especialitat;
        this.nivell   = nivell;
    }

    //Setters
    public void SetNomAssig (String nomAssig) {
        this.nomAssig = nomAssig;
    }

    public void setQuatri (Boolean quatri) {
        this.quatri = quatri;
    }

    public void setEspec (Boolean espec) {
        this.espec = espec;
    }

    public void setNivell (Integer nivell) {
        this.nivell = nivell;
    }

    //Getters
    public String getNomAssig () {
        return this.nomAssig;
    }

    public boolean getQuatri () {
        return this.quatri;
    }

    public boolean getEspec () {
        return this.espec;
    }

    public int getNivell () {
        return this.nivell;
    }
}
