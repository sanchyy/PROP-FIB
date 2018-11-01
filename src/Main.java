import Domain.Periode;
import Domain.PlaEstudis;
import Domain.Date;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
        Date ini = new Date(2018, 11, 11);
        Date fi = new Date(2019, 11, 11);
        Periode p = new Periode(ini, fi);
        PlaEstudis pe = new PlaEstudis(p);
        */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvingut al creador d'horaris");
        System.out.println("");
        System.out.println("Anem a crear un pla d'estudis, indica el nom:");
        PlaEstudis pe = new PlaEstudis(scanner.nextLine());
        System.out.println("Perfecte, has creat el quadrimestre " + pe.getNomPlaEstudis());
        System.out.println("Indica que vols fer");
        if (scanner.nextLine().equals("mostrar")) {
            System.out.println("> " + pe.getNomPlaEstudis());
        }

    }
}
