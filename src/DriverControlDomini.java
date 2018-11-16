import Domini.*;
import Drivers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DriverControlDomini {

    public static CtrDomini ctrDomini = new CtrDomini(0);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarTextInici();
        System.out.println("Vols carregar l'horari a partir d'un fitxer? (S/N)");
        String sel = llegirString();
        if (sel.equalsIgnoreCase("S")) {

            File tests = new File("./tests/");
            for (final File fileEntry : tests.listFiles()) {
                System.out.println(fileEntry.getName());
            }

            System.out.println("Introdueix el test que vols usar:");
            String test = llegirString();

            try {
                scanner = new Scanner(new File("./tests/" + test));
            } catch (FileNotFoundException c) {
                System.out.println("El fitxer no existeix");
            }
        }
        mostrarMenuInici();
        Integer seleccio = llegirNumero();
        while (seleccio != 0) {
            switch (seleccio) {
                case 1:
                    DriverUnitatDocent.runDriver(ctrDomini, scanner);
                    break;
                case 2:
                    DriverPlaEstudis.runDriver(ctrDomini, scanner);
                    break;
                case 3:
                    DriverQuadrimestre.runDriver(ctrDomini, scanner);
                    break;
                case 4:
                    DriverAula.runDriver(ctrDomini, scanner);
                    break;
                case 5:
                    DriverAssignatura.runDriver(ctrDomini, scanner);
                    break;
                case 6:
                    DriverSessio.runDriver(ctrDomini, scanner);
                    break;
                case 7:
                    DriverRestriccio.runDriver(ctrDomini, scanner);
                    break;
                case 8:
                    ctrDomini.generarHorari();
                    break;
                default:
                    System.out.println("> Selecció incorrecta");
                    break;
            }
            mostrarMenuInici();
            seleccio = llegirNumero();
        }
    }

    public static void mostrarTextInici() {
        System.out.println("Benvingut al creador d'horaris");
        System.out.println("------------------------------\n");
    }

    public static void mostrarMenuInici() {
        System.out.println("-----------------");
        if (ctrDomini.getUnitatDocentSeleccionada() != null && ctrDomini.getUnitatDocent() != null) {
            System.out.println("UnitatDocent: " + ctrDomini.getUnitatDocent().getNom());
            if (ctrDomini.getPlaEstudisSeleccionat() != null && ctrDomini.getPlaEstudis() != null) {
                System.out.println("PlaEstudis: " + ctrDomini.getPlaEstudis().getNom());
                if (ctrDomini.getQuadrimestreSeleccionat() != null && ctrDomini.getQuadrimestre() != null) {
                    System.out.println("QUADRIMESTRE SELECCIONAT");
                }
            }
        }
        System.out.println("-------------------");
        System.out.println("Accions disponibles");
        System.out.println("-------------------");
        System.out.println("[1] UnitatDocent");
        System.out.println("[2] PlaEstudis");
        System.out.println("[3] Quadrimestre");
        System.out.println("[4] Aula");
        System.out.println("[5] Assignatura");
        System.out.println("[6] Sessió");
        System.out.println("[7] Restricció");
        System.out.println("[8] Generar horari");

        System.out.println("[0] SORTIR\n");
    }

    public static String llegirString() {
        return scanner.next();
    }

    public static Integer llegirNumero() {
        return scanner.nextInt();
    }

}
