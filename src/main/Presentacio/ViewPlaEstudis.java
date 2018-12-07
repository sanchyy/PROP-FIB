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
    //@FXML private  Button PlaE, Assig, Aules, GenerarH, Sortir;
    @FXML private Button crearPE, carregarPE;
    @FXML private TextArea debbuging;
    @FXML private TableView taulaPE;

    private CtrlPresentacio ctrlPresentacio;
    private SingletonPresentacio singleP = SingletonPresentacio.getInstance(); // pels botons de canvi de gestió

    /**
     * Assignar controlador de presentació.
     *
     * @param ctrlPresentacio el controlador de la capa de presentació.
     */
    public void setViewController(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    // Botons canvi de gestió
     /**
     * S'ha clicat el botó Pla d'estudis.
     */
    @FXML
    public void onPlaE_pressed () {
        singleP.onPlaE_pressed();
    }

    /**
     * S'ha clicat el botó Assignatures.
     */
    @FXML
    public void onAssig_pressed () {
        singleP.onAssig_pressed();
    }

    /**
     * S'ha clicat el botó Aules.
     */
    @FXML
    public void onAules_pressed () {
        singleP.onAules_pressed();
    }

    /**
     * S'ha clicat el botó Generar Horari.
     */
    @FXML
    public void onGenerarH_pressed () {
        singleP.onGenerarH_pressed();
    }

    /**
     * S'ha clicat el botó Sortir.
     */
    @FXML
    public void onSortir_pressed () {
        singleP.onSortir_pressed();
    }


    // Botons nou pla
    /**
     * S'ha clicat el botó Crear pla d'estudis.
     */

    @FXML
    public void oncrearPE_pressed () {
        debbuging.appendText("pressed crear\n");
    }

    /**
     * S'ha clicat el botó Carregar pla d'estudis.
     */
    @FXML
    public void oncarregarPE_pressed () {
        debbuging.appendText("pressed crear\n");
    }

}
