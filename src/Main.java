import Domini.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static PlaEstudis PlaEstudisActual = null;
    private static Horari horariActual = new Horari();
    private static ArrayList<Sessio> sessions = new ArrayList<>();
    private  static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarTextInici();
        mostrarMenuInici();

        Integer seleccio = llegirNumero();
        while (seleccio != 0) {
            switch (seleccio) {
                case 1:
                    crearPlaEstudis();
                    break;
                case 2:
                    crearAula();
                    break;
                case 3:
                    crearAssignatura();
                    break;
                case 4:
                    crearSessio();
                    break;
                case 5:
                    generarHorari();
                    break;
                default:
                    errorSeleccio();
                    break;
            }
            mostrarMenuInici();
            seleccio = llegirNumero();
        }

        /*
        System.out.println("Indica amb true o false si l'aula té les següents característiques:");
        boolean caracteristics[] = new boolean[6];
        System.out.println("Té projector?");
        caracteristics[0] = scanner.nextBoolean();
        System.out.println("Té Ubuntu?");
        caracteristics[1] = scanner.nextBoolean();
        System.out.println("Té OpenSuse/Windows?");
        caracteristics[2] = scanner.nextBoolean();
        System.out.println("És un laboratori de física?");
        caracteristics[3] = scanner.nextBoolean();
        System.out.println("És un laboratori d'embeded?");
        caracteristics[4] = scanner.nextBoolean();
        System.out.println("És un laboratori de xarxes?");
        caracteristics[5] = scanner.nextBoolean();

        Aula aula = new Aula(name, capacity, caracteristics);
        */
    }

    public static void mostrarTextInici() {
        System.out.println("Benvingut al creador d'horaris");
        System.out.println("------------------------------\n");
    }

    public static void mostrarMenuInici() {
        if (PlaEstudisActual != null) {
            System.out.println("-----------------");
            System.out.println("PlaEstudis: " + PlaEstudisActual.getNomPlaEstudis());
            System.out.println("-----------------");
        }
        System.out.println("[1] Crear PlaEstudis");
        System.out.println("[2] Crear Aula");
        System.out.println("[3] Crear Assignatura");
        System.out.println("[4] Crear Sessió");
        System.out.println("[5] Generar horari");
        System.out.println("[0] SORTIR\n");
    }

    public static void errorSeleccio() {
        System.out.println("> Selecció incorrecta");
    }

    public static void crearPlaEstudis() {
        System.out.println("Introdueix el nom del pla d'estudis");
        PlaEstudisActual = new PlaEstudis(llegirString());
    }

    public static void crearAula() {
        Aula a = new Aula();
        System.out.println("Introdueix el nom de l'aula");
        a.setNom_aula(llegirString());
        System.out.println("Introdueix la capacitat de l'aula");
        a.setCapacitat(llegirNumero());
        PlaEstudisActual.addAula_Disponible(a);
    }

    public static void crearAssignatura() {
        Assignatura a = new Assignatura();
        System.out.println("Introdueix el nom de l'assignatura");
        String nom = llegirString();
        a.setNomAssig(nom);
        System.out.println("Introdueix el nombre de grups");
        a.setGrups(llegirNumero());
        PlaEstudisActual.addAssignatura_Disponible(a);
    }

    public static void crearSessio() {
        Sessio s = new Sessio();
        System.out.println("De quina assignatura és aquesta sessió?");
        Assignatura a = PlaEstudisActual.getAssignatura(llegirString());
        if (a == null) {
            System.out.println("No existeix cap assignatura amb aquest nom");
        } else {
            System.out.println("Vols afegir una restricció a aquesta sessió? (S/N)");
            String response = llegirString();
            System.out.println("Indica: " + response);
            if (response.equals("S")) {
                System.out.println("Indica a quines franjes horaries ha d'estar aquesta sessió");
                System.out.println("Indica la primera hora: ");
                Integer primeraHora = llegirNumero();
                System.out.println("Indica la segona hora: ");
                Integer segonaHora = llegirNumero();
                Pair<Integer, Integer> restriccioHoraria = new Pair(primeraHora, segonaHora);
                s.addRestriccio_horaria(restriccioHoraria);
            }
            s.setAssignatura(a);
        }
        sessions.add(s);
    }

    public static void generarHorari() {
        System.out.println("Es generarà l'horari amb els següents objectes:");
        System.out.println("    Pla d'Estudis: " + PlaEstudisActual.getNomPlaEstudis());
        System.out.println("    Aules: ");
        for (Aula a : PlaEstudisActual.getAules_disponibles()) {
            System.out.println("        - " + a.getNom_aula());
        }
        System.out.println("    Assignatures: ");
        for (Assignatura a : PlaEstudisActual.getAssignatures_disponibles()) {
            System.out.println("        - " + a.getNomAssig());
        }
        System.out.println("    Sessions: ");
        for (Sessio s : sessions) {
            System.out.println("        - " + s.getAssignatura().getNomAssig() + " " + s.getRestriccio().toString());
        }
        Backtracking bt = new Backtracking(horariActual, PlaEstudisActual, sessions);
        bt.generarHorari();
        horariActual = bt.getHorari();
        horariActual.mostrar();
    }

    public static String llegirString() {
        return scanner.next();
    }

    public static Integer llegirNumero() {
        return scanner.nextInt();
    }

}
