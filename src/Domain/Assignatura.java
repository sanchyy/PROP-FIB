package Domain;

//Sanchy
public class Assignatura {

    private String  nomAssig;
    private Boolean quatri; //True si quatri tardor; Else primavera
    private Boolean espec;  //True si espec; Else no
    private enum Nivell {
        TRONCAL(1), OBLIGATORIA(2), ESPECIALITAT(3);
        private int nivell;
    }
    private Integer ngrups;

    //Constructora
    public Assignatura(String nomAssig, Boolean quatri, Boolean espec, Nivell n, Integer ngrups) {
        this.nomAssig = nomAssig;
        this.quatri   = quatri;
        this.espec    = especialitat;
        this.nivell   = n;
        this.ngrups   = ngrups;
    }

    public Assignatura(String nomAssig, Boolean quatri, Boolean espec, Integer nivell) {
        this.nomAssig = nomAssig;
        this.quatri   = quatri;
        this.espec    = especialitat;
        this.nivell   = nivell;
        this.grups    = null;
    }

    public Assignatura (String nomAssig) {
        this.nomAssig = nomAssig;
        this.quatri   = null;
        this.espec    = null;
        this.nivell   = null;
        this.grups    = null;
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

    public void setGrups(Integer ngrups) {
        this.ngrups = grups;
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

    public int getGrups() {
        return this.grups;
    }


    //Functions Aux
    public void AddGroup() {
        ++ this.grups;
    }

    public void DeleteGroup() {
        -- this.grups;
    }
}
