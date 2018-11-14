package Domini;

import java.util.ArrayList;

public class Horari extends Taula<Sessio> {

    public Horari () {
        ArrayList<Sessio> buit = new ArrayList<>();
        super.novaTaula(buit);
    }

    public void setSessio(Sessio sessio, Integer dia, Integer hora) {
        super.afegirAtom(dia, hora, sessio);
    }

    public Horari clonarHorari() {
        Horari nouHorari = new Horari();
        for (int i=0; i<super.columnes; ++i) {
            ArrayList< ArrayList<Sessio> > dia = new ArrayList<>();
            for (int j=0; j<super.files; ++j) {
                dia.add(super.clonarSlot(super.agafar(i, j)));
            }
            nouHorari.posar(dia, i);
        }
        return nouHorari;
    }

    public void mostrarHorari() {
        String slot = "-------------";
        for (int h=0; h<super.files; ++h) {
            System.out.println("+" + slot + "+" + slot + "+" + slot + "+" + slot + "+" + slot + "+");
            String hores = "";
            Integer max = -1;
            for (int i=0; i<super.columnes; ++i) {
                if (max == -1 || super.agafar(i, h).size() > max) max = super.agafar(i, h).size();
            }
            if (max == -1) max = 0;
            for (int i=0; i<max; ++i) {
                for (int d=0; d<super.columnes; ++d) {
                    if (max < super.agafar(d, h).size()) hores += "+ " + super.agafar(d, h).get(max) + " ";
                    else hores += "+             ";
                }
            }
            System.out.println(hores);
        }

        Integer dayI = 0;
        for (ArrayList< ArrayList<Sessio>> dia : super.getTaula()) {
            System.out.println(intAdia(dayI++));
            for (ArrayList<Sessio> hora : dia) {
                for (Sessio sessio : hora) {
                    System.out.println("    " + (dia.indexOf(hora)+8) + ":00 -> " + sessio.getAssignatura().getNomAssig() + "-" + sessio.getGrup() + " (" + sessio.getAula().getNom() + ")");
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

    @Override
    public String mostrarAtom(Sessio sessio) {
        return sessio.getAssignatura().getNomAssig() + " (" + sessio.getAula().getNom() + ")";
    }
}
