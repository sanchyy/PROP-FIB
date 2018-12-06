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

public class MainView {
    @FXML private Button gestioPE;
    @FXML private Button gestioAssig;
    @FXML private Button gestioAu;
    @FXML private Button generarH;
    @FXML private Button sortir;
    @FXML private TextArea debbuging;

    private CtrlPresentacio ctrlPresentacio;
    public void setViewController(CtrlPresentacio ctrlPresentacio){
        this.ctrlPresentacio = ctrlPresentacio;
    }

    @FXML
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
    }
}
