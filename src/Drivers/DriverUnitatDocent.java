package Drivers;

import Domini.CtrDomini;

import java.util.Scanner;

public class DriverUnitatDocent {

    public static Scanner scanner = new Scanner(System.in);
    public static CtrDomini ctrDomini = new CtrDomini(1);

    public static void runDriver(CtrDomini ctr, Scanner scnr) {
        ctrDomini = ctr;
        scanner = scnr;
        String[] str = new String[0];
        main(str);
    }

    public static void main(String[] args) {
        System.out.println("---------------------------");
        System.out.println("Quina acció vols realitzar?");
        System.out.println("---------------------------");
        System.out.println(" [1] Mostrar Unitats Docents");
        System.out.println(" [2] Seleccionar Unitats Docents");
        System.out.println(" [3] Crear Unitat Docent");
        System.out.println(" [4] Borrar Unitat Docent");
        Integer sel = llegirNumero();
        if (sel == 1) {
            ctrDomini.llistaUnitatsDocents();
        } else if (sel == 2) {
            System.out.println("Vols mostrar les Unitats Docents abans? (S/N)");
            String s = llegirString();
            if (s.equals("S")) ctrDomini.llistaUnitatsDocents();
            System.out.println("Quina Unitat Docent vols seleccionar?");
            Integer ud = llegirNumero();
            if (ud < ctrDomini.midaUnitatsDocents()) ctrDomini.setUnitatDocentSeleccionada(ud-1);
            else System.out.println("No hi ha cap Unitat Docent amb aquesta selecció");
        } else if (sel == 3) {
            System.out.println("Introdueix un nom per la nova Unitat Docent:");
            String nom = llegirString();
            ctrDomini.afegirUnitatDocent(nom);
        } else if (sel == 4) {
            System.out.println("Vols mostrar les Unitats Docents abans? (S/N)");
            String s = llegirString();
            if (s.equals("S")) ctrDomini.llistaUnitatsDocents();
            System.out.println("Quina Unitat Docent vols borrar?");
            Integer b = llegirNumero();
            ctrDomini.borrarUnitatDocent(b);
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
