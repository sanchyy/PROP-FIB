package Domain;
// Berni
public class PlaEstudis {
    private Periode quadrimestre_actual;
    private ArrayList<Aula> aules_disponibles = new ArrayList<Aula>();
    private ArrayList<Assignatura> assignatures_disponibles = new ArrayList<Assignatura>();

    //Constructora
    public PlaEstudis(Periode quadrimestre_actual) {
        this.quadrimestre_actual = quadrimestre_actual;
    }

    public PlaEstudis(Periode quadrimestre_actual, ArrayList<Aula> aules_disponibles, ArrayList<Assignatura> assignatures_disponibles) {
        this.quadrimestre_actual      = quadrimestre_actual;
        this.aules_disponibles        = aules_disponibles;
        this.assignatures_disponibles = assignatures_disponibles;
    }

    //Setters
    public void setQuadrimestre_actual (Periode quadrimestre_actual) {
        this.quadrimestre_actual = quadrimestre_actual;
    }

    public void setAules_disponibles (ArrayList<Aula> aules_disponibles) {
        this.aules_disponibles = aules_disponibles;
    }

    public void setAssignatures_disponibles(ArrayList<Assignatures> assignatures_disponibles) {
        this.assignatures_disponibles = assignatures_disponibles;
    }

    public void addAula_Disponible (Aula aula_disponible) {
        this.aules_disponibles.add(aula_disponible);
    }

    public void addAssignatura_Disponible (Assignatura assignatura_disponible) {
        this.assignatures_disponibles.add(assignatura_disponible);
    }

    //Getters
    public Periode getQuadrimestre_actual() {
        return quadrimestre_actual;
    }

    public ArrayList<Aula> getAules_disponibles() {
        return aules_disponibles;
    }

    public ArrayList<Assignatura> getAssignatures_disponibles() {
        return assignatures_disponibles;
    }

}
