package Drivers;

import main.Domini.CtrDomini;
import main.Domini.RestriccioNivell;

import java.util.ArrayList;
import java.util.Scanner;

public class DriverRestriccioNivell {
    public static Scanner scanner;

    public static void main(CtrDomini ctrDomini, Scanner scnr) {
        scanner = scnr;
        System.out.println("---------------------------");
        System.out.println("Quina acció vols realitzar?");
        System.out.println("---------------------------");
        System.out.println(" [1] Mostrar Restriccio");
        System.out.println(" [2] Seleccionar Restriccio");
        System.out.println(" [3] Crear Restriccio");
        System.out.println(" [4] Borrar Restriccio");
        int sel = llegirNumero();
        if (sel == 1) {
            ArrayList<RestriccioNivell> lrn = ctrDomini.getRestriccions().getRn();
            int i = 1;
            for (RestriccioNivell rn : lrn) {
                System.out.println("["+(i++)+"]"+rn.escriuParellSessio());
            }
        } else if (sel == 2) {

        } else if (sel == 3) {
            System.out.println("Llistat Sessions:");
            System.out.println(ctrDomini.llistaSessions());
            System.out.println("Introdueix la sessio que");
            ctrDomini.crearRestriccioNivell(llegirNumero()-1, llegirNumero()-1);

        } else if (sel == 4) {
            System.out.println("Vols mostrar les Restriccions abans? (S/N)");
            String s = llegirString();
            if (s.equals("S") || s.equals("s")) {
                ArrayList<RestriccioNivell> lrn = ctrDomini.getRestriccions().getRn();
                int i = 1;
                for (RestriccioNivell rn : lrn) {
                    System.out.println("["+(i++)+"]"+rn.escriuParellSessio());
                }
            }
            System.out.println("Quina Restricció vols borrar?");
            Integer b = llegirNumero();
            try {
                ctrDomini.getRestriccions().borraRn(b);}
            catch (Exception e) {System.out.println("No existeix aquesta Restricció");}
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
