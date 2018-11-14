package Domini;

public class Sessio {

    private Assignatura assignatura;
    private Aula aula;
    private Integer grup;
    private String tipus; // "TEORIA" o "LABORATORI"

    public Sessio() {
        this.assignatura = null;
    }

    public Sessio(Integer grup, Assignatura assignatura) {
        this.grup = grup;
        this.assignatura = assignatura;
    }

    public void setAssignatura(Assignatura assignatura) {
        this.assignatura = assignatura;
    }

    public Integer getGrup() {
        return grup;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Assignatura getAssignatura() {
        return assignatura;
    }

    public Aula getAula() {
        return aula;
    }

    public String mostrarSessio() {
        String s = "";
        if (assignatura != null) s += assignatura.getNom() + "-" + grup;
        if (aula != null) s += " (" + aula.getNom() + ")";
        return s;
    }

    public boolean sonIguals(Sessio comp) {
        return comp.getGrup() == grup && comp.getAssignatura().getNom().equals(assignatura.getNom());
    }

}
