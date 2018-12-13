package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class ViewAules {
    @FXML private Button crearAula, carregarAula;
    @FXML private TextArea debbuging;
    @FXML private TableView taulaAula;

    private CtrlPresentacio ctrlPresentacio;
    private SingletonDialogs singletonDialogs = SingletonDialogs.getInstance();

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
        singletonDialogs.display_carregar("Aula");
/*        Dialog<String> load_dialog = new Dialog<>();
        load_dialog.setTitle("Carregar Aula");
        load_dialog.setHeaderText("Selecciona el fitxer a carregar amb l'aula/es");
        //load_dialog.setGraphic(new ImageView(this.getClass().getResource("/icon4.png").toString(), 100, 100, false, false));

        //botons
        ButtonType load_buttonType = new ButtonType("Carregar", ButtonBar.ButtonData.OK_DONE);
        load_dialog.getDialogPane().getButtonTypes().addAll(load_buttonType, ButtonType.CANCEL);

        //
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setPadding(new Insets(20, 200, 20, 10));

        TextField path_input = new TextField();
        path_input.setPromptText("Choose a file");
        Button select_button = new Button("Seleccionar");
        select_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                debbuging.appendText("seleccionar pressed");
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Obrir el fitxer font");
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", "*.txt"));
                Node node = (Node) event.getSource();
                File selectedFile = fileChooser.showOpenDialog(node.getScene().getWindow());
                path_input.appendText(selectedFile.getName());

            }
        });

        grid.add (new Label("Fitxer:"), 0, 0);
        grid.add (path_input, 1, 0);
        grid.add(select_button, 1, 1);
        GridPane.setHalignment(select_button, HPos.RIGHT);

        // Enable/Disable path button depending on whether a username was entered.
        Node pathButton = load_dialog.getDialogPane().lookupButton(load_buttonType);
        pathButton.setDisable(true);

        path_input.textProperty().addListener((observable, oldValue, newValue) -> {
            pathButton.setDisable(newValue.trim().isEmpty());
        });


        load_dialog.getDialogPane().setContent(grid);

        load_dialog.setResultConverter(dialogButton -> {
            if (dialogButton == load_buttonType) {
                return path_input.getText();
            }
            return null;
        });
        Optional<String> path = load_dialog.showAndWait();

        path.ifPresent(filePath -> {
            System.out.println(filePath); // canviar per enviar capa domini
        });*/


    }

    /*public void onSeleccionar_pressed(ActionEvent event) {
        debbuging.appendText("seleccionar pressed");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Obrir el fitxer font");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", "*.txt"));
        Node node = (Node) event.getSource();
        File selectedFile = fileChooser.showOpenDialog(node.getScene().getWindow());
        //if (selectedFile != null)

    }*/

    public void onEliminar_pressed() {
        singletonDialogs.display_delete(""); // TODO: pillar aula a eliminar
    }
}
