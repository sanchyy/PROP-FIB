package Domain;
import Domain.Caracteristiques;

import java.util.ArrayList;

public class Labo extends Assignatura {

    private Integer num_alumnes;
    private Boolean[] necessita_caract;


    public Labo(String nomAssig, Boolean quatri, Boolean especialitat, Integer nivell, Boolean[] caract) {
        super();
        this.necessita_caract = caract;

    }

    //Setters

    public void setNum_alumnes (Integer num_alumnes) {
        this.num_alumnes = num_alumnes;
    }

    public void setMaterial (Boolean[] material) {
        Caracteristiques.setMaterial(material);
    }

    //Getters

    public Integer getNum_alumnes () {
        return this.num_alumnes;
    }

    public Boolean[] getCaract () {
        return Caracteristiques.getCaract();
    }
}
