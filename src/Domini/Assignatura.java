package Domini;

//Sanchy
public class Assignatura {

    private String  nomAssig;
    private Integer quatri; //1r 2n o tots (3)
    private Integer nivell; //1, 2 o 3 -> Troncal, Obligatori, Especialitat

    //Constructora
    public  Assignatura () {
        nomAssig = null;
        quatri = 0;
        nivell = 0;
    }

    public Assignatura(String nomAssig, Integer ngrups, Integer nsubgrups, Integer quatri, Integer nivell) {
        this.nomAssig    = nomAssig;
        this.quatri      = quatri;
        this.nivell      = nivell;
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

    //Functions Aux
    public boolean isEqual(Assignatura a) {
        return (this.nomAssig.equals(a.getNomAssig()) && nivell.intValue() == a.getNivell().intValue() && this.quatri.intValue() == quatri.intValue());
    }
}
