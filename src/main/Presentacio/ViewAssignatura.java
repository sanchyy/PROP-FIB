package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class ViewAssignatura {
    @FXML private Button crearAssig, carregarAssig;
    @FXML private TextArea debbuging;
    @FXML private TableView<Assig_presentacio> taulaAssig;
    @FXML private TableColumn<Assig_presentacio, String> name_col;
    @FXML private Button consultar_btn, modificar_btn, eliminar_btn;

    private CtrlPresentacio ctrlPresentacio;
    private SingletonDialogs singletonDialogs = SingletonDialogs.getInstance();


    /**
     * Assignar controlador de presentació.
     *
     * @param ctrlPresentacio el controlador de la capa de presentació.
     */
    public void setViewController(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
        taulaAssig.setItems(ctrlPresentacio.getAssigData());
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        name_col.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        // Listen for selection changes and show the person details when changed.
        taulaAssig.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> dosomething());
        taulaAssig.setPlaceholder(new Label("Cap aula creada"));
    }

    // Botons nova Assignatura
    /**
     * S'ha clicat el botó Crear assignatura.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    @FXML
    public void oncrearAssig_pressed () throws IOException {
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
        int selectedIndex = taulaAssig.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Assig_presentacio assig = taulaAssig.getItems().get(selectedIndex);
            ctrlPresentacio.showAssigConsultar(assig);
        } else {
            // Nothing selected.
            singletonDialogs.display_warningTable(2);
        }
    }

    @FXML
    public void onEliminar_pressed() {
        int selectedIndex = taulaAssig.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            if (singletonDialogs.display_delete(taulaAssig.getSelectionModel().getSelectedItem().getName(), 2)) {
                ctrlPresentacio.delete_concreta(taulaAssig.getItems().get(selectedIndex).getName());
                taulaAssig.getItems().remove(selectedIndex);
            }
        } else {
            // Nothing selected.
            singletonDialogs.display_warningTable(2);
        }
    }

    @FXML
    public void onModificar_pressed() throws IOException {
        int selectedIndex = taulaAssig.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Assig_presentacio assig = taulaAssig.getItems().get(selectedIndex);
            ctrlPresentacio.showAssigMod(assig);
        } else {
            // Nothing selected.
            singletonDialogs.display_warningTable(2);
        }
    }

    private void dosomething () {

    }

}
