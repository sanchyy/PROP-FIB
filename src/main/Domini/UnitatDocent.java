package main.Domini;

import java.util.ArrayList;

public class UnitatDocent {
    private String nom;
    private ArrayList<PlaEstudis> plansEstudis;
    private ArrayList<Aula> aulesDisponibles;

    public UnitatDocent(String nom) {
        this.nom              = nom;
        this.plansEstudis     = new ArrayList<>();
        this.aulesDisponibles = new ArrayList<>();
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

    public void afegirAulaDisponible(Aula aula) {
        this.aulesDisponibles.add(aula);
    }

    public void afegirPlaEstudis(PlaEstudis pe) {
        this.plansEstudis.add(pe);
    }

    public PlaEstudis buscarPlaEstudis (String nomPlaEstudis) {
        for (PlaEstudis plaEstudis : plansEstudis) {
            if (plaEstudis.getNom().equals(nomPlaEstudis)) {
                return plaEstudis;
            }
        }
        return null;
    }

    public Aula getAula(String nom) {
        for (Aula a : aulesDisponibles) {
            if (a.getNom().equals(nom)) {
                return a;
            }
        }
        return null;
    }

    public void BorrarPlaEstudis(int i) {
        plansEstudis.remove(i-1);
    }

    public void borrarAula(Integer b) {
        aulesDisponibles.remove(b-1);
    }
}
