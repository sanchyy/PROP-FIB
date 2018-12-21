package Drivers;

import main.Domini.CtrDomini;
import main.Domini.RestriccioSolapar;

import java.util.ArrayList;
import java.util.Scanner;

public class DriverRestriccioSolapar {
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
            ArrayList<RestriccioSolapar> lrs = ctrDomini.getRestriccions().getRs();
            int i = 1;
            for (RestriccioSolapar rs : lrs) {
                System.out.println("["+(i++)+"]"+rs.escriuParellSessio());
            }
        } else if (sel == 2) {

        } else if (sel == 3) {
            System.out.println("Llistat Sessions:");
            System.out.println(ctrDomini.llistaSessions());
            System.out.println("Introdueix les dos sessions que no vols que es solapin:");
            ctrDomini.crearRestriccioSolapar(llegirNumero()-1, llegirNumero()-1);

        } else if (sel == 4) {
            System.out.println("Vols mostrar les Restriccions abans? (S/N)");
            String s = llegirString();
            if (s.equals("S") || s.equals("s")) {
                ArrayList<RestriccioSolapar> lrs = ctrDomini.getRestriccions().getRs();
                int i = 1;
                for (RestriccioSolapar rs : lrs) {
                    System.out.println("["+(i++)+"]"+rs.escriuParellSessio());
                }
            }
            System.out.println("Quina Restricció vols borrar?");
            Integer b = llegirNumero();
            try {
                ctrDomini.getRestriccions().borraRs(b);}
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
