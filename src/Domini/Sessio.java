package Domini;

import java.util.ArrayList;

// Berni
public class Sessio {

    private Assignatura assignatura;
    private Aula aula;
    private Integer grup;

    //Constructora
    public Sessio() {
        this.assignatura = null;
    }

    public Sessio(Integer grup, Assignatura assignatura) {
        this.grup = grup;
        this.assignatura = assignatura;
    }

    //Setters
    public void setAssignatura(Assignatura assignatura) {
        this.assignatura = assignatura;
    }

    public Integer getGrup() {
        return grup;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public void setGrup(Integer grup) {
        this.grup = grup;
    }

    //Getters
    public Assignatura getAssignatura() {
        return assignatura;
    }

    public Aula getAula() {
        return aula;
    }

    public String mostrarSessio() {
        String s = "";
        if (assignatura != null) s += assignatura.getNomAssig() + "-" + grup;
        if (aula != null) s += " (" + aula.getNom() + ")";
        return s;
    }

}
