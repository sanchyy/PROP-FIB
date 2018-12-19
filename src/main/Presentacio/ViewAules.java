package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class ViewAules {
    @FXML private Button crearAula, carregarAula;
    @FXML private TextArea debbuging;
    @FXML private TableView<Aula_presentacio> taulaAula;
    @FXML private TableColumn<Aula_presentacio, String> name_col;
    @FXML private Button consultar_btn, modificar_btn, eliminar_btn;

    private CtrlPresentacio ctrlPresentacio;
    private SingletonDialogs singletonDialogs = SingletonDialogs.getInstance();

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        name_col.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        // Listen for selection changes and show the person details when changed.
        taulaAula.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> dosomething());
        taulaAula.setPlaceholder(new Label("Cap aula creada"));
    }

    /**
     * Assignar controlador de presentació.
     *
     * @param ctrlPresentacio el controlador de la capa de presentació.
     */
    public void setViewController(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
        taulaAula.setItems(ctrlPresentacio.getAulaData());
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

    /*public void onEliminar_pressed() {
        singletonDialogs.display_delete("", 0); // TODO: pillar aula a eliminar
    }*/

    public void onConsultar_pressed() throws IOException {
        int selectedIndex = taulaAula.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            ctrlPresentacio.showAulaConsultar();
        } else {
            // Nothing selected.
            singletonDialogs.display_warningTable(0);
        }
    }
    public void onModificar_pressed() throws IOException {
        int selectedIndex = taulaAula.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            ctrlPresentacio.showAulaMod();
        } else {
            // Nothing selected.
            singletonDialogs.display_warningTable(0);
        }
    }

    private void dosomething () {

    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void onEliminar_pressed() {
        int selectedIndex = taulaAula.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            if (singletonDialogs.display_delete(taulaAula.getSelectionModel().getSelectedItem().getName(), 0))
                taulaAula.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            singletonDialogs.display_warningTable(0);
        }
    }



}
