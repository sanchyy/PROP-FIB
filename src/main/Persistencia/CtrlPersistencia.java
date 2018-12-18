package main.Persistencia;

import java.io.IOException;
import java.util.ArrayList;

public class CtrlPersistencia {
    GestorAssignatura gAs;
    GestorPlaEstudis  gPe;
    GestorAula        gAu;
    GestorRestriccio  gRe;
    GestorHorari      gHo;

    public CtrlPersistencia() {
        gPe = new GestorPlaEstudis();
    }

    /*public ArrayList<Domini.PlaEstudis> getPlansEstudis() throws IOException{

        return gPe.agafa();
    }*/

    public void guarda() throws IOException {
        gPe.guarda("FIB 2018", "HOLIII");
    }
}
