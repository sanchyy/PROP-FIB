package main.Presentacio;

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
    private SingletonDialogs singletonDialogs = SingletonDialogs.getInstance();


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
        singletonDialogs.display_carregar("Assignatura");
    }

    /**
     * S'ha clicat consultar una assignatura
     * @throws IOException
     */

    @FXML
    public void onConsultar_pressed() throws IOException {
        ctrlPresentacio.showAssigConsultar();
    }

    @FXML
    public void onEliminar_pressed() {
        singletonDialogs.display_delete("xd", 2); // TODO: pillar l'assig a eliminar
    }

    @FXML
    public void onModificar_pressed() throws IOException {
        ctrlPresentacio.showAssigMod();
    }

}
