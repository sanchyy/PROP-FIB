package main.Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

public class ViewPlaCrear {
    @FXML private Button tornar, crear;
    @FXML private TextField name_input;
    @FXML private Label name_label;

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
        boolean error = false;
        if (name_input.getText() == null || name_input.getText().isEmpty()) {
            error = true;
            name_label.setTextFill(Color.RED);
        }
        else name_label.setTextFill(Color.BLACK);
        // TODO: comprovar que no existeix ja
        if (!error)  {
            name_input.getText();
            // TODO: passar a domini
            ctrlPresentacio.showPlaEstudis();
        }
    }
}
