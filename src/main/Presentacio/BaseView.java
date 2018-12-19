package main.Presentacio;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class BaseView {
    @FXML private AnchorPane gestioView;
    @FXML private Button PlaE, Assig, Aules, GenerarH, Sortir;

    private CtrlPresentacio ctrlPresentacio;
    private ViewPlaEstudis plaController;

    public void setViewController (CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    public AnchorPane getGestioView () {
        return gestioView;
    }

    /**
     * S'ha clicat el botó Pla d'estudis.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    @FXML
    private void onPlaE_pressed () throws IOException {
        /*FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewPlaEstudis.fxml").openStream()); //change
        plaController = loader.getController(); // change
        plaController.setViewController(ctrlPresentacio); // change
        gestioView.getChildren().setAll(a);*/
        //PlaE.setBackground(new Background(new BackgroundFill(Color.rgb(128, 169, 255), CornerRadii.EMPTY, Insets.EMPTY)));
        btn_backgroundColor("pla");
        ctrlPresentacio.showPlaEstudis();
    }

    /**
     * S'ha clicat el botó Assignatures.
     */
    @FXML
    public void onAssig_pressed () throws IOException {
        /*FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAssignatura.fxml").openStream()); //change
        ViewAssignatura assigController = loader.getController(); // change
        assigController.setViewController(ctrlPresentacio); // change
        gestioView.getChildren().setAll(a);*/
        //Assig.setBackground(new Background(new BackgroundFill(Color.rgb(139, 255, 158), CornerRadii.EMPTY, Insets.EMPTY)));
        btn_backgroundColor("assig");
        ctrlPresentacio.showAssignatures();
    }

    /**
     * S'ha clicat el botó Aules.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    @FXML
    public void onAules_pressed () throws IOException {
        /*FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAules.fxml").openStream()); //change
        ViewAules aulesController = loader.getController(); // change
        aulesController.setViewController(ctrlPresentacio); // change
        gestioView.getChildren().setAll(a);*/
        //Aules.setBackground(new Background(new BackgroundFill(Color.rgb(255, 229, 144), CornerRadii.EMPTY, Insets.EMPTY)));
        btn_backgroundColor("aules");
        ctrlPresentacio.showAules();
    }

    /**
     * S'ha clicat el botó Generar Horari.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    @FXML
    public void onGenerarH_pressed ()throws IOException {
        /*FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewGenerarH.fxml").openStream()); //change
        ViewGenerarH horariController = loader.getController(); // change
        horariController.setViewController(ctrlPresentacio); // change
        gestioView.getChildren().setAll(a);*/
        btn_backgroundColor("generar");
        ctrlPresentacio.showGenerarH();
    }

    // exit btn
    /**
     * S'ha clicat el botó Sortir.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    @FXML
    public void onSortir_pressed () throws IOException {
        ctrlPresentacio.exit_app(Sortir);
    }

    public void btn_backgroundColor (String btn) {
        Background selected = new Background(new BackgroundFill(Color.rgb(139, 255, 158), CornerRadii.EMPTY, Insets.EMPTY));
        Background not_selected = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
        if (btn.equals("pla")) PlaE.setBackground(selected);
        else PlaE.setBackground(not_selected);

        if (btn.equals("assig")) Assig.setBackground(selected);
        else Assig.setBackground(not_selected);

        if (btn.equals("aules")) Aules.setBackground(selected);
        else Aules.setBackground(not_selected);

        if (btn.equals("generar")) GenerarH.setBackground(selected);
        else GenerarH.setBackground(not_selected);

    }




}
