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

    //Setters
    public void setAssignatura(Assignatura assignatura) {
        this.assignatura = assignatura;
    }

    public void setRestriccions_horaries(ArrayList< Pair<Integer, Integer> > restriccions_horaries) {
        this.restriccionsHoraries = restriccions_horaries;
    }

    public void addRestriccio_horaria(Pair<Integer, Integer> restriccio_horaria) {
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

    public ArrayList< Pair<Integer, Integer> > getRestriccions_horaries() {
        return restriccionsHoraries;
    }

    public Aula getAula() {
        return aula;
    }

    public Pair<Integer, Integer> getRestriccio() {
        return restriccionsHoraries.get(0);
    }

}
