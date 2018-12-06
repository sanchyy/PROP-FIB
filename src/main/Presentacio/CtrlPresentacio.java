package Presentacio;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import Domini.CtrDomini;
/**
 * Tipus controlador de presentació.
 */
public class CtrlPresentacio extends Application{

    private CtrDomini controladorDomini;
    private Stage primaryStage;
    private Scene viewPla;

    /*private VistaSecundaria vistaSecundaria;
    private VistaLEEME vistaLEEME;*/

    @Override
    public void start(Stage primaryStage) throws Exception{
        //primaryStage.getIcons().add(new Image(getClass().getResource("/startIcon.png").toExternalForm()));
        this.primaryStage = primaryStage;
        controladorDomini = new CtrDomini();
        FXMLLoader loader = new FXMLLoader();
        Pane p = loader.load(getClass().getResource("/ViewPla.fxml").openStream()); // Change when the main view is done
        ViewPla mainController = loader.getController();   // change when the main view is done
        mainController.setViewController(this);

        primaryStage.setTitle("Main Menu");
        viewPla = new Scene(p,800,500); // change when the main view is done
        //viewPla.getStylesheets().add("/mainMenuStyle.css"); // add it if we have a css
        primaryStage.setScene(viewPla);
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
}
