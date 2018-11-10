import Domini.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<UnitatDocent> unitatsDocents = new ArrayList<>();
    public static UnitatDocent unitatDocentSeleccionada = null;
    public static PlaEstudis plaEstudisSeleccionat = null;
    public static Quadrimestre quadrimestreSeleccionat = null;

    public static Horari horariActual = new Horari();
    public static ArrayList<Sessio> sessions = new ArrayList<>();

    private  static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarTextInici();
        mostrarMenuInici();

        /*
        try {
            String data = readFile("./TEST_1.txt");
            System.out.println(data);
        } catch(IOException ex) {
            System.out.println("Format del fitxer incorrecte");
        }
        */

        Integer seleccio = llegirNumero();
        while (seleccio != 0) {
            switch (seleccio) {
                case 1:
                    crearUnitatDocent();
                    break;
                case 2:
                    crearPlaEstudis();
                    break;
                case 3:
                    crearQuadrimestre();
                    break;
                case 4:
                    crearAula();
                    break;
                case 5:
                    crearAssignatura();
                    break;
                case 6:
                    crearSessio();
                    break;
                case 7:
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

    static String readFile(String path) throws IOException {
        Charset encoding = Charset.defaultCharset();
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static void mostrarTextInici() {
        System.out.println("Benvingut al creador d'horaris");
        System.out.println("------------------------------\n");
    }

    public static void mostrarMenuInici() {
        System.out.println("-----------------");
        if (unitatDocentSeleccionada != null) {
            System.out.println("UnitatDocent: " + unitatDocentSeleccionada.getNom());
            if (plaEstudisSeleccionat != null) {
                System.out.println("PlaEstudis: " + plaEstudisSeleccionat.getNom());
                if (quadrimestreSeleccionat != null) {
                    System.out.println("QUADRIMESTRE SELECCIONAT");
                }
            }
        }
        System.out.println("-----------------");
        System.out.println("[1] Crear UnitatDocent");
        System.out.println("[2] Crear PlaEstudis");
        System.out.println("[3] Crear Quadrimestre");
        System.out.println("[4] Crear Aula");
        System.out.println("[5] Crear Assignatura");
        System.out.println("[6] Crear Sessió");
        System.out.println("[7] Generar horari");
        System.out.println("[0] SORTIR\n");
    }

    public static void errorSeleccio() {
        System.out.println("> Selecció incorrecta");
    }

    public static void crearPlaEstudis() {
        System.out.println("Introdueix el nom del pla d'estudis");
        String nom = llegirString();
        PlaEstudis pe = new PlaEstudis(nom);
        plaEstudisSeleccionat = pe;
        unitatDocentSeleccionada.afegirPlaEstudis(pe);
    }

    public static void crearAula() {
        Aula a = new Aula();
        System.out.println("Introdueix el nom de l'aula");
        a.setNom_aula(llegirString());
        System.out.println("Introdueix la capacitat de l'aula");
        a.setCapacitat(llegirNumero());
        unitatDocentSeleccionada.afegirAulaDisponible(a);
    }

    public static void crearAssignatura() {
        Assignatura a = new Assignatura();
        System.out.println("Introdueix el nom de l'assignatura");
        String nom = llegirString();
        a.setNomAssig(nom);
        System.out.println("Introdueix el nombre de grups");
        a.setNgrups(llegirNumero());
        plaEstudisSeleccionat.afegirAssignatura(a);
    }

    public static void crearSessio() {
        Sessio s = new Sessio();
        System.out.println("De quina assignatura és aquesta sessió?");
        Assignatura a = plaEstudisSeleccionat.getAssignatura(llegirString());
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
        quadrimestreSeleccionat.afegirSessio(s);
        sessions.add(s);
    }

    public static void generarHorari() {
        System.out.println("Es generarà l'horari amb els següents objectes:");
        System.out.println("    Pla d'Estudis: " + plaEstudisSeleccionat.getNom());
        System.out.println("    Aules: ");
        for (Aula a : unitatDocentSeleccionada.getAulesDisponibles()) {
            System.out.println("        - " + a.getNom_aula());
        }
        System.out.println("    Assignatures: ");
        for (Assignatura a : plaEstudisSeleccionat.getAssignatures()) {
            System.out.println("        - " + a.getNomAssig());
        }
        System.out.println("    Sessions: ");
        for (Sessio s : sessions) {
            System.out.println("        - " + s.getAssignatura().getNomAssig() + " " + s.getRestriccio().toString());
        }
        Generador bt = new Generador(horariActual, plaEstudisSeleccionat, sessions);
        bt.generarHorari(unitatDocentSeleccionada.getAulesDisponibles());
        horariActual = bt.getHorari();
        horariActual.mostrarHorari();
    }

    public static void crearUnitatDocent() {
        System.out.println("Introdueix un nom per la nova Unitat Docent:");
        String nom = llegirString();
        UnitatDocent ud = new UnitatDocent(nom);
        unitatDocentSeleccionada = ud;
        unitatsDocents.add(ud);

    }

    public static void crearQuadrimestre() {
        System.out.println("Crear quadrimestre:");
        Quadrimestre q = new Quadrimestre();
        quadrimestreSeleccionat = q;
        plaEstudisSeleccionat.afegirQuadrimestre(q);
    }

    public static String llegirString() {
        return scanner.next();
    }

    public static Integer llegirNumero() {
        return scanner.nextInt();
    }

}
