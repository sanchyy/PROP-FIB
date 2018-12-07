package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class ViewAssignatura {
    @FXML private Button crearAssig, carregarAssig;
    @FXML private TextArea debbuging;
    @FXML private TableView taulaAssig;

    private CtrlPresentacio ctrlPresentacio;

    /**
     * Assignar controlador de presentació.
     *
     * @param ctrlPresentacio el controlador de la capa de presentació.
     */
    public void setViewController(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    // Botons nova Assignatura
    /**
     * S'ha clicat el botó Crear assignatura.
     */
    @FXML
    public void oncrearAssig_pressed () {
        debbuging.appendText("pressed crear\n");
    }

    /**
     * S'ha clicat el botó Carregar assignatura.
     */
    @FXML
    public void oncarregarAssig_pressed () {
        debbuging.appendText("pressed carregar\n");
    }
}
