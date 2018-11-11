package Domini;

import java.util.ArrayList;
// Berni
public class PlaEstudis {
    private String nom;
    private ArrayList<Quadrimestre> quadrimestres;
    private ArrayList<Assignatura> assignatures = new ArrayList<>();

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    //Constructora
    public PlaEstudis(String nom) {
        this.nom = nom;
        this.quadrimestres = new ArrayList<>();
    }

    public PlaEstudis () {
        this.nom = null;
        this.quadrimestres = new ArrayList<>();
    }

    //Setters
    public void setAssignatures(ArrayList<Assignatura> assignatura) {
        this.assignatures = assignatura;
    }

    public void afegirAssignatura (Assignatura assignatura) {
        this.assignatures.add(assignatura);
    }

    public void afegirQuadrimestre(Quadrimestre q) {
        this.quadrimestres.add(q);
    }

    //Getters
    public ArrayList<Assignatura> getAssignatures() {
        return assignatures;
    }

    public Assignatura getAssignatura(String nom) {
        for (Assignatura a : assignatures) {
            if (a.getNomAssig().equals(nom)) {
                return a;
            }
        }
        return null;
    }

}