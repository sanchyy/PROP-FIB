package Presentacio;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class SingletonCarregar {

    private static SingletonCarregar singleCarregar = new SingletonCarregar();

    private SingletonCarregar ()  {
        ;
    }

    public static SingletonCarregar getInstance() {
        return singleCarregar;
    }


    @FXML
    public void oncarregar_pressed (String type) {
        Dialog<String> load_dialog = new Dialog<>();
        load_dialog.setTitle("Carregar " + type);
        String header = new String("Selecciona el fitxer a carregar amb ");
        if (type.equals("Aula")) header += "l'aula/es.";
        else if (type.equals("Pla Estudis")) header += "el pla/ns d'estudis";
        else if (type.equals("Assignatura")) header += "l'assignatura/es";
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

                path_input.clear();
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
            System.out.println(filePath); // debbuging purposes
            // TODO: send file to domain controller; enviar path o file?
        });


    }
}
