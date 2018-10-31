package Domain;

import Domain.Caracteristiques;
//Sanchy
public class Teoria extends Assignatura {
    private Boolean projector;
    private Integer num_alumnes;
    private Integer num_hores;

    public Teoria(String nomAssig, Boolean quatri, Boolean especialitat, Integer nivell, Boolean projector) {
        super();
        this.projector   = projector;
        this.num_alumnes = num_alumnes;
        this.num_hores   = num_hores;
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
    public void setProjector (Boolean projector) {
        this.projector = projector;
    }

    public void setNum_alumnes (Integer num_alumnes) {
        this.num_alumnes = num_alumnes;
    }

    public void setNum_hores (Integer num_hores) {
        this.num_hores = num_hores;
    }


    //Getters
    public Boolean getProjector () {
        return this.projector;
    }

    public Integer getNum_alumnes () {
        return this.num_alumnes;
    }

    public Integer getNum_hores () {
        return this.num_hores;
    }
}
