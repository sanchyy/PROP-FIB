package Presentacio;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;

public class SingletonPresentacio {
    @FXML private  Button PlaE, Assig, Aules, GenerarH, Sortir;
    @FXML private TextArea debbuging;

    private static SingletonPresentacio singlePresentacio = new SingletonPresentacio();

    private SingletonPresentacio ()  {
        ;
    }

    public static SingletonPresentacio getInstance() {
        return singlePresentacio;
    }

    // Botons canvi de gestió
    /**
     * S'ha clicat el botó Pla d'estudis.
     */

    @FXML
    public void onPlaE_pressed () {

    }

    /**
     * S'ha clicat el botó Assignatures.
     */

    @FXML
    public void onAssig_pressed () {
        debbuging.appendText("pressed Assignatures\n");
    }

    /**
     * S'ha clicat el botó Aules.
     */

    @FXML
    public void onAules_pressed () {
        debbuging.appendText("pressed Aules\n");
    }

    /**
     * S'ha clicat el botó Generar Horari.
     */

    @FXML
    public void onGenerarH_pressed () {
        debbuging.appendText("pressed Generar horari\n");
    }

    /**
     * S'ha clicat el botó Sortir.
     */

    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}
