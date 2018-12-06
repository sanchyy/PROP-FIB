package Presentacio;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;


public class ViewPla {
    @FXML private Button crearPE;
    @FXML private TextArea debbuging;
    private CtrlPresentacio ctrlPresentacio;



    /**
     * Assignar controlador de presentació.
     *
     * @param ctrlPresentacio el controlador de la capa de presentació.
     */
    public void setViewController(CtrlPresentacio ctrlPresentacio){
        this.ctrlPresentacio = ctrlPresentacio;
    }

    /**
     * Crear pla d'estudis clicat.
     */

    @FXML
    public void crearPEpressed () {
        debbuging.appendText("pressed crear\n");

    }

}
