package test.domini.Assignatura;

import Domini.Assignatura;

import java.util.Scanner;

public class testAssignatura {
    private  static Scanner scanner = new Scanner(System.in);
    public int testAssignatura () {
        System.out.println("Benvingut al test de la classe Assignatura");
        System.out.println("Introdueix quina funció vols provar:");
        System.out.println("[1] Crear Assignatura amb la constructora");
        System.out.println("[0] Sortir");


        Integer seleccio = scanner.nextInt();
        while (seleccio != 0) {
            /*switch (seleccio) {
                case 1:
                    crearAssignaturaDrea();
                    break;
            }*/
            seleccio =  scanner.nextInt();
        }
        return 0;
    }
/*
    public static void crearAssignaturaDrea() {
        System.out.println("Introdueix els seguents paràmetres:");
        System.out.println("Nom de l'assignatura:");
        String nomAssig = scanner.next();

        System.out.println("Quins quatrimestres estarà disponible?");
        System.out.println("[1] Q1");
        System.out.println("[2] Q2");
        System.out.println("[3] Q1 i Q2");
        Integer quatri = scanner.nextInt();

        System.out.println("A quin nivell del pla d'estudis pertany?");
        System.out.println("[1] Troncal");
        System.out.println("[2] Obligatori");
        System.out.println("[3] Especialitat");
        Integer nivell = scanner.nextInt();

        System.out.println("A quin pla destudis pertany?");
        String pla = scanner.next();
        stubPlaEstudis p = findPlaEstudis(pla);
        if (p != null) {
            Assignatura a = new Assignatura(nomAssig, quatri, nivell, pla);
            p.afegirAssignatura(a);
        }
        else {
            System.out.println("No existeix el pla docent especificat, es crea igualment l'assignatura.");
            Assignatura a = new Assignatura(nomAssig, quatri, nivell);
        }
    }
    public static stubPlaEstudis findPlaEstudis (String namePla) {
        for (stubPlaEstudis plaEstudis : listpla) {
            if (plaEstudis.getNom().equals(namePla)) {
                return plaEstudis;
            }
        }
        return null;
    }*/
}
