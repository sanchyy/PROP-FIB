package Presentacio;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
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

    /*private VistaSecundaria vistaSecundaria;
    private VistaLEEME vistaLEEME;*/

    @Override
    public void start(Stage primaryStage) throws Exception{
        //primaryStage.getIcons().add(new Image(getClass().getResource("/startIcon.png").toExternalForm()));
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
/*
    /**
     * Veure la vista de gestió de plans d'estudi.
     *
     * @throws IOException Excepcio Entrada/Sortida.
     */
    /*public void view_gestioPlaEstudis () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane p = loader.load(getClass().getResource("/ViewPlaEstudis.fxml").openStream());
        ViewPlaEstudis PEcontroller = loader.getController();
        PEcontroller.setViewController(this);
    }*/

    /**
     * Canviar la vista de gestions a la de Plans d'estudi.
     *
     * @throws IOException
     */

    public void showPlaView () throws IOException{
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewPlaEstudis.fxml").openStream()); //change
        ViewPlaEstudis plaController = loader.getController(); // change
        plaController.setViewController(this); // change
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la d'Assignatures.
     *
     * @throws IOException
     */

    public void showAssignatures () throws IOException{
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAssignatura.fxml").openStream()); //change
        ViewAssignatura assigController = loader.getController(); // change
        assigController.setViewController(this); // change
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la d'Aules.
     *
     * @throws IOException
     */

    public void showAules () throws IOException{
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAules.fxml").openStream()); //change
        ViewAules aulesController = loader.getController(); // change
        aulesController.setViewController(this); // change
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la d'Aules.
     *
     * @throws IOException
     */

    public void showGenerarH () throws IOException{
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewGenerarH.fxml").openStream()); //change
        ViewGenerarH horariController = loader.getController(); // change
        horariController.setViewController(this); // change
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Tancar l'apliació.
     * @throws IOException excepció d'entrada/sortida.
     */
    @FXML
    public void exit_app (Button btn) throws IOException {
        // get a handle to the stage
        Stage stage = (Stage) btn.getScene().getWindow();
        // do what you have to do
        stage.close();
    }





}
