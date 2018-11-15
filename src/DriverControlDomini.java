import Domini.*;
import Drivers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DriverControlDomini {

    public static CtrDomini ctrDomini = new CtrDomini();
    private static Scanner scanner = new Scanner(System.in);

    public static List<CaracteristiquesAula> listEnum = Arrays.asList(CaracteristiquesAula.values());

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
                scanner = new Scanner(new File(test));
            } catch (FileNotFoundException c) {
                System.out.println("El fitxer no existeix");
            }
        }
        mostrarMenuInici();
        Integer seleccio = llegirNumero();
        while (seleccio != 0) {
            switch (seleccio) {
                case 1:
                    DriverUnitatDocent.main(ctrDomini, scanner);
                    break;
                case 2:
                    DriverPlaEstudis.main(ctrDomini, scanner);
                    break;
                case 3:
                    DriverQuadrimestre.main(ctrDomini, scanner);
                    break;
                case 4:
                    DriverAula.main(ctrDomini, scanner);
                    break;
                case 5:
                    DriverAssignatura.main(ctrDomini, scanner);
                    break;
                case 6:
                    DriverSessio.main(ctrDomini, scanner);
                    break;
                case 7:
                    DriverRestriccio.main(ctrDomini, scanner);
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
        System.out.println("[2] Crear PlaEstudis");
        System.out.println("[3] Crear Quadrimestre");
        System.out.println("[4] Crear Aula");
        System.out.println("[5] Crear Assignatura");
        System.out.println("[6] Crear Sessió");
        System.out.println("[7] Crear Restricció");
        System.out.println("[8] Generar horari");

        System.out.println("[0] SORTIR\n");
    }

    public static ArrayList<CaracteristiquesAula> llegirCaracteristiques() {
        ArrayList<CaracteristiquesAula> caracteristiques = new ArrayList<>();
        for (CaracteristiquesAula caracteristica : listEnum) {
            System.out.println("Té la següent característica (S/N)? (" + caracteristica.toString() + ")");
            String resp = llegirString();
            if (resp.equals("S")) caracteristiques.add(caracteristica);
        }
        return caracteristiques;
    }

    public static void crearRestriccio() {
        System.out.println("Indica quina restricció vols crear:");
        System.out.println("[1] Característiques Aula");
        System.out.println("[2] Solapament");
        Integer sel = llegirNumero();
        if (sel == 1) {
            crearRestriccioCaracteristicaAula();
        } else if (sel == 2) {
            // crearRestriccioSolapar();
        } else {
            System.out.println("Selecció incorrecte");
        }
    }

    public static void crearRestriccioCaracteristicaAula() {
        System.out.println("Sessions:");
        System.out.println(ctrDomini.llistaSessions());
        Integer sessio = llegirNumero();
        System.out.println("Caracteristiques:");
        ArrayList<CaracteristiquesAula> caracteristiques = llegirCaracteristiques();
        ctrDomini.crearRestriccioCaracteristicaAula(sessio, caracteristiques);
    }

    public static void crearRestriccioReserva() {
        System.out.println("Introdueix l'aula que vols reservar");
        String aula = llegirString();
        System.out.println("has seleccionat l'aula: " + aula);

        System.out.println("Introdueix el dia de la setmana que vols reservar:");
        System.out.println("[1] Dilluns"  );
        System.out.println("[2] Dimarts"  );
        System.out.println("[3] Dimecres" );
        System.out.println("[4] Dijous"   );
        System.out.println("[5] Divendres");
        Integer dia = llegirNumero();

        System.out.println("Vols reservar tot el dia?");
        System.out.println("[1] Sí");
        System.out.println("[2] No");
        Integer hora = null;
        if (llegirNumero() == 2) {
            System.out.println("Introdueix la hora que vols que es reservi.");
            hora = llegirNumero();
        }

        ctrDomini.crearRestriccioReservar(aula,dia,hora);
    }

    public static void crearRestriccioAssigTemp() {
        System.out.println("Introdueix l'assignatura que vols fixar en un dia");
        String assig = llegirString();
        System.out.println("has seleccionat l'assignatura: " + assig);

        System.out.println("Introdueix el dia de la setmana que vols fixar:");
        System.out.println("[1] Dilluns"  );
        System.out.println("[2] Dimarts"  );
        System.out.println("[3] Dimecres" );
        System.out.println("[4] Dijous"   );
        System.out.println("[5] Divendres");
        Integer dia = llegirNumero();

        System.out.println("Vols fixar un dia sencer o dia i hora");
        System.out.println("[1] Dia");
        System.out.println("[2] Dia i hora");
        Integer hora = null;
        if (llegirNumero() == 2) {
            System.out.println("Introdueix la hora que vols que es reservi.");
            hora = llegirNumero();
        }

        ctrDomini.crearRestriccioAssigTemp(dia,hora,assig);
    }

    public static String llegirString() {
        return scanner.next();
    }

    public static Integer llegirNumero() {
        return scanner.nextInt();
    }

}
