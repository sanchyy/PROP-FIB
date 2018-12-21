package Presentacio;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class SingletonDialogs {

    private static SingletonDialogs singleCarregar = new SingletonDialogs();
    //private CtrlPresentacio ctrlPresentacio;
    private static Integer called_by; // 0 aula, 1 pla, 2 asig
    private CtrlPresentacio ctrlPresentacio;

    private SingletonDialogs()  {
        ;
    }

    public static SingletonDialogs getInstance() {
        return singleCarregar;
    }

/*    public void setCalled_by (Integer called_by) {
        this.called_by = called_by;
        System.out.println(called_by);
    }*/
    public static Integer getCalledby () {
        return called_by;
    }

    public void setCtrlPresentacio (CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

   /* public void setViewController(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }
*/
    /**
     * Obre un diàleg per poder seleccionar un GSON obrint una finestre selectora de fitxer, i carregar-lo, només permet carregar si hi ha algun fitxer seleccionat.
     * @param type indica des de quina vista es crida, amb la finalitat de canviar alguns camps descriptius.
     */
    @FXML
    public void display_carregar (String type) {
        Dialog<String> load_dialog = new Dialog<>();
        load_dialog.setTitle("Carregar " + type);
        String header = "Selecciona el fitxer a carregar amb ";
        if (type.equals("Aula")) {
            header += "l'aula/es.";
            called_by = 0;
        }
        else if (type.equals("Pla Estudis")) {
            header += "el pla/ns d'estudis";
            called_by = 1;
        }
        else if (type.equals("Assignatura")) {
            header += "l'assignatura/es";
            called_by = 2;
        }
        load_dialog.setHeaderText(header);
        //load_dialog.setGraphic(new ImageView(getClass().getResource("/icon4.png").toString(), 100, 100, false, false));

        //botons
        ButtonType load_buttonType = new ButtonType("Carregar", ButtonBar.ButtonData.OK_DONE);
        load_dialog.getDialogPane().getButtonTypes().addAll(load_buttonType, ButtonType.CANCEL);

        //
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setPadding(new Insets(20, 200, 20, 10));

        TextField path_input = new TextField();
        path_input.setPrefWidth(250);
        path_input.setPromptText("Choose a file");
        Button select_button = new Button("Seleccionar");
        select_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //debbuging.appendText("seleccionar pressed");
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Obrir el fitxer font");
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", "*.txt"));
                Node node = (Node) event.getSource();
                File selectedFile = fileChooser.showOpenDialog(node.getScene().getWindow());

                //System.out.println(selectedFile.getAbsolutePath());
                path_input.clear();
                path_input.appendText(selectedFile.getAbsolutePath());
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
            ctrlPresentacio.send_path(filePath);
        });
    }

    @FXML
    public boolean display_delete (String name, Integer type) {
        called_by = type;
        Alert delete_alert = new Alert(Alert.AlertType.CONFIRMATION);
        delete_alert.setTitle("Confirmar l'eliminació " + name);
        delete_alert.setHeaderText("Eliminar permanentment " + name);
        delete_alert.setContentText("Estàs a punt d'eliminar " + name +
                ". És un canvi irreversible, vols eliminar-ho?");

        Optional<ButtonType> result = delete_alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // TODO: dir que sha eliminat a capa domini i ella a persitencia
            ctrlPresentacio.delete_concreta(name);
            return true;
        }
        else return false;
    }

    @FXML public void display_warningTable(Integer type) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Res seleccionat");
        String write;
        if (type == 0) write = "Cap aula seleccionada";
        else if (type == 1) write = "Cap pla d'estudis seleccionat";
        else write = "Cap assignatura seleccionada";
        alert.setHeaderText(write);
        alert.setContentText("Selecciona un element de la taula");

        alert.showAndWait();
    }
    @FXML
    public void display_errorCarregar () {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error carregar");
        alert.setHeaderText("S'ha produït un error al carregar el fitxer seleccionat");
        alert.showAndWait();
    }
}
