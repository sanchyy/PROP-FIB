package Domini;

import java.util.ArrayList;

public class TaulaAules extends Taula<Aula> {

    public TaulaAules () {
        super();
    }

    public TaulaAules (ArrayList<Aula> aules) {
        super();
        Integer i = 0;
        for (ArrayList< ArrayList<Aula>> dia : super.getTaula()) {
            ArrayList< ArrayList<Aula>> nDia = new ArrayList<>();
            for (ArrayList<Aula> hora : dia) {
                nDia.add(clonarAulesDisponibles(aules));
            }
            super.posar(nDia, i++);
        }
    }

    public ArrayList<Aula> clonarAulesDisponibles(ArrayList<Aula> aulesDisponibles) {
        ArrayList<Aula> novaLlista = new ArrayList<>();
        for (Aula a : aulesDisponibles) {
            novaLlista.add(a);
        }
        return novaLlista;
    }

    public TaulaAules clonarTaula() {
        TaulaAules novaTaula = new TaulaAules();
        for (ArrayList< ArrayList<Aula>> dia : super.getTaula()) {
            ArrayList< ArrayList<Aula>> nDia = new ArrayList<>();
            for (ArrayList<Aula> hora : dia) {
                ArrayList<Aula> nHora = new ArrayList<>();
                for (Aula aula : hora) {
                    nHora.add(aula);
                }
                nDia.add(nHora);
            }
            novaTaula.afegir(nDia);
        }
        return novaTaula;
    }

    //Auxiliar Functions
    public String mostrarAtom(Aula a) {
        return a.getNom_aula();
    }

}
