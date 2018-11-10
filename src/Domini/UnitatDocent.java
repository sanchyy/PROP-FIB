package Domini;

import java.util.ArrayList;

// Berni
public class UnitatDocent {
    private String nom;
    private ArrayList<PlaEstudis> plansEstudis;
    private ArrayList<Aula> aulesDisponibles;

    //Constructora
    public UnitatDocent(String nom) {
        this.nom = nom;
        this.plansEstudis = new ArrayList<>();
        this.aulesDisponibles= new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Aula> getAulesDisponibles() {
        return aulesDisponibles;
    }

    public ArrayList<PlaEstudis> getPlansEstudis() {
        return plansEstudis;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAulesDisponibles(ArrayList<Aula> aulesDisponibles) {
        this.aulesDisponibles = aulesDisponibles;
    }

    public void setPlansEstudis(ArrayList<PlaEstudis> plansEstudis) {
        this.plansEstudis = plansEstudis;
    }

    public void afegirAulaDisponible(Aula aula) {
        this.aulesDisponibles.add(aula);
    }

    public void afegirPlaEstudis(PlaEstudis pe) {
        this.plansEstudis.add(pe);
    }

    public void setPlansEstudis(PlaEstudis pe) {
        this.plansEstudis.add(pe);
    }

}
