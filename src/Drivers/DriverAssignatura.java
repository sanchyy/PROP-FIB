package Drivers;

import Domini.CaracteristiquesAula;
import Domini.CtrDomini;
import Domini.PlaEstudis;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DriverAssignatura {

    public static Scanner scanner = new Scanner(System.in);
    public static CtrDomini ctrDomini = new CtrDomini(4);

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
        System.out.println(" [1] Mostrar Assignatures");
        System.out.println(" [2] Seleccionar Assignatura");
        System.out.println(" [3] Crear Assignatura");
        System.out.println(" [4] Borrar Assignatura");
        int sel = llegirNumero();
        if (sel == 1) {
            ctrDomini.llistaAssignatures();
        } else if (sel == 2) {
            System.out.println("Vols mostrar les Assignatures (S/N)");
            String s = llegirString();
            if (s.equals("S") || s.equals("s")) ctrDomini.llistaAssignatures();
            System.out.println("Quina Assignatures vols seleccionar?");
            Integer b = llegirNumero();
            try { ctrDomini.getAssignatura(b);}
            catch (Exception e) {System.out.println("No hi ha cap Assignatura amb aquesta selecció");}
        } else if (sel == 3) {
            System.out.println("Nom de l'assignatura:");
            String nom = llegirString();

            System.out.println("Quins quadrimestres estarà disponible?");
            System.out.println("[1] Q1");
            System.out.println("[2] Q2");
            System.out.println("[3] Q1 i Q2");
            Integer quadri = llegirNumero();

            System.out.println("A quin nivell del pla d'estudis pertany?");
            System.out.println("[1] Troncal");
            System.out.println("[2] Obligatori");
            System.out.println("[3] Especialitat");
            Integer nivell = llegirNumero();

            System.out.println("Quines característiques tenen les classes de Teoria?");
            ArrayList<CaracteristiquesAula> teo = llegirCaracteristiques();

            System.out.println("Quines característiques tenen les classes de Laboratori?");
            ArrayList<CaracteristiquesAula> lab = llegirCaracteristiques();

            System.out.println("A quin pla destudis pertany?");
            String nomPlaEstudis = llegirString();

            if (ctrDomini.existeixPlaEstudis(nomPlaEstudis)) {
                ctrDomini.afegirAssignaturaPlaEstudis(nom, quadri, nivell, nomPlaEstudis, teo, lab);
            } else {
                System.out.println("No existeix el pla d'estudis especificat, es crea igualment l'assignatura.");
                ctrDomini.afegirAssignaturaPlaEstudis(nom, quadri, nivell, teo, lab);
            }
        } else if (sel == 4) {
            System.out.println("Vols mostrar les Assignatures abans? (S/N)");
            String s = llegirString();
            if (s.equals("S") || s.equals("s")) ctrDomini.llistaAssignatures();
            System.out.println("Quina Assignatura vols borrar?");
            Integer b = llegirNumero();
            try {PlaEstudis pe = ctrDomini.getPlaEstudis(); pe.borrarAssignatura(b);}
            catch (Exception e) {System.out.println("No existeix aquesta assignatura");}
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
