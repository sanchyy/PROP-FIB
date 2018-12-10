package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.Optional;

public class ViewAules {
    @FXML private Button crearAula, carregarAula;
    @FXML private TextArea debbuging;
    @FXML private TableView taulaAula;

    private CtrlPresentacio ctrlPresentacio;

    /**
     * Assignar controlador de presentació.
     *
     * @param ctrlPresentacio el controlador de la capa de presentació.
     */
    public void setViewController(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
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
    @FXML
    public void oncarregarAula_pressed () {
        Dialog<String> load_dialog = new Dialog<>();
        load_dialog.setTitle("Carregar Aula");
        load_dialog.setHeaderText("Selecciona el fitxer a carregar");

        //botons
        ButtonType load_buttonType = new ButtonType("Carregar", ButtonBar.ButtonData.OK_DONE);
        load_dialog.getDialogPane().getButtonTypes().addAll(load_buttonType, ButtonType.CANCEL);

        //
        GridPane grid = new GridPane();

        TextField path_input = new TextField();
        path_input.setPromptText("Choose a path");
        //Button select_button = new Button()

        grid.add (new Label("Fitxer:"), 0, 0);
        grid.add (path_input, 1, 0);

        // Enable/Disable path button depending on whether a username was entered.
        Node pathButton = load_dialog.getDialogPane().lookupButton(load_buttonType);
        pathButton.setDisable(true);

        load_dialog.getDialogPane().setContent(grid);
        Optional<String> path = load_dialog.showAndWait();


    }
}
