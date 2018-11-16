package Drivers;

import Domini.CaracteristiquesAula;
import Domini.CtrDomini;
import Domini.PlaEstudis;
import Domini.UnitatDocent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DriverAula {

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
        System.out.println(" [1] Mostrar Aula");
        System.out.println(" [2] Seleccionar Aula");
        System.out.println(" [3] Crear Aula");
        System.out.println(" [4] Borrar Aula");
        int sel = llegirNumero();
        if (sel == 1) {
            ctrDomini.llistaAssignatures();
        } else if (sel == 2) {
            System.out.println("Vols mostrar les Aules (S/N)");
            String s = llegirString();
            if (s.equals("S") || s.equals("s")) ctrDomini.llistaAules();
            System.out.println("Quina Aula vols seleccionar?");
            Integer b = llegirNumero();
            try { ctrDomini.getAssignatura(b);}
            catch (Exception e) {System.out.println("No hi ha cap Aula amb aquesta selecció");}
        } else if (sel == 3) {
            System.out.println("Introdueix el nom de l'aula");
            String nom = llegirString();
            System.out.println("Introdueix la capacitat de l'aula");
            Integer capacitat = llegirNumero();
            ArrayList<CaracteristiquesAula> caracteristiques = llegirCaracteristiques();
            ctrDomini.afegirAulaUnitatDocent(nom, capacitat, caracteristiques);
        } else if (sel == 4) {
            System.out.println("Vols mostrar les Aules abans? (S/N)");
            String s = llegirString();
            if (s.equals("S") || s.equals("s")) ctrDomini.llistaAssignatures();
            System.out.println("Quina Aula vols borrar?");
            Integer b = llegirNumero();
            try {
                UnitatDocent ud = ctrDomini.getUnitatDocent(); ud.borrarAula(b);}
            catch (Exception e) {System.out.println("No existeix aquesta aula");}
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
