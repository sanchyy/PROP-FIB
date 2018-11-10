package Domini;

import java.util.ArrayList;

public class TaulaAules extends Taula<Aula> {

    public TaulaAules () {
        ArrayList<Aula> buit = new ArrayList<>();
        super.novaTaula(buit);
    }

    public TaulaAules (ArrayList<Aula> aules) {
        super.novaTaula(aules);
    }

    public ArrayList<Aula> clonarAulesDisponibles(ArrayList<Aula> aulesDisponibles) {
        ArrayList<Aula> novaLlista = new ArrayList<>();
        for (Aula a : aulesDisponibles) {
            novaLlista.add(a);
        }
        return novaLlista;
    }

    public TaulaAules clonarTaulaAules() {
        TaulaAules novaTaula = new TaulaAules();
        for (int i=0; i<5; ++i) {
            ArrayList< ArrayList<Aula> > dia = new ArrayList<>();
            for (int j=0; j<12; ++j) {
                dia.add(clonarAulesDisponibles(super.agafar(i, j)));
            }
            novaTaula.posar(dia, i);
        }
        return novaTaula;
    }

    @Override
    public String mostrarAtom(Aula aula) {
        return aula.getNom_aula();
    }

    @Override
    public ArrayList<Aula> clonarSlot(ArrayList<Aula> slot) {
        return clonarAulesDisponibles(slot);
    }
}
