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

    public void guardar(String path, ArrayList<String> strings) {
        try {
            ud.guardaMultiple(path, strings);
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
