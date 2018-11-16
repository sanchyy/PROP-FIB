package Drivers;

import Domini.CaracteristiquesAula;
import Domini.CtrDomini;
import Domini.RestriccioCaracteristicaAula;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DriverRestriccioCaracteristicaAula {
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
            ArrayList<RestriccioCaracteristicaAula> lrca = ctrDomini.getRestriccions().getRca();
            int i = 1;
            for (RestriccioCaracteristicaAula rca : lrca) {
                System.out.println("["+(i++)+"]"+rca.getSessioCarac());
            }
        } else if (sel == 2) {

        } else if (sel == 3) {
            System.out.println("Sessions:");
            System.out.println(ctrDomini.llistaSessions());
            Integer sessio = llegirNumero()-1;
            System.out.println("Caracteristiques:");
            ArrayList<CaracteristiquesAula> caracteristiques = llegirCaracteristiques();
            ctrDomini.crearRestriccioCaracteristicaAula(sessio, caracteristiques);

        } else if (sel == 4) {
            System.out.println("Vols mostrar les Restriccions abans? (S/N)");
            String s = llegirString();
            if (s.equals("S") || s.equals("s")) {
                ArrayList<RestriccioCaracteristicaAula> lrca = ctrDomini.getRestriccions().getRca();
                int i = 1;
                for (RestriccioCaracteristicaAula rca : lrca) {
                    System.out.println("["+(i++)+"]"+rca.getSessioCarac());
                }
            }
            System.out.println("Quina Restricció vols borrar?");
            Integer b = llegirNumero();
            try {
                ctrDomini.getRestriccions().borraRca(b);}
            catch (Exception e) {System.out.println("No existeix aquesta Restriccio");}
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

    public static ArrayList<CaracteristiquesAula> llegirCaracteristiques() {
        ArrayList<CaracteristiquesAula> caracteristiques = new ArrayList<>();
        for (CaracteristiquesAula caracteristica : Arrays.asList(CaracteristiquesAula.values())) {
            System.out.println("Té la següent característica (S/N)? (" + caracteristica.toString() + ")");
            String resp = llegirString();
            if (resp.equals("S")) caracteristiques.add(caracteristica);
        }
        return caracteristiques;
    }

}
