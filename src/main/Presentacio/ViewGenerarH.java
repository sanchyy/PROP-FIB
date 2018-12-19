package main.Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class ViewGenerarH {
    @FXML private Button crearHorari;
    @FXML private TextArea debbuging;

    private CtrlPresentacio ctrlPresentacio;

    /**
     * Assignar controlador de presentació.
     *
     * @param ctrlPresentacio el controlador de la capa de presentació.
     */
    public void setViewController(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    /**
     * S'ha clicat el botó Crear horari.
     * @throws IOException
     */
    @FXML
    public void oncrearHorari_pressed () throws IOException {
        ctrlPresentacio.showHorariMostrar();
    }

    /**
     * S'ha clicat el botó Tornar.
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void onTornar_pressed() throws IOException {
        ctrlPresentacio.showPlaEstudis();
    }
}
