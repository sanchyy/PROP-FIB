package Domini;

import java.util.ArrayList;

// Berni
public class UnitatDocent {
    private String nom;
    private ArrayList<PlaEstudis> plansEstudis;
    private ArrayList<Aula> aulesDisponibles;
    /*private ArrayList<Aula_teo> aulesTeo;
    private ArrayList<Aula_lab> aulesLab;*/

    //Constructora
    public UnitatDocent(String nom) {
        this.nom = nom;
        this.plansEstudis = new ArrayList<>();
        this.aulesDisponibles= new ArrayList<>();
        /*this.aulesTeo = new ArrayList<>();
        this.aulesLab = new ArrayList<>();*/
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

    /*public ArrayList<Aula_lab> getAulesLab() {
        return aulesLab;
    }

    public ArrayList<Aula_teo> getAulesTeo() {
        return aulesTeo;
    }*/

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAulesDisponibles(ArrayList<Aula> aulesDisponibles) {
        this.aulesDisponibles = aulesDisponibles;
    }

    public void setPlansEstudis(ArrayList<PlaEstudis> plansEstudis) {
        this.plansEstudis = plansEstudis;
    }

    /*public void setAulesTeo(ArrayList<Aula_teo> aulesTeo) {
        this.aulesTeo = aulesTeo;
    }

    public void setAulesLab (ArrayList<Aula_lab> aulesLab) {
        this.aulesLab = aulesLab;
    }*/

    public void afegirAulaDisponible(Aula aula) {
        this.aulesDisponibles.add(aula);
    }

    public void afegirPlaEstudis(PlaEstudis pe) {
        this.plansEstudis.add(pe);
    }

    /*public void afegirAulaTeo (Aula_teo at) {
        this.aulesTeo.add(at);
    }

    public void afefirAulaLab (Aula_lab al) {
        this.aulesLab.add(al);
    }*/

    public void setPlansEstudis(PlaEstudis pe) {
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

}
