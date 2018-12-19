package main.Presentacio;

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

public class MainView {
    @FXML private  Button PlaE, Assig, Aules, GenerarH, Sortir;
    @FXML private TextArea debbuging;

    private CtrlPresentacio ctrlPresentacio;
    private SingletonPresentacio singleP = SingletonPresentacio.getInstance(); // pels botons de canvi de gestip

    public void setViewController(CtrlPresentacio ctrlPresentacio){
        this.ctrlPresentacio = ctrlPresentacio;
    }

    /*@FXML
    public void onGestioPE_pressed () {
        debbuging.appendText("Gestio Pla estudis pressed");
    }

    @FXML
    public void onGestioAssig_pressed () {
        debbuging.appendText("Gestio Assig pressed");
    }

    @FXML
    public void onGestioAu_pressed () {
        debbuging.appendText("Gestio Aula pressed");
    }

    @FXML
    public void onGenerarH_pressed () {
        debbuging.appendText("Generar horar pressed");
    }

    @FXML
    public void onSortir_pressed () {
        debbuging.appendText("Sortir pressed");
    }*/

    /**
     * S'ha clicat el botó Pla d'estudis.
     */
    @FXML
    public void onGestioPE_pressed () {
        singleP.onPlaE_pressed();
    }

    /**
     * S'ha clicat el botó Assignatures.
     */
    @FXML
    public void onGestioAssig_pressed () {
        singleP.onAssig_pressed();
    }

    /**
     * S'ha clicat el botó Aules.
     */
    @FXML
    public void onGestioAu_pressed () {
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
        //singleP.handleCloseButtonAction();
    }
}
