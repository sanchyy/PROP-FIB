package Domain;

import java.util.*;
//Sanchy

public class Assignatura {

    private String  nomAssig;
    private int ngrups;


    private enum Quatri{
       PRIMER(1), SEGON(2), TOTS(3);
       private int quatri;

       private Quatri(int q) {
           quatri = q;
       }

        public void setQuatri (int quatri) {
            this.quatri = quatri;
        }

        public int getQuatri () {
           return this.quatri;
        }
    }

    private enum Nivell {
        TRONCAL(1), OBLIGATORIA(2), ESPECIALITAT(3);
        private int nivell;

        private Nivell(int nvl) {
            nivell = nvl;
        }

        public void setNivell (int nivell) {
            this.nivell = nivell;
        }

        public int getNivell () {
            return this.nivell;
        }
    }


    //Constructora
    public Assignatura(String nomAssig, Quatri quatri, Nivell n, int ngrups) {
        this.nomAssig = nomAssig;
        this.quatri   = quatri;
        this.nivell   = n;
        this.ngrups   = ngrups;
    }

    public Assignatura(String nomAssig, boolean quatri, int nivell) {
        this.nomAssig = nomAssig;
        this.quatri   = quatri;
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
    public void setNomAssig (String nomAssig) {
        this.nomAssig = nomAssig;
    }
/*
    public void setQuatri (Quatri quatri) {
        this.quatri = quatri;
    }
*/
/*
    public void setNivell (Nivell nivell) {
        this.nivell = nivell;
    }
*/
    public void setGrups(int ngrups) {
        this.ngrups = ngrups;
    }

    //Getters
    public String getNomAssig () {
        return nomAssig;
    }
/*
    public boolean getQuatri () {
        return quatri;
    }
*/
/*
    public int getNivell () {
        return nivell;
    }
*/
    public int getGrups() {
        return grups;
    }


    //Functions Aux

    public boolean isEqual(Assignatura a) {
        return (NomAssig == a.getNomAssig() && nivell == a.getNivell() && espec == a.getEspec())
    }

    public void AddGroup() {
        ++ this.grups;
    }

    public void DeleteGroup() {
        -- this.grups;
    }

}
