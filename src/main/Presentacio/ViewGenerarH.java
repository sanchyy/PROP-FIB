package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

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
     */
    @FXML
    public void oncrearHorari_pressed () {

        debbuging.appendText("pressed crear\n");
    }
}
