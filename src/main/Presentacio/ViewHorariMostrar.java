package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.input.DragEvent;

import java.io.IOException;

public class ViewHorariMostrar {
    @FXML private GridPane horaro_grid;

    private CtrlPresentacio ctrlPresentacio;
    private boolean modified = false; // 0 crear, 1 consultar, 2 modificar

    /**
     * Assignar controlador de presentació.
     *
     * @param ctrlPresentacio el controlador de la capa de presentació.
     */
    public void setViewController(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    /**
     * S'ha clicat el botó Tornar.
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void onTornar_pressed() throws IOException {
        ctrlPresentacio.showGenerarH();
    }

    public void onModRestric_pressed () {

    }

    public void onGuardar_pressed() {

    }

}
