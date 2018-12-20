package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.List;

public class ViewPlaAssig {
    @FXML private Button tornar, crear;
    @FXML private GridPane assig_grid;
    @FXML private Label assig_label;

    private CtrlPresentacio ctrlPresentacio;

    public void setCtrlPresentacio (CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    public void onTornar_pressed () throws IOException {
        ctrlPresentacio.showPlaEstudis();
    }

    public void initialize () {
        // TODO: demanar llista d'aules
        List<Aula_presentacio> aules_lliures = ctrlPresentacio.getAulesLliures();
        for (Aula_presentacio a : aules) {

        }
    }

}
