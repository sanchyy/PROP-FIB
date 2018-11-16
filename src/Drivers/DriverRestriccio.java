package Drivers;

import Domini.CtrDomini;
import Domini.UnitatDocent;

import java.util.Scanner;

public class DriverRestriccio {

    public static Scanner scanner = new Scanner(System.in);
    public static CtrDomini ctrDomini = new CtrDomini(1);

    public static void runDriver(CtrDomini ctr, Scanner scnr) {
        ctrDomini = ctr;
        scanner = scnr;
        String[] str = new String[0];
        main(str);
    }

    public static void main(String[] args) {
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
            DriverRestriccioSolapar.main(ctrDomini, scanner);
        } else if (sel == 2) {
            DriverRestriccioMatins.main(ctrDomini, scanner);
        } else if (sel == 3) {
            DriverRestriccioTardes.main(ctrDomini, scanner);
        } else if (sel == 4) {
            DriverRestriccioCaracteristicaAula.main(ctrDomini, scanner);
        } else if (sel == 5){
            DriverRestriccioNivell.main(ctrDomini, scanner);
        } else if (sel == 6) {
            DriverRestriccioCorrequisit.main(ctrDomini, scanner);
        } else {
            System.out.println("No hi ha cap acció disponible");
        }
        System.out.println("Vols realitzar una altre acció? (S/N)");
        String sn = llegirString();
        if (sn.equalsIgnoreCase("s")) main(new String[0]);
    }

    public static String llegirString() {
        return scanner.next();
    }

    public static Integer llegirNumero() {
        return scanner.nextInt();
    }

}
