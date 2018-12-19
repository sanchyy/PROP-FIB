package main.Domini;

import java.util.ArrayList;

public class Horari extends Taula<Sessio> {

    private boolean solucionat = false;

    public Horari () {
        ArrayList<Sessio> buit = new ArrayList<>();
        super.novaTaula(buit);
    }

    public boolean getSolucionat() {
        return solucionat;
    }

    public void setSolucionat(boolean solucionat) {
        this.solucionat = solucionat;
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
        if (solucionat) {
            String slot = "----------------------";
            System.out.println("+" + slot + "+" + slot + "+" + slot + "+" + slot + "+" + slot + "+" + slot + "+");
            System.out.println("|        HORA          |       DILLUNS        |       DIMARTS        |       DIMECRES       |        DIJOUS        |       DIVENDRES      |");
            for (int h=0; h<super.files; ++h) {
                System.out.println("+" + slot + "+" + slot + "+" + slot + "+" + slot + "+" + slot + "+" + slot + "+");
                Integer max = -1;
                for (int i=0; i<super.columnes; ++i) {
                    if (max == -1 || super.agafar(i, h).size() > max) max = super.agafar(i, h).size();
                }
                String h1 = (h+8) + "";
                String h2 = (h+9) + "";
                if (h < 2) h1 = "0" + h1;
                if (h < 1) h2 = "0" + h2;
                String hrs = "|    " + h1 + ":00 - " + h2 + ":00     ";
                if (max <= 0) {
                    String hores = hrs;
                    for (int d=0; d<super.columnes; ++d) {
                        hores += "|                      ";
                    }
                    System.out.println(hores + "|");
                    max = 0;
                }
                for (int i=0; i<max; ++i) {
                    String hores = "|                      ";
                    if (i == 0) hores = hrs;
                    for (int d=0; d<super.columnes; ++d) {
                        if (i < super.agafar(d, h).size()) {
                            int length = super.agafar(d, h).get(i).getAssignatura().getNom().length();
                            hores += "|    ";
                            for (int j=0; j<3-(length-1); ++j) hores += " ";
                            hores += mostrarAtom(super.agafar(d, h).get(i)) + "   ";
                        } else hores += "|                      ";
                    }
                    System.out.println(hores + "|");
                }
            }
            System.out.println("+" + slot + "+" + slot + "+" + slot + "+" + slot + "+" + slot + "+" + slot + "+");
        } else {
            System.out.println("No hi ha solució al teu horari");
        }
    }

    @Override
    public String mostrarAtom(Sessio sessio) {
        return sessio.mostrarSessio();
    }
}
