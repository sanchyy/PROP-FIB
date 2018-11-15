package Drivers;

import Domini.CtrDomini;
import Domini.UnitatDocent;

import java.util.Scanner;

public class DriverPlaEstudis {

    public static Scanner scanner;

    public static void main(CtrDomini ctrDomini, Scanner scnr) {
        scanner = scnr;
        System.out.println("---------------------------");
        System.out.println("Quina acció vols realitzar?");
        System.out.println("---------------------------");
        System.out.println(" [1] Mostrar Plans d'estudis");
        System.out.println(" [2] Seleccionar Pla d'estudis");
        System.out.println(" [3] Crear Pla d'estudis");
        System.out.println(" [4] Borrar Pla d'estudis");
        Integer sel = llegirNumero();
        if (sel == 1) {
            ctrDomini.getPlaEstudis();
        } else if (sel == 2) {
            System.out.println("Vols mostrar els plans d'estudis abans? (S/N)");
            String s = llegirString();
            if (s.equals("S") || s.equals("s")) ctrDomini.getPlaEstudis();
            System.out.println("Quina Unitat Docent vols seleccionar?");
            Integer pe = llegirNumero();
            try {ctrDomini.setPlaEstudisSeleccionat(pe);}
            catch (Exception e) {System.out.println("No hi ha cap pla d'estudis amb aquesta selecció");}
        } else if (sel == 3) {
            System.out.println("Introdueix un nom pel nou pla d'estudis:");
            String nom = llegirString();
            ctrDomini.afegirPlaEstudis(nom);
        } else if (sel == 4) {
            System.out.println("Vols mostrar els plans d'estudi abans? (S/N)");
            String s = llegirString();
            if (s.equals("S") || s.equals("s")) ctrDomini.getPlaEstudis();
            System.out.println("Quina Unitat Docent vols borrar?");
            Integer b = llegirNumero();
            try {

                }
            catch (Exception e) {}

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
