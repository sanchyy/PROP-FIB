package Presentacio;

import javafx.application.Application;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

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


public class Main  /*extends Application*/ {
   /* @Override
    public void start(Stage primaryStage) throws Exception{
        //primaryStage.getIcons().add(new Image(getClass().getResource("/startIcon.png").toExternalForm()));
        this.primaryStage = primaryStage;
        controladorDomini = new CtrDomini();
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane p = fxmlLoader.load(getClass().getResource("/ViewPla.fxml").openStream()); // Change when the main view is done
        ViewPla mainController = (ViewPla) fxmlLoader.getController();   // change when the main view is done
        mainController.setViewController(this);

        primaryStage.setTitle("Main Menu");
        mainMenuScene = new Scene(p,800,500);
        mainMenuScene.getStylesheets().add("/mainMenuStyle.css");
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();
    }
    /**
     * Punt d'entrada de l'aplicació.
     *
     * @param args arguments d'entrada
     */
    /*public static void main(String[] args) {
        launch(args);
    }*/
}
