package Domain;
import Domain.Caracteristiques;

import java.util.ArrayList;

public class Labo extends Assignatura {

    private Integer num_alumnes;
    private Caracteristiques necessita_caract;
    private Integer num_hores;
    private Integer nLabs;


    public Labo(String nomAssig, Boolean quatri, Boolean especialitat, Integer nivell, Boolean[] caract, Integer num_hores, Integer nLabs) {
        super();
        this.necessita_caract = new Caracteristiques(caract);
        this.num_hores        = num_hores;
        this.nLabs            = nLabs;

    }

    public Labo(Assignatura a, Boolean[] caract, Integer num_hores, Integer nLabs) {
        String nom      = a.getNomAssig();
        Boolean quatri  = a.getQuatri();
        Boolean espec   = a.getEspec();
        Integer nivell  = a.getNivell();
        Integer grups   = a.getGrups();

        super(nom, quatri, espec, nivell, grups);
        this.necessita_caract = new Caracteristiques(caract);
        this.num_hores        = num_hores;
        this.nLabs            = nLabs;

    }

    //Setters

    public void setNum_alumnes (Integer num_alumnes) {
        this.num_alumnes = num_alumnes;
    }

    public void setCaract (Boolean[] material) {
        Caracteristiques.setMaterial(material);
    }

    public void setNum_hores (Integer num_hores) {
        this.num_hores = num_hores;
    }

    public void setnLabs (Integer nLabs) {
        this.nLabs = nLabs;
    }

    //Getters
    public Integer getNum_alumnes () {
        return this.num_alumnes;
    }

    public Boolean[] getCaract () {
        return Caracteristiques.getCaract();
    }

    public Integer getNum_hores () {
        return this.num_hores;
    }

    public Integer getnLabs () {
        return this.nLabs;
    }
}
