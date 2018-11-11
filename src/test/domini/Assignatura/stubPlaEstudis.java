package test.domini.Assignatura;

import Domini.Assignatura;
import Domini.Quadrimestre;

import java.util.ArrayList;

public class stubPlaEstudis {
    private String nom;
    //private ArrayList<Quadrimestre> quadrimestres;
    private ArrayList<Assignatura> assignatures = new ArrayList<>();

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    //Constructora
    public stubPlaEstudis(String nom) {
        this.nom = nom;
        //this.quadrimestres = new ArrayList<>();
    }

    public stubPlaEstudis () {
        this.nom = null;
        //this.quadrimestres = new ArrayList<>();
    }
    public void setAssignatures(ArrayList<Assignatura> assignatura) {
        this.assignatures = assignatura;
    }

    public void afegirAssignatura (Assignatura assignatura) {
        this.assignatures.add(assignatura);
    }

    /*public void afegirQuadrimestre(Quadrimestre q) {
        this.quadrimestres.add(q);
    }*/

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
