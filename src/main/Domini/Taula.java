package Domini;

import java.util.ArrayList;

public abstract class Taula <A> {
    private ArrayList< ArrayList<ArrayList<A>> > taula = new ArrayList<>();
    public Integer files = 12;
    public Integer columnes = 5;

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

    public void afegirAtom(Integer dia, Integer hora, A atom) {
        this.taula.get(dia).get(hora).add(atom);
    }

    public ArrayList<A> clonarSlot(ArrayList<A> slot) {
        ArrayList<A> novaLlista = new ArrayList<>();
        for (A a : slot) {
            novaLlista.add(a);
        }
        return novaLlista;
    }

    public abstract String mostrarAtom(A tipus);

}
