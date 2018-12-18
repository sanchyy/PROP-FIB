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

}
