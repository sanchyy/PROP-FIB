//import Domain.Periode;
//import Domain.PlaEstudis;
//import Domain.Date;
import Domain.Aula;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
        Date ini = new Date(2018, 11, 11);
        Date fi = new Date(2019, 11, 11);
        Periode p = new Periode(ini, fi);
        PlaEstudis pe = new PlaEstudis(p);
        */
/* test berni
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvingut al creador d'horaris");
        System.out.println("");
        System.out.println("Anem a crear un pla d'estudis, indica el nom:");
        PlaEstudis pe = new PlaEstudis(scanner.nextLine());
        System.out.println("Perfecte, has creat el quadrimestre " + pe.getNomPlaEstudis());
        System.out.println("Indica que vols fer");
        if (scanner.nextLine().equals("mostrar")) {
            System.out.println("> " + pe.getNomPlaEstudis());
        }*/
/* test drea
 */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvingut al creador d'horaris\n");

        System.out.println("Indica el nom de l'aula a introduir:");
        String name = scanner.nextLine();

        System.out.println("Indica la capacitat:");
        Integer capacity = scanner.nextInt();

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


    }
}
