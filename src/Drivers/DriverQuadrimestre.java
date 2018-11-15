package Drivers;

import Domini.CtrDomini;
import Domini.PlaEstudis;

import java.util.Scanner;

public class DriverQuadrimestre {

    public static Scanner scanner;

    public static void main(CtrDomini ctrDomini, Scanner scnr) {
        scanner = scnr;
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
            if (s.equals("S") || s.equals("s")) ctrDomini.llistaQuadrimestres();
            System.out.println("Quin Quadrimestre vols seleccionar?");
            String ass = llegirString();
            try { ctrDomini.getQuadrimestre();}
            catch (Exception e) {System.out.println("No hi ha cap Assignatura amb aquesta selecció");}
        } else if (sel == 3) {
            System.out.println("Creant el quatrimestre");
            ctrDomini.afegirQuadrimestre();
        } else if (sel == 4) {
            System.out.println("Vols mostrar els Quadrimestres abans? (S/N)");
            String s = llegirString();
            if (s.equals("S") || s.equals("s")) ctrDomini.llistaAssignatures();
            System.out.println("Quin Quadrimestre vols borrar?");
            Integer b = llegirNumero();
            try {
                PlaEstudis pe = ctrDomini.getPlaEstudis(); pe.borrarQuadimestre(b);}
            catch (Exception e) {System.out.println("No existeix aquesta assignatura");}
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
