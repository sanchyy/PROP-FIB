package Domini;

import java.util.ArrayList;

// Berni
public class Sessio {
    // Grup
    // Subgrup
    // Assignatura
    // Tipus

    private Assignatura assignatura;
    private Aula aula;
    private ArrayList< Pair<Integer, Integer> > restriccions_horaries = new ArrayList<>();

    //Constructora
    public Sessio() {
        this.assignatura = null;
    }

    //Setters
    public void setAssignatura(Assignatura assignatura) {
        this.assignatura = assignatura;
    }

    public void setRestriccions_horaries(ArrayList< Pair<Integer, Integer> > restriccions_horaries) {
        this.restriccions_horaries = restriccions_horaries;
    }

    public void addRestriccio_horaria(Pair<Integer, Integer> restriccio_horaria) {
        this.restriccions_horaries.add(restriccio_horaria);
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    //Getters
    public Assignatura getAssignatura() {
        return assignatura;
    }

    public ArrayList< Pair<Integer, Integer> > getRestriccions_horaries() {
        return restriccions_horaries;
    }

    public Aula getAula() {
        return aula;
    }

    public Pair<Integer, Integer> getRestriccio() {
        return restriccions_horaries.get(0);
    }

}
