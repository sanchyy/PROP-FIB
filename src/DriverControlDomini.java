import Domini.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class DriverControlDomini {
    public static CtrDomini ctrDomini = new CtrDomini();
    private  static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarTextInici();
        mostrarMenuInici();

        /*
        try {
            String data = readFile("./TEST_GENERAL.txt");
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
                    crearRestriccioSolapar();
                    break;
                case 8:
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
        if (ctrDomini.getUnitatDocentSeleccionada() != null && ctrDomini.getUnitatDocent() != null) {
            System.out.println("UnitatDocent: " + ctrDomini.getUnitatDocent().getNom());
            if (ctrDomini.getPlaEstudisSeleccionat() != null && ctrDomini.getPlaEstudis() != null) {
                System.out.println("PlaEstudis: " + ctrDomini.getPlaEstudis().getNom());
                if (ctrDomini.getQuadrimestreSeleccionat() != null && ctrDomini.getQuadrimestre() != null) {
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
        System.out.println("[7] Crear Restricció");
        System.out.println("[8] Generar horari");

        System.out.println("[0] SORTIR\n");
    }

    public static void errorSeleccio() {
        System.out.println("> Selecció incorrecta");
    }

    public static void crearPlaEstudis() {
        System.out.println("Introdueix el nom del pla d'estudis");
        String nom = llegirString();
        ctrDomini.afegirPlaEstudis(nom);
        // Seleccionar

    }

    public static void crearAula() {
        System.out.println("Introdueix el nom de l'aula");
        String name = llegirString();

        System.out.println("Introdueix la capacitat de l'aula");
        Integer capacitat = llegirNumero();

        /*System.out.println("És de teoria (T) o laboratori (L)?");
        String resp = llegirString();
        if (resp.equals("T") || resp.equals("t")) {
            System.out.println("Te projector l'aula? (si o no)");
            String proj = llegirString();
            boolean projector = false;
            if (checkYesorNo(proj)) projector = true;
            Aula_teo at = new Aula_teo(name, capacitat,  projector);
            //ctrDomini.getUnitatDocent().afegirAulaTeo(at);

        }
        else {
            boolean[] carac = {false, false, false, false, false, false};
            System.out.println("Te projector l'aula? (si o no)");
            String carac_resp = llegirString();
            if (checkYesorNo(carac_resp)) carac[0] = true;

            System.out.println("Tenen Ubuntu els ordinadors? (si o no)");
            carac_resp = llegirString();
            if (checkYesorNo(carac_resp)) carac[1] = true;

            System.out.println("Tenen Linux i Windows els ordinadors? (si o no)");
            carac_resp = llegirString();
            if (checkYesorNo(carac_resp)) carac[2] = true;

            System.out.println("Es un laboratori amb instrumental de fisica? (si o no)");
            carac_resp = llegirString();
            if (checkYesorNo(carac_resp)) carac[3] = true;

            System.out.println("Es un laboratiri amb material embeded? (si o no)");
            carac_resp = llegirString();
            if (checkYesorNo(carac_resp)) carac[4] = true;

            System.out.println("Es un laboratori amb material per xarxes? (si o no)");
            carac_resp = llegirString();
            if (checkYesorNo(carac_resp)) carac[5] = true;

            Aula_lab al = new Aula_lab(name, capacitat, carac);
            //ctrDomini.getUnitatDocent().afegirAulaLab(al);
        }*/
        Aula a = new Aula (name, capacitat);
        ctrDomini.getUnitatDocent().afegirAulaDisponible(a);


        //unitatDocentSeleccionada.afegirAulaDisponible(a);
    }
    public static boolean checkYesorNo (String answer) {
        if (answer.equals("si") || answer.equals("Si") || answer.equals("SI"))
            return true;
        else return false;
    }
    /*public static void crearAssignatura() {
        Assignatura a = new Assignatura();
        System.out.println("Introdueix el nom de l'assignatura");
        String nom = llegirString();
        a.setNomAssig(nom);
        System.out.println("A quin quadrimestre vols que pertanyi aquesta assignatura? (1/2/3)");
        Integer quadri = llegirNumero();
        a.setQuatri(quadri);
        System.out.println("De quin nivell és aquesta assignatura? (1/2/3)");
        Integer nivell = llegirNumero();
        a.setNivell(nivell);

        plaEstudisSeleccionat.afegirAssignatura(a);
    }*/

    public static void crearAssignatura() {
        System.out.println("Introdueix els seguents paràmetres:");
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

        System.out.println("A quin pla destudis pertany?");
        String nomPlaEstudis = llegirString();

        if (ctrDomini.existeixPlaEstudis(nomPlaEstudis)) {
            ctrDomini.afegirAssignaturaPlaEstudis(nom, quadri, nivell, nomPlaEstudis);
        } else {
            System.out.println("No existeix el pla d'estudis especificat, es crea igualment l'assignatura.");
            ctrDomini.afegirAssignaturaPlaEstudis(nom, quadri, nivell);
        }
    }

    public static void crearSessio() {
        System.out.println("De quina assignatura és aquesta sessió?");
        String nomAssignatura = llegirString();
        System.out.println("NomA: " + ctrDomini.getAssignatura(nomAssignatura).getNomAssig());
        System.out.println("NomB: " + nomAssignatura);
        if (!ctrDomini.existeixAssignatura(nomAssignatura)) {
            System.out.println("No existeix cap assignatura amb aquest nom");
        } else {
            System.out.println("Indica el grup d'aquesta assignatura");
            Integer grup = llegirNumero();
            ctrDomini.afegirSessioQuadrimestre(grup, nomAssignatura);
        }
    }

    public static void generarHorari() {
        ctrDomini.generarHorari();
    }

    public static void crearUnitatDocent() {
        System.out.println("Introdueix un nom per la nova Unitat Docent:");
        String nom = llegirString();
        ctrDomini.afegirUnitatDocent(nom);
    }

    public static void crearQuadrimestre() {
        System.out.println("Crear quadrimestre:");
        ctrDomini.afegirQuadrimestre();
    }

    //Restriccions
    public static void crearRestriccioSolapar() {
        System.out.println("Sessions:");
        System.out.println(ctrDomini.llistaSessions());
        System.out.println("Introdueix les dos sessions que no vols que es solapin:");
        ctrDomini.crearRestriccioSolapar(llegirNumero(), llegirNumero());
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

    public static void crearRestriccioJornada() {
        
    }



    public static String llegirString() {
        return scanner.next();
    }

    public static Integer llegirNumero() {
        return scanner.nextInt();
    }

}
