package Domini;

import java.util.ArrayList;

// Berni
public class Sessio {

    private Assignatura assignatura;
    private Aula aula;
    private Integer grup;
    private ArrayList< Pair<Integer, Integer> > restriccionsHoraries = new ArrayList<>();

    //Constructora
    public Sessio() {
        this.assignatura = null;
    }

    public Sessio(Integer grup, Assignatura assignatura, Pair<Integer, Integer> restriccioHoraria) {
        this.grup = grup;
        this.assignatura = assignatura;
        this.restriccionsHoraries.add(restriccioHoraria);
    }

    //Setters
    public void setAssignatura(Assignatura assignatura) {
        this.assignatura = assignatura;
    }

    public void addRestriccioHoraria(Pair<Integer, Integer> restriccio_horaria) {
        this.restriccionsHoraries.add(restriccio_horaria);
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

    public Pair<Integer, Integer> getRestriccio() {
        return restriccionsHoraries.get(0);
    }

}
