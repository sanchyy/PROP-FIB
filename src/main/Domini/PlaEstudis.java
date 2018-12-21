package Domini;

import java.util.ArrayList;

public class PlaEstudis {

    private String nom;
    private ArrayList<Quadrimestre> quadrimestres;
    private ArrayList<Assignatura> assignatures;

    public PlaEstudis(String nom) {
        this.nom = nom;
        this.quadrimestres = new ArrayList<>();
        this.assignatures = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void afegirAssignatura (Assignatura assignatura) {
        this.assignatures.add(assignatura);
    }

    public void afegirQuadrimestre(Quadrimestre q) {
        this.quadrimestres.add(q);
    }

    public ArrayList<Quadrimestre> getQuadrimestres() {
        return quadrimestres;
    }

    public ArrayList<Assignatura> getAssignatures() {
        return assignatures;
    }

    public Assignatura getAssignatura(String nom) {
        for (Assignatura a : assignatures) {
            if (a.getNom().equals(nom)) {
                return a;
            }
        }
        return null;
    }

    public Assignatura getAssignatura(Integer x) {
        return assignatures.get(x-1);
    }

    public void borrarAssignatura(int i) {
        assignatures.remove(i-1);
    }

    public void borrarQuadimestre(Integer b) {
        quadrimestres.remove(b-1);
    }
}