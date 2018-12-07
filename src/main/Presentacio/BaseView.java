package Presentacio;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class BaseView {
    @FXML private AnchorPane gestioView;
    @FXML private Button PlaE, Assig, Aules, GenerarH, Sortir;

    private CtrlPresentacio ctrlPresentacio;

    public void setViewController (CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    /**
     * S'ha clicat el botó Pla d'estudis.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    @FXML
    private void onPlaE_pressed () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewPlaEstudis.fxml").openStream()); //change
        ViewPlaEstudis plaController = loader.getController(); // change
        plaController.setViewController(ctrlPresentacio); // change
        gestioView.getChildren().setAll(a);
    }

    /**
     * S'ha clicat el botó Assignatures.
     */
    @FXML
    public void onAssig_pressed () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAssignatura.fxml").openStream()); //change
        ViewAssignatura assigController = loader.getController(); // change
        assigController.setViewController(ctrlPresentacio); // change
        gestioView.getChildren().setAll(a);
    }

    /**
     * S'ha clicat el botó Aules.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    @FXML
    public void onAules_pressed () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAules.fxml").openStream()); //change
        ViewAules aulesController = loader.getController(); // change
        aulesController.setViewController(ctrlPresentacio); // change
        gestioView.getChildren().setAll(a);
    }

    /**
     * S'ha clicat el botó Generar Horari.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    @FXML
    public void onGenerarH_pressed ()throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewGenerarH.fxml").openStream()); //change
        ViewGenerarH horariController = loader.getController(); // change
        horariController.setViewController(ctrlPresentacio); // change
        gestioView.getChildren().setAll(a);
    }

    /**
     * S'ha clicat el botó Sortir.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    @FXML
    public void onSortir_pressed () throws IOException {
        // get a handle to the stage
        Stage stage = (Stage) Sortir.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}
