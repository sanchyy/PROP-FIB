package Presentacio;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
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

    /*private VistaSecundaria vistaSecundaria;
    private VistaLEEME vistaLEEME;*/

    @Override
    public void start(Stage primaryStage) throws Exception{
        //primaryStage.getIcons().add(new Image(getClass().getResource("/startIcon.png").toExternalForm()));
        this.primaryStage = primaryStage;
        controladorDomini = new CtrDomini();
        FXMLLoader loader = new FXMLLoader();
        SplitPane p = loader.load(getClass().getResource("/BaseView.fxml").openStream()); // Change when the main view is done
        BaseView mainController = loader.getController();   // change when the main view is done
        mainController.setViewController(this);

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
     * Veure la vista de gestió de plans d'estudi.
     *
     * @throws IOException Excepcio Entrada/Sortida.
     */
    public void view_gestioPlaEstudis () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane p = loader.load(getClass().getResource("/ViewPlaEstudis.fxml").openStream());
        ViewPlaEstudis PEcontroller = loader.getController();
        PEcontroller.setViewController(this);



    }


}
