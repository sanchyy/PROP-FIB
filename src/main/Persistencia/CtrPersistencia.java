package Persistencia;

import java.io.IOException;
import java.util.ArrayList;

public class CtrPersistencia {
    private UtilsDisc ud;

    public CtrPersistencia() {
        ud = new UtilsDisc();
    }

    public ArrayList<String> agafar(String path) {
        ArrayList<String> strings = new ArrayList<>();
        try {
            strings = ud.carrega(path);
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
        return strings;
    }

    public void guardar(Integer tipus, ArrayList<String> strings) {
        try {
            // Plans, Assignatures, Aules
            if (tipus == 0) ud.guardaMultiple("PlaEstudi/plansEstudis.txt", strings);
            else if (tipus == 1) ud.guardaMultiple("Assignatures/assignatures.txt", strings);
            else ud.guardaMultiple("Aules/aules.txt", strings);
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    public ArrayList<String> getAules(String path) {
        ArrayList<String> aules= new ArrayList<>();
        try {
            aules = ud.carrega(path);
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
        return aules;
    }

}
