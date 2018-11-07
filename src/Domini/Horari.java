package Domini;

import java.util.ArrayList;

public class Horari {
    // private ArrayList<ArrayList<ArrayList<Pair<String, String> > > > slot_horari; // Pair string nom aula, string abrev assig
    private ArrayList< ArrayList< ArrayList <Sessio> > > horari = new ArrayList<>(); // Dies -> Hores -> Sessions

    // constructora
    public Horari (ArrayList< ArrayList< ArrayList <Sessio> > > horari) {
        this.horari = horari;
    }

    public Horari () {
        for (int i=0; i<5; ++i) {
            ArrayList< ArrayList<Sessio> > dia = new ArrayList<>();
            for (int j=0; j<12; ++j) {
                ArrayList<Sessio> sessions = new ArrayList<>();
                dia.add(sessions);
            }
            this.horari.add(dia);
        }
    }

    // Setter
    public void setSlot_horari(ArrayList< ArrayList< ArrayList <Sessio> > > horari) {
        this.horari = horari;
    }

    public void setHorari(ArrayList<ArrayList<ArrayList<Sessio>>> horari) {
        this.horari = horari;
    }

    public void setSessio(Sessio sessio, Integer dia, Integer hora) {
        this.horari.get(dia).get(hora).add(sessio);
    }

    // Getter
    public ArrayList< ArrayList< ArrayList <Sessio> > > getHorari () {
        return this.horari;
    }

    public Horari clonar() {
        Horari nHorari = new Horari();
        ArrayList< ArrayList< ArrayList <Sessio> > > nouHorari = new ArrayList<>();
        for (ArrayList< ArrayList<Sessio>> dia : horari) {
            ArrayList< ArrayList<Sessio>> nDia = new ArrayList<>();
            for (ArrayList<Sessio> hora : dia) {
                ArrayList<Sessio> nHora = new ArrayList<>();
                for (Sessio sessio : hora) {
                    nHora.add(sessio);
                }
                nDia.add(nHora);
            }
            nouHorari.add(nDia);
        }
        nHorari.horari = nouHorari;
        return nHorari;
    }

    public void mostrar() {
        System.out.println("----------------------------");
        System.out.println("---------- HORARI ----------");
        System.out.println("----------------------------");
        System.out.println("Dies: " + horari.size());
        for (ArrayList< ArrayList<Sessio>> dia : horari) {
            System.out.println("    Hores: " + dia.size());
            for (ArrayList<Sessio> hora : dia) {
                // System.out.println("        Sessions: " + hora.size());
                for (Sessio sessio : hora) {
                    System.out.println("            " + sessio.getAssignatura().getNomAssig() + ", Aula " + sessio.getAula().getNom_aula() + ", Dia " + horari.indexOf(dia) + ", Hora " + dia.indexOf(hora));
                }
            }
        }
    }

}
