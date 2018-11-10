package Domini;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TaulaAules {

    private ArrayList< ArrayList< ArrayList <Aula> > > taula = new ArrayList<>();

    public TaulaAules () {
        for (int i=0; i<5; ++i) {
            ArrayList< ArrayList<Aula> > dia = new ArrayList<>();
            for (int j=0; j<12; ++j) {
                ArrayList<Aula> aules = new ArrayList<>();
                dia.add(aules);
            }
            taula.add(dia);
        }
    }

    public TaulaAules (ArrayList<Aula> aules) {
        for (int i=0; i<5; ++i) {
            ArrayList< ArrayList<Aula> > dia = new ArrayList<>();
            for (int j=0; j<12; ++j) {
                dia.add(clonarAulesDisponibles(aules));
            }
            taula.add(dia);
        }
    }

    public ArrayList<Aula> clonarAulesDisponibles(ArrayList<Aula> aulesDisponibles) {
        ArrayList<Aula> novaLlista = new ArrayList<>();
        for (Aula a : aulesDisponibles) {
            novaLlista.add(a);
        }
        return novaLlista;
    }

    public void afegir (ArrayList< ArrayList <Aula> > dia) {
        this.taula.add(dia);
    }

    public void posar (Integer i, ArrayList< ArrayList <Aula> > dia) {
        this.taula.set(i, dia);
    }

    public ArrayList<Aula> agafarAules (Integer dia, Integer hora) {
        return this.taula.get(dia).get(hora);
    }

    public TaulaAules clonarTaulaAules() {
        TaulaAules novaTaula = new TaulaAules();
        for (int i=0; i<5; ++i) {
            ArrayList< ArrayList<Aula> > dia = new ArrayList<>();
            for (int j=0; j<12; ++j) {
                dia.add(clonarAulesDisponibles(taula.get(i).get(j)));
            }
            novaTaula.posar(i, dia);
        }

        /*TaulaAules novaTaula = new TaulaAules();
        for (ArrayList< ArrayList<Aula>> dia : taula) {
            ArrayList< ArrayList<Aula>> nDia = new ArrayList<>();
            for (ArrayList<Aula> hora : dia) {
                ArrayList<Aula> nHora = new ArrayList<>();
                for (Aula aula : hora) {
                    nHora.add(aula);
                }
                nDia.add(nHora);
            }
            novaTaula.afegir(nDia);
        }*/
        return novaTaula;
    }

    public void borrarAula(Aula a, Integer dia, Integer hora) {
        this.taula.get(dia).get(hora).remove(a);
    }

    public void mostrarTaulaAules() {
        System.out.println("----------------------------");
        System.out.println("---------- AULES  ----------");
        System.out.println("----------------------------");
        Integer dayI = 0;
        for (ArrayList< ArrayList<Aula>> dia : taula) {
            System.out.println(dayI++);
            for (ArrayList<Aula> hora : dia) {
                System.out.println("Size: " + hora.size());
                for (Aula aula : hora) {
                    System.out.println("    " + aula.getNom_aula());
                }
            }
        }
    }


}
