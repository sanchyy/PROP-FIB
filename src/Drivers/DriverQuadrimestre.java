package Drivers;

import Domini.CtrDomini;
import Domini.PlaEstudis;

import java.util.Scanner;

public class DriverQuadrimestre {

    public static Scanner scanner = new Scanner(System.in);
    public static CtrDomini ctrDomini = null;

    public static void runDriver(CtrDomini ctr, Scanner scnr) {
        ctrDomini = ctr;
        scanner = scnr;
        String[] str = new String[0];
        main(str);
    }

    public static void main(String[] args) {
        if (ctrDomini == null) new CtrDomini(3);
        System.out.println("---------------------------");
        System.out.println("Quina acció vols realitzar?");
        System.out.println("---------------------------");
        System.out.println(" [1] Mostrar Quadrimestre");
        System.out.println(" [2] Seleccionar Quadrimestre");
        System.out.println(" [3] Crear Quadrimestre");
        System.out.println(" [4] Borrar Quadrimestre");
        int sel = llegirNumero();
        if (sel == 1) {
            ctrDomini.llistaQuadrimestres();
        } else if (sel == 2) {
            System.out.println("Vols mostrar els Quadrimestres (S/N)");
            String s = llegirString();
            if (s.equalsIgnoreCase("s")) ctrDomini.llistaQuadrimestres();
            System.out.println("Quin Quadrimestre vols seleccionar?");
            Integer ass = llegirNumero();
            try { ctrDomini.setQuadrimestreSeleccionat(ass-1);}
            catch (Exception e) {System.out.println("No hi ha cap Assignatura amb aquesta selecció");}
        } else if (sel == 3) {
            System.out.println("Creant el quatrimestre");
            ctrDomini.afegirQuadrimestre();
        } else if (sel == 4) {
            System.out.println("Vols mostrar els Quadrimestres abans? (S/N)");
            String s = llegirString();
            if (s.equalsIgnoreCase("s")) ctrDomini.llistaQuadrimestres();
            System.out.println("Quin Quadrimestre vols borrar?");
            Integer b = llegirNumero();
            try {
                PlaEstudis pe = ctrDomini.getPlaEstudis(); pe.borrarQuadimestre(b);}
            catch (Exception e) {System.out.println("No existeix aquesta assignatura");}
        } else {
            System.out.println("No hi ha cap acció disponible");
        }
        System.out.println("Vols realitzar una altre acció? (S/N)");
        String sn = llegirString();
        if (sn.equalsIgnoreCase("s")) main(new String[0]);
    }

    public static String llegirString() {
        return scanner.next();
    }

    public static Integer llegirNumero() {
        return scanner.nextInt();
    }
    

}
