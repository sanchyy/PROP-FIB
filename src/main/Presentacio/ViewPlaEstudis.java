package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class ViewPlaEstudis {
    @FXML private Button crearPE, carregarPE;
    @FXML private TextArea debbuging;
    @FXML private TableView<Pla_presentacio> taulaPE;
    @FXML private TableColumn<Pla_presentacio, String> name_col;
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
        taulaPE.setItems(ctrlPresentacio.getPlaData());
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
        taulaPE.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> dosomething());
        taulaPE.setPlaceholder(new Label("Cap aula creada"));
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
        int selectedIndex = taulaPE.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            if (singletonDialogs.display_delete(taulaPE.getSelectionModel().getSelectedItem().getName(), 0)) {
                ctrlPresentacio.delete_concreta(taulaPE.getItems().get(selectedIndex).getName());
                taulaPE.getItems().remove(selectedIndex);
            }
        } else {
            // Nothing selected.
            singletonDialogs.display_warningTable(1);
        }
    }

    public void onConsultar_pressed() throws IOException {
        int selectedIndex = taulaPE.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Pla_presentacio pla = taulaPE.getItems().get(selectedIndex);
            ctrlPresentacio.showPlaConsultar(pla);
        } else {
            // Nothing selected.
            singletonDialogs.display_warningTable(1);
        }
    }
    public void onModificar_pressed() throws IOException {
        int selectedIndex = taulaPE.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Pla_presentacio pla = taulaPE.getItems().get(selectedIndex);
            ctrlPresentacio.showPlaMod(pla);
        } else {
            // Nothing selected.
            singletonDialogs.display_warningTable(1);
        }
    }

    private void dosomething () {

    }
}
