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
        Integer dayI = 0;
        for (ArrayList< ArrayList<Sessio>> dia : horari) {
            System.out.println(intAdia(dayI++));
            for (ArrayList<Sessio> hora : dia) {
                for (Sessio sessio : hora) {
                    System.out.println("    " + (dia.indexOf(hora)+8) + ":00 -> " + sessio.getAssignatura().getNomAssig() + " (" + sessio.getAula().getNom_aula() + ")");
                }
            }
        }
    }

    public String intAdia(Integer d) {
        String dia;
        switch (d) {
            case 0:
                dia = "Dilluns";
            break;
            case 1:
                dia = "Dimarts";
            break;
            case 2:
                dia = "Dimecres";
            break;
            case 3:
                dia = "Dijous";
            break;
            case 4:
                dia = "Divendres";
            break;
            default:
                dia = "";
            break;
        }
        return dia;
    }

}
