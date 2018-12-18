package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class ViewAules {
    @FXML private Button crearAula, carregarAula;
    @FXML private TextArea debbuging;
    @FXML private TableView taulaAula;

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

    // Botons nova Aula
    /**
     * S'ha clicat el botó Crear aula.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    @FXML
    public void oncrearAula_pressed () throws IOException {
        ctrlPresentacio.showAulesCrear();
    }

    /**
     * S'ha clicat el botó Carregar aula.
     */
    public void oncarregarAula_pressed () {
        singletonDialogs.display_carregar("Aula");
    }

    public void onEliminar_pressed() {
        singletonDialogs.display_delete("", 0); // TODO: pillar aula a eliminar
    }

    public void onConsultar_pressed() throws IOException {
        ctrlPresentacio.showAulaConsultar();
    }
    public void onModificar_pressed() throws IOException {
        ctrlPresentacio.showAulaMod();
    }

}
