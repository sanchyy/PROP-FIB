package Persistencia;

import java.io.IOException;
import java.util.ArrayList;

public class CtrPersistencia {
    private UtilsDisc ud;

    public CtrPersistencia() {
        ud = new UtilsDisc();
    }

    public ArrayList<String> getPlansEstudis(String path) {
        ArrayList<String> plansEstudis = new ArrayList<>();
        try {
            plansEstudis = ud.carrega(path);
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
        return plansEstudis;
    }

    public ArrayList<String> getAssignatures(String path) {
        ArrayList<String> assignatures = new ArrayList<>();
        try {
            assignatures = ud.carrega(path);
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
        return assignatures;
    }

    public void guardaPlansEstudis(String plansEstudis) {
        try {
            ud.guarda("PlaEstudi", "plansEstudis", plansEstudis);
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    // AULES

    public ArrayList<String> getAules(String path) {
        ArrayList<String> aules= new ArrayList<>();
        try {
            aules = ud.carrega(path);
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
        return aules;
    }

    public void guardaAules(ArrayList<String> aules) {
        try {
            ud.guardaMultiple("Aules", "aules", aules);
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

}
