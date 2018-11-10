package Domini;

//Sanchy

public class Assignatura {

    private String  nomAssig;
    private Integer num_alumnes;
    private Integer ngrups;
    private Integer nsubgrups;
    private Integer quatri; //1r 2n o tots (3)
    private Integer nivell; //1, 2 o 3


    //Constructora

    public  Assignatura () {

        nomAssig = null;
        num_alumnes = 0;
        ngrups = 0;
        nsubgrups = 0;
        quatri = 0;
        nivell = 0;
    }

    public Assignatura(String nomAssig, Integer num_alumnes, Integer ngrups, Integer nsubgrups, Integer quatri, Integer nivell) {
        this.nomAssig    = nomAssig;
        this.num_alumnes = num_alumnes;
        this.ngrups      = ngrups;
        this.nsubgrups   = nsubgrups;
        this.quatri      = quatri;
        this.nivell      = nivell;
    }


    //Setters
    public void setNum_alumnes(Integer num_alumnes) {
        this.num_alumnes = num_alumnes;
    }

    public void setNomAssig (String nomAssig) {
        this.nomAssig = nomAssig;
    }

    public void setNgrups(Integer ngrups) {
        this.ngrups = ngrups;
    }

    public void setQuatri(Integer quatri) {
        this.quatri = quatri;
    }

    public void setNivell(Integer nivell) {
        this.nivell = nivell;
    }

    public void setNsubgrups(Integer nsubgrups) {
        this.nsubgrups = nsubgrups;
    }


    //Getters
    public String getNomAssig () {
        return nomAssig;
    }

    public Integer getNum_alumnes() {
        return num_alumnes;
    }

    public int getNgrups() {
        return ngrups;
    }

    public Integer getQuatri() {
        return quatri;
    }

    public Integer getNivell() {
        return nivell;
    }

    public Integer getNsubgrups() {
        return nsubgrups;
    }


    //Functions Aux
    public boolean isEqual(Assignatura a) {
        return (this.nomAssig.equals(a.getNomAssig()) && nivell.intValue() == a.getNivell().intValue() && this.quatri.intValue() == quatri.intValue());
    }

}
