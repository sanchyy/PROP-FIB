package Drivers;

import Domini.CtrDomini;
import Domini.RestriccioTardes;

import java.util.ArrayList;
import java.util.Scanner;

public class DriverRestriccioTardes {
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
            ArrayList<RestriccioTardes> lrt = ctrDomini.getRestriccions().getRt();
            int i = 1;
            for (RestriccioTardes rt : lrt) {
                System.out.println("["+(i++)+"]"+rt.getSessio());
            }
        } else if (sel == 2) {

        } else if (sel == 3) {
            System.out.println("Llistat Sessions:");
            System.out.println(ctrDomini.llistaSessions());
            System.out.println("Introdueix la sessio que vols que vagi a matin");
            ctrDomini.crearRestriccioTardes(llegirNumero()-1);

        } else if (sel == 4) {
            System.out.println("Vols mostrar les Restriccions abans? (S/N)");
            String s = llegirString();
            if (s.equals("S") || s.equals("s")) {
                ArrayList<RestriccioTardes> lrt = ctrDomini.getRestriccions().getRt();
                int i = 1;
                for (RestriccioTardes rt : lrt) {
                    System.out.println("["+(i++)+"]"+rt.getSessio());
                }
            }
            System.out.println("Quina Restricció vols borrar?");
            Integer b = llegirNumero();
            try {
                ctrDomini.getRestriccions().borraRt(b-1);}
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
