package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class ViewAules {
    @FXML private Button crearAula, carregarAula;
    @FXML private TextArea debbuging;
    @FXML private TableView taulaAula;

    private CtrlPresentacio ctrlPresentacio;

    /**
     * Assignar controlador de presentació.
     *
     * @param ctrlPresentacio el controlador de la capa de presentació.
     */
    public void setViewController(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    // Botons nova Aula
    /**
     * S'ha clicat el botó Crear pla d'estudis.
     */
    @FXML
    public void oncrearAula_pressed () {
        debbuging.appendText("pressed crear\n");
    }

    /**
     * S'ha clicat el botó Carregar .
     */
    @FXML
    public void oncarregarAula_pressed () {
        debbuging.appendText("pressed carregar\n");
    }
}
