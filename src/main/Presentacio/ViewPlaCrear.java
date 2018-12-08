package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ViewPlaCrear {
    @FXML private Button tornar, crear;
    @FXML private TextField name;

    private CtrlPresentacio ctrlPresentacio;

    public void setViewController (CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    /**
     * S'ha clicat el botó Tornar.
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void onTornar_pressed() throws IOException {
        ctrlPresentacio.showPlaEstudis();
    }

    /**
     * S'ha clicat el botó Crear.
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void onCrear_pressed() throws IOException {
        //ctrlPresentacio.showPlaView();
        name.appendText("crear pressed");
    }
}
