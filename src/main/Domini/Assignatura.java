package Domini;

import java.util.ArrayList;

public class Assignatura {

    private String  nom;
    private Integer quadri; // 1r 2n o tots (3)
    private Integer nivell; // Troncal (1), Obligatori (2), Especialitat (3)
    private String plaEstudis;
    private ArrayList<CaracteristiquesAula> caracteristiquesTeoria;
    private ArrayList<CaracteristiquesAula> caracteristiquesLabo;

    public Assignatura(String nom, Integer quatri, Integer nivell, ArrayList<CaracteristiquesAula> teo, ArrayList<CaracteristiquesAula> labo) {
        this.nom         = nom;
        this.quadri      = quatri;
        this.nivell      = nivell;
        this.plaEstudis  = null;
        this.caracteristiquesTeoria = teo;
        this.caracteristiquesLabo   = labo;
    }

    public Assignatura (String nom, Integer quatri, Integer nivell, String plaEstudis, ArrayList<CaracteristiquesAula> teo, ArrayList<CaracteristiquesAula> labo) {
        this.nom         = nom;
        this.quadri      = quatri;
        this.nivell      = nivell;
        this.plaEstudis  = plaEstudis;
        this.caracteristiquesTeoria = teo;
        this.caracteristiquesLabo   = labo;
    }

    public String getNom() {
        return nom;
    }

    public Integer getNivell() {
        return nivell;
    }

    public Integer getQuadri() {
        return quadri;
    }

    public String getPlaEstudis() {
        return plaEstudis;
    }

    public boolean isEqual(Assignatura a) {
        return (this.nom.equals(a.getNom()) && nivell.intValue() == a.getNivell().intValue() && this.quadri.intValue() == quadri.intValue());
    }

    public ArrayList<CaracteristiquesAula> getCaracteristiquesLabo() {
        return caracteristiquesLabo;
    }

    public ArrayList<CaracteristiquesAula> getCaracteristiquesTeoria() {
        return caracteristiquesTeoria;
    }

    public void setPlaEstudis(String plaEstudis) {
        this.plaEstudis = plaEstudis;
    }
}
