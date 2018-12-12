package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class ViewAssignatura {
    @FXML private Button crearAssig, carregarAssig;
    @FXML private TextArea debbuging;
    @FXML private TableView taulaAssig;

    private CtrlPresentacio ctrlPresentacio;
    private SingletonCarregar singletonCarregar = SingletonCarregar.getInstance();


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
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    @FXML
    public void oncrearAssig_pressed () throws IOException {
        //debbuging.appendText("pressed crear\n");
        ctrlPresentacio.showAssigCrear();
    }

    /**
     * S'ha clicat el botó Carregar assignatura.
     */
    @FXML
    public void oncarregarAssig_pressed () {
        singletonCarregar.oncarregar_pressed("Assignatura");
    }
}
