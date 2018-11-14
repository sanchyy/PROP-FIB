package Domini;

public class Assignatura {

    private String  nom;
    private Integer quadri; // 1r 2n o tots (3)
    private Integer nivell; // Troncal (1), Obligatori (2), Especialitat (3)
    private String plaEstudis;

    public Assignatura(String nom, Integer quatri, Integer nivell) {
        this.nom         = nom;
        this.quadri      = quatri;
        this.nivell      = nivell;
        this.plaEstudis  = null;
    }

    public Assignatura (String nom, Integer quatri, Integer nivell, String plaEstudis) {
        this.nom         = nom;
        this.quadri      = quatri;
        this.nivell      = nivell;
        this.plaEstudis  = plaEstudis;
    }

    public String getNom() {
        return nom;
    }

    public Integer getNivell() {
        return nivell;
    }

    public boolean isEqual(Assignatura a) {
        return (this.nom.equals(a.getNom()) && nivell.intValue() == a.getNivell().intValue() && this.quadri.intValue() == quadri.intValue());
    }

}
