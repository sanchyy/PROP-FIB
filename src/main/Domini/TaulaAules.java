package main.Domini;

import java.util.ArrayList;

public class TaulaAules extends Taula<Aula> {

    public TaulaAules () {
        ArrayList<Aula> buit = new ArrayList<>();
        super.novaTaula(buit);
    }

    public TaulaAules (ArrayList<Aula> aules) {
        super.novaTaula(aules);
    }

    public TaulaAules clonarTaulaAules() {
        TaulaAules novaTaula = new TaulaAules();
        for (int i=0; i<super.columnes; ++i) {
            ArrayList< ArrayList<Aula> > dia = new ArrayList<>();
            for (int j=0; j<super.files; ++j) {
                dia.add(super.clonarSlot(super.agafar(i, j)));
            }
            novaTaula.posar(dia, i);
        }
        return novaTaula;
    }

    @Override
    public String mostrarAtom(Aula aula) {
        return aula.getNom();
    }

}
