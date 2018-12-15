package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class ViewPlaEstudis {
    @FXML private Button crearPE, carregarPE;
    @FXML private TextArea debbuging;
    @FXML private TableView taulaPE;

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

    // Botons nou pla
    /**
     * S'ha clicat el botó Crear pla d'estudis.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    @FXML
    public void oncrearPE_pressed () throws IOException {

        ctrlPresentacio.showPlaCrear();
    }

    /**
     * S'ha clicat el botó Carregar pla d'estudis.
     */
    @FXML
    public void oncarregarPE_pressed () {
        singletonDialogs.display_carregar("Pla Estudis");
    }

    @FXML
    public void onEliminar_pressed() {
        singletonDialogs.display_delete(""); // TODO: pillar pla a eliminar
    }

}
