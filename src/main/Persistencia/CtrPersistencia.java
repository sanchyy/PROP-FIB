package main.Persistencia;

import java.io.IOException;
import java.util.ArrayList;

public class CtrPersistencia {
    UtilsDisc ud;

    public CtrPersistencia() {
        ud = new UtilsDisc();
    }

    public ArrayList<String> getPlansEstudis() {
        ArrayList<String> plansEstudis = new ArrayList<>();
        try {
            plansEstudis = ud.carrega("PlaEstudi", "plansEstudis");
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
        return plansEstudis;
    }

    public void guardaPlansEstudis(String plansEstudis) {
        try {
            ud.guarda("PlaEstudi", "plansEstudis", plansEstudis);
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    // AULES

    public ArrayList<String> getAules() {
        ArrayList<String> aules= new ArrayList<>();
        try {
            aules = ud.carrega("Aules", "aules");
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
