package Drivers;

import Domini.CtrDomini;

import java.util.Scanner;

public class DriverPlaEstudis {
    public static Scanner scanner;

    public static void main(CtrDomini ctrDomini, Scanner scnr) {
        scanner = scnr;
        System.out.println("---------------------------");
        System.out.println("Quina acció vols realitzar?");
        System.out.println("---------------------------");
        System.out.println(" [1] Mostrar Plans d'Estudi");
        System.out.println(" [2] Seleccionar Plans d'estudi");
        System.out.println(" [3] Crear Pla d'estudi");
        System.out.println(" [4] Borrar Pla d'estudi");
        int sel = llegirNumero();
        if (sel == 1) {
            ctrDomini.llistaPlaEstudi();
        } else if (sel == 2) {
            System.out.println("Vols mostrar els Plans d'estudi abans? (S/N)");
            String s = llegirString();
            if (s.equals("S") || s.equals("s")) ctrDomini.llistaPlaEstudi();
            System.out.println("Quin Pla d'estudis vols seleccionar?");
            Integer pe = llegirNumero();
            try {ctrDomini.setPlaEstudisSeleccionat(pe);}
            catch (Exception e) {System.out.println("No existeix aquest pla d'estudis");}
        } else if (sel == 3) {
            System.out.println("Introdueix el nom del pla d'estudis");
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
    }

    public static String llegirString() {
        return scanner.next();
    }

    public static Integer llegirNumero() {
        return scanner.nextInt();
    }

}
