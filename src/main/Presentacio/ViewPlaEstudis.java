package Presentacio;

import javafx.fxml.FXML;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;

public class ViewPlaEstudis {
    @FXML private Button crearPE, carregarPE;
    @FXML private TextArea debbuging;
    @FXML private TableView taulaPE;

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
        singletonCarregar.oncarregar_pressed("Pla Estudis");
    }

}
