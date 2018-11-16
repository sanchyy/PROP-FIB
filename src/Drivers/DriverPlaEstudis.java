package Drivers;

import Domini.CtrDomini;

import java.util.Scanner;

public class DriverPlaEstudis {

    public static Scanner scanner = new Scanner(System.in);
    public static CtrDomini ctrDomini = null;

    public static void runDriver(CtrDomini ctr, Scanner scnr) {
        ctrDomini = ctr;
        scanner = scnr;
        String[] str = new String[0];
        main(str);
    }

    public static void main(String[] args) {
        if (ctrDomini == null) new CtrDomini(2);
        System.out.println("---------------------------");
        System.out.println("Quina acció vols realitzar?");
        System.out.println("---------------------------");
        System.out.println(" [1] Mostrar Plans d'Estudi");
        System.out.println(" [2] Seleccionar Plans d'Estudi");
        System.out.println(" [3] Crear Pla d'Estudi");
        System.out.println(" [4] Borrar Pla d'Estudi");
        int sel = llegirNumero();
        if (sel == 1) {
            ctrDomini.llistaPlaEstudi();
        } else if (sel == 2) {
            System.out.println("Vols mostrar els Plans d'Estudi abans? (S/N)");
            String s = llegirString();
            if (s.equals("S") || s.equals("s")) ctrDomini.llistaPlaEstudi();
            System.out.println("Quin Pla d'estudis vols seleccionar?");
            Integer pe = llegirNumero();
            try {ctrDomini.setPlaEstudisSeleccionat(pe);}
            catch (Exception e) {System.out.println("No existeix aquest pla d'Estudis");}
        } else if (sel == 3) {
            System.out.println("Introdueix el nom del pla d'Estudis");
            String nom = llegirString();
            ctrDomini.afegirPlaEstudis(nom);
        } else if (sel == 4) {
            System.out.println("Vols mostrar els Plans d'Estudi abans? (S/N)");
            String s = llegirString();
            if (s.equals("S") || s.equals("s")) ctrDomini.llistaPlaEstudi();
            System.out.println("Quina Unitat Docent vols borrar?");
            Integer b = llegirNumero();
            ctrDomini.borrarPlaEstudis(b);
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
