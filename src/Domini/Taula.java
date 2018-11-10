package Domini;

import java.util.ArrayList;

// Berni
public abstract class Taula <A> {
    private ArrayList< ArrayList<ArrayList<A>> > taula = new ArrayList<>();
    private Integer files = 12;
    private Integer columnes = 5;

    public Taula () {
        for (int i=0; i<columnes; ++i) {
            ArrayList< ArrayList<A> > dia = new ArrayList<>();
            for (int j=0; j<files; ++j) {
                ArrayList<A> slot = new ArrayList<>();
                dia.add(slot);
            }
            this.taula.add(dia);
        }
    }

    public Taula (ArrayList<A> slot) {
        for (int i=0; i<columnes; ++i) {
            ArrayList< ArrayList<A> > dia = new ArrayList<>();
            for (int j=0; j<files; ++j) {
                dia.add(clonarSlot(slot));
            }
            this.taula.add(dia);
        }
    }

    public void novaTaula (ArrayList<A> slot) {
        for (int i=0; i<columnes; ++i) {
            ArrayList< ArrayList<A> > dia = new ArrayList<>();
            for (int j=0; j<files; ++j) {
                dia.add(clonarSlot(slot));
            }
            this.taula.set(i, dia);
        }
    }

    public ArrayList<A> getAtoms(Integer dia, Integer hora) {
        return this.taula.get(dia).get(hora);
    }

    public void borrar(A a, Integer dia, Integer hora) {
        this.taula.get(dia).get(hora).remove(a);
    }

    public ArrayList<A> agafar (Integer dia, Integer hora) {
        return this.taula.get(dia).get(hora);
    }

    public void posar(ArrayList<ArrayList<A>> atomDia, Integer dia) {
        this.taula.set(dia, atomDia);
    }

    public ArrayList< ArrayList<ArrayList<A>> > getTaula() {
        return this.taula;
    }

    public void mostrarTaula() {
        System.out.println("----------------------------");
        System.out.println("---------- TAULA  ----------");
        System.out.println("----------------------------");
        Integer dayI = 0;
        for (ArrayList< ArrayList<A>> dia : this.taula) {
            System.out.println(dayI++);
            for (ArrayList<A> hora : dia) {
                for (A tipus : hora) {
                    System.out.println("    " + mostrarAtom(tipus));
                }
            }
        }
    }

    public abstract String mostrarAtom(A tipus);
    public abstract ArrayList<A> clonarSlot(ArrayList<A> slot);

}
