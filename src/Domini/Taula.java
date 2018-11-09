package Domini;

import java.util.ArrayList;

// Berni
public abstract class Taula <A> {
    private ArrayList< ArrayList<ArrayList<A>> > taula;
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

    public ArrayList< ArrayList<ArrayList<A>> > getTaula() {
        return this.taula;
    }

    public void mostrarTaula() {
        System.out.println("----------------------------");
        System.out.println("---------- AULES  ----------");
        System.out.println("----------------------------");
        Integer dayI = 0;
        for (ArrayList< ArrayList<A>> dia : taula) {
            System.out.println(dayI++);
            for (ArrayList<A> hora : dia) {
                for (A tipus : hora) {
                    System.out.println("    " + mostrarAtom(tipus));
                }
            }
        }
    }

    public abstract String mostrarAtom(A tipus);

}
