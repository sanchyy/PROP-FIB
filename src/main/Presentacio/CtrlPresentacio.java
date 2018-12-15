package Presentacio;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import Domini.CtrDomini;
/**
 * Tipus controlador de presentació.
 */
public class CtrlPresentacio extends Application{

    private CtrDomini controladorDomini;
    private Stage primaryStage;
    private Scene mainView, baseView;
    private Scene viewPlaEstudis;

    private BaseView baseController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.getIcons().add(new Image(getClass().getResource("/icon4.png").toExternalForm()));
        this.primaryStage = primaryStage;
        controladorDomini = new CtrDomini();
        FXMLLoader loader = new FXMLLoader();
        SplitPane p = loader.load(getClass().getResource("/BaseView.fxml").openStream()); // Change when the main view is done
        baseController = loader.getController();   // change when the main view is done
        baseController.setViewController(this);     // change

        primaryStage.setTitle("Generador d'horaris");
        baseView = new Scene(p,740,400); // change when the main view is done
        //viewPla.getStylesheets().add("/mainMenuStyle.css"); // add it if we have a css
        primaryStage.setScene(baseView);
        primaryStage.show();
    }

    /**
     * Punt d'entrada de l'aplicació.
     *
     * @param args arguments d'entrada
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Canviar la vista de gestions a la de Gestió de Plans d'estudi.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */

    public void showPlaEstudis () throws IOException{
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewPlaEstudis.fxml").openStream()); //change
        ViewPlaEstudis plaController = loader.getController(); // change
        plaController.setViewController(this); // change
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la de Crear Pla d'estudi.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */

    public void showPlaCrear () throws IOException{
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewPlaCrear.fxml").openStream()); //change
        ViewPlaCrear crearController = loader.getController(); // change
        crearController.setViewController(this); // change
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la de Gestió d'Assignatures.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */

    public void showAssignatures () throws IOException{
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAssignatura.fxml").openStream()); //change
        ViewAssignatura assigController = loader.getController(); // change
        assigController.setViewController(this); // change
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la de Crear Assignatura.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void showAssigCrear () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAssigCrear.fxml").openStream()); //change
        ViewAssigCrear crearController = loader.getController(); // change
        crearController.setViewController(this); // change
        baseController.getGestioView().getChildren().setAll(a);
    }


    public void showAssigConsultar () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAssigConsultar.fxml").openStream()); //change
        ViewAssigConsultar consultarController = loader.getController(); // change
        consultarController.setViewController(this); // change
        consultarController.init_labels(); // per poder agafar les dades i ja tenirles preparades a l'escena
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la de Modificar Assignatura.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void showAssigMod () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAssigCrear.fxml").openStream()); //change
        ViewAssigMod modController = loader.getController(); // change
        modController.setViewController(this); // change
        baseController.getGestioView().getChildren().setAll(a);
        modController.inicialitzar(); // si no funciona mirar aixo, mirar l'ordre

    }

    /**
     * Canviar la vista de gestions a la d'Aules.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */

    public void showAules () throws IOException{
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAules.fxml").openStream()); //change
        ViewAules aulesController = loader.getController(); // change
        aulesController.setViewController(this); // change
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la de Crear Aula.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void showAulesCrear () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAulesCrear.fxml").openStream()); //change
        ViewAulesCrear crearController = loader.getController(); // change
        crearController.setViewController(this); // change
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la d'Aules.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */

    public void showGenerarH () throws IOException{
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewGenerarH.fxml").openStream()); //change
        ViewGenerarH horariController = loader.getController(); // change
        horariController.setViewController(this); // change
        baseController.getGestioView().getChildren().setAll(a);
    }


    // exit
    /**
     * Tancar l'apliació.
     * @throws IOException excepció d'entrada/sortida.
     */

    public void exit_app (Button btn) throws IOException {
        // TODO: enviar ordre de guardar tot a disc
        // get a handle to the stage
        Stage stage = (Stage) btn.getScene().getWindow();
        // do what you have to do
        stage.close();
    }


    public void testFileChooser () {

    }
}
