package Drivers;

import Domini.CtrDomini;
import Domini.UnitatDocent;

import java.util.Scanner;

public class DriverRestriccio {

    public static Scanner scanner;

    public static void main(CtrDomini ctrDomini, Scanner scnr) {
        scanner = scnr;
        System.out.println("---------------------------");
        System.out.println("Quina acció vols realitzar?");
        System.out.println("---------------------------");
        System.out.println("[1] Restriccio Solapar");
        System.out.println("[2] Restriccio Matins");
        System.out.println("[3] Restriccio Tardes");
        System.out.println("[4] Restriccio Característica Aula");
        System.out.println("[5] Restriccio Nivell");
        System.out.println("[6] Restriccio Correquisit");
        int sel = llegirNumero();
        if (sel == 1) {
            DriverRestriccioSolapar.main(ctrDomini, scnr);
        } else if (sel == 2) {
            DriverRestriccioMatins.main(ctrDomini, scnr);
        } else if (sel == 3) {
            DriverRestriccioTardes.main(ctrDomini, scnr);
        } else if (sel == 4) {
            DriverRestriccioCaracteristicaAula.main(ctrDomini, scnr);
        } else if (sel == 5){
            DriverRestriccioNivell.main(ctrDomini, scnr);
        } else if (sel == 6) {
            DriverRestriccioCorrequisit.main(ctrDomini, scnr);
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
