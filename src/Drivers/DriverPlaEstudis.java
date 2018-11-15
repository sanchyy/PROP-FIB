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
        Integer sel = llegirNumero();
        if (sel == 1) {
            ctrDomini.;
        } else if (sel == 2) {
            System.out.println("Vols mostrar les Unitats Docents abans? (S/N)");
            String s = llegirString();
            if (s.equals("S")) ctrDomini.llistaUnitatsDocents();
            System.out.println("Quina Unitat Docent vols seleccionar?");
            Integer ud = llegirNumero();
            if (ud < ctrDomini.midaUnitatsDocents()) ctrDomini.setUnitatDocentSeleccionada(ud);
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
    }

    public static String llegirString() {
        return scanner.next();
    }

    public static Integer llegirNumero() {
        return scanner.nextInt();
    }

}
