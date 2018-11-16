package Drivers;

import Domini.CtrDomini;
import Domini.RestriccioMatins;

import java.util.ArrayList;
import java.util.Scanner;

public class DriverRestriccioMatins {
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
            ArrayList<RestriccioMatins> lrm = ctrDomini.getRestriccions().getRm();
            int i = 1;
            for (RestriccioMatins rm : lrm) {
                System.out.println("["+(i++)+"]"+rm.getSessio());
            }
        } else if (sel == 2) {

        } else if (sel == 3) {
            System.out.println("Llistat Sessions:");
            System.out.println(ctrDomini.llistaSessions());
            System.out.println("Introdueix la sessio que vols que vagi a matin");
            ctrDomini.crearRestriccioMatins(llegirNumero()-1);

        } else if (sel == 4) {
            System.out.println("Vols mostrar les Restriccions abans? (S/N)");
            String s = llegirString();
            if (s.equals("S") || s.equals("s")) {
                ArrayList<RestriccioMatins> lrm = ctrDomini.getRestriccions().getRm();
                int i = 1;
                for (RestriccioMatins rm : lrm) {
                    System.out.println("["+(i++)+"]"+rm.getSessio());
                }
            }
            System.out.println("Quina Restricció vols borrar?");
            Integer b = llegirNumero();
            try {
                ctrDomini.getRestriccions().borraRm(b-1);}
            catch (Exception e) {System.out.println("No existeix aquesta aula");}
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
