package Domini;

//Sanchy
public class Assignatura {

    private String  nomAssig;
    private Integer quatri; //1r 2n o tots (3)
    private Integer nivell; //1, 2 o 3 -> Troncal, Obligatori, Especialitat
    private String plaEstudis;

    //Constructora
    public Assignatura () {
        nomAssig = null;
        quatri = 0;
        nivell = 0;
        plaEstudis = null;
    }

    public Assignatura(String nomAssig, Integer quatri, Integer nivell) {
        this.nomAssig    = nomAssig;
        this.quatri      = quatri;
        this.nivell      = nivell;
        this.plaEstudis  = null;
    }

    public Assignatura (String nomAssig, Integer quatri, Integer nivell, String plaEstudis) {
        this.nomAssig    = nomAssig;
        this.quatri      = quatri;
        this.nivell      = nivell;
        this.plaEstudis  = plaEstudis;
    }

    //Setters
    public void setNomAssig (String nomAssig) {
        this.nomAssig = nomAssig;
    }

    public void setQuatri(Integer quatri) {
        this.quatri = quatri;
    }

    public void setNivell(Integer nivell) {
        this.nivell = nivell;
    }

    public void setPlaEstudis (String plaEstudis) {
        this.plaEstudis = plaEstudis;
    }

    //Getters
    public String getNomAssig () {
        return nomAssig;
    }

    public Integer getQuatri() {
        return quatri;
    }

    public Integer getNivell() {
        return nivell;
    }

    public String getPlaEstudis() {
        return plaEstudis;
    }

    //Functions Aux
    public boolean isEqual(Assignatura a) {
        return (this.nomAssig.equals(a.getNomAssig()) && nivell.intValue() == a.getNivell().intValue() && this.quatri.intValue() == quatri.intValue());
    }

    public void eliminarPlaEstudis() {
        plaEstudis = null;
    }
}
