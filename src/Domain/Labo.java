package Domain;

import java.util.*;
//Sanchy
public class Labo extends Assignatura {

    private int num_alumnes;
    private int num_hores;
    private int nLabs;


    public Labo(String nomAssig, boolean quatri, boolean especialitat, int nivell, int num_hores, int nLabs) {
        super();
        this.num_hores        = num_hores;
        this.nLabs            = nLabs;
    }

    public Labo(Assignatura a, Integer num_hores, Integer nLabs) {
        String nom      = a.getNomAssig();
        boolean quatri  = a.getQuatri();
        boolean espec   = a.getEspec();
        int nivell      = a.getNivell();
        int grups       = a.getGrups();

        super(nom, quatri, espec, nivell, grups);
        this.num_hores = num_hores;
        this.nLabs     = nLabs;
    }

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

    //Getters
    public Integer getNum_alumnes () {
        return this.num_alumnes;
    }

    public Integer getNum_hores () {
        return this.num_hores;
    }

    public Integer getnLabs () {
        return this.nLabs;
    }
}
