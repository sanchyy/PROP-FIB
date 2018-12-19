package Presentacio;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.ArrayList;

import main.Domini.CtrDomini;
import main.Domini.Pair;

/**
 * Tipus controlador de presentació.
 */
public class CtrlPresentacio extends Application{

    private CtrDomini ctrDomini = new CtrDomini();;
    private Stage primaryStage;
    private Scene baseView;

    private BaseView baseController;
    private SingletonDialogs singletonDialogs = SingletonDialogs.getInstance();
    private ObservableList<Aula_presentacio> aulaData = FXCollections.observableArrayList();

    public CtrlPresentacio () {
        Boolean tmp[] = new Boolean[]{true, false, true, false, true, false};
        // TODO: passam una llista de nose, algo que tingui string, int i Boolean[]
        ArrayList<Pair<String, Pair<Integer, Boolean[]>>> aules = ctrDomini.getAules();
        for (Pair<String, Pair<Integer, Boolean[]>> aula : aules) {
            aulaData.add(new Aula_presentacio(aula.getFirst(), aula.getSecond().getFirst(), aula.getSecond().getSecond()));
        }
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.getIcons().add(new Image(getClass().getResource("/icon4.png").toExternalForm()));
        this.primaryStage = primaryStage;
        // ctrDomini = new CtrDomini();
        singletonDialogs.setCtrlPresentacio(this);
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
     * Returns the data as an observable list of Persons.
     * @return
     */
    public ObservableList<Aula_presentacio> getAulaData() {
        return aulaData;
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
        AnchorPane a = loader.load(getClass().getResource("/ViewPlaConcret.fxml").openStream()); //change
        ViewPlaConcret crearController = loader.getController(); // change
        crearController.setViewController(this); // change
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la de Consultar Pla d'estudis.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void showPlaConsultar () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewPlaConcret.fxml").openStream()); //change
        ViewPlaConcret consultarController = loader.getController(); // change
        consultarController.setViewController(this); // change
        consultarController.init_Consultar(); // per preparar a l'escena en mode consultar
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la de Modificar Assignatura.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void showPlaMod () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewPlaConcret.fxml").openStream()); //change
        ViewPlaConcret modController = loader.getController(); // change
        modController.setViewController(this); // change
        modController.init_Mod(false); // si no funciona mirar aixo, mirar l'ordre
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
        AnchorPane a = loader.load(getClass().getResource("/ViewAssigConcreta.fxml").openStream()); //change
        ViewAssigConcreta crearController = loader.getController(); // change
        crearController.setViewController(this); // change
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la de Consultar Assignatura.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void showAssigConsultar () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAssigConcreta.fxml").openStream()); //change
        ViewAssigConcreta consultarController = loader.getController(); // change
        consultarController.setViewController(this); // change
        consultarController.init_Consultar(); // per preparar a l'escena en mode consultar
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la de Modificar Assignatura.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void showAssigMod () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAssigConcreta.fxml").openStream()); //change
        ViewAssigConcreta modController = loader.getController(); // change
        modController.setViewController(this); // change
        modController.init_Mod(false); // si no funciona mirar aixo, mirar l'ordre
        baseController.getGestioView().getChildren().setAll(a);

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
        /*FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAulesCrear.fxml").openStream()); //change
        ViewAulesCrear crearController = loader.getController(); // change
        crearController.setViewController(this); // change
        baseController.getGestioView().getChildren().setAll(a);*/
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAulesConcreta.fxml").openStream()); //change
        ViewAulaConcreta crearController = loader.getController(); // change
        crearController.setViewController(this); // change
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la de Consultar una certa aula.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void showAulaConsultar () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAulaConcreta.fxml").openStream()); //change
        ViewAulaConcreta consultarController = loader.getController(); // change
        consultarController.setViewController(this); // change
        consultarController.init_Consultar(); // per preparar a l'escena en mode consultar
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la de Modificar Aula.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void showAulaMod () throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAulaConcreta.fxml").openStream()); //change
        ViewAulaConcreta modController = loader.getController(); // change
        modController.setViewController(this); // change
        modController.init_Mod(false); // si no funciona mirar aixo, mirar l'ordre
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

    /**
     * Canviar la vista de gestions a la d'Aules.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void showHorariMostrar () throws IOException{
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewHorariMostrar.fxml").openStream()); //change
        ViewHorariMostrar horariController = loader.getController(); // change
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


    // load values
 /*   public void load_AssigConcreta(String name, Integer quatris, Integer nivell, boolean projector, Boolean carac_lab[]) {
        // TODO: demanar que domini em deixi les dades
        // BERNI no se com faras per tornar pero a la capcelera tens el que necessito i en principi mels has de deixar alla
        // tot i que no estic segura que aixo funcioni del tot, pots canviar com enviarli a load values d'assig
        // pero els tipus no plis
        // el name es de quina assig carregar
        // ctrDomini.something();
    }

    public void load_AulaConcreta (String name, Integer capacitat, Boolean carac_lab[]) {
        // TODO: demanar a domini dades d'aula
        // berni el mateix que per assig
        // el name es de quina aula
    }

    public void load_PlaConcreta (String name) {
        // TODO: demanar a domini dades de pla d'estudi

    }*/

    // save values
    /*public void save_AssigConcreta (String name, Integer quatris, Integer nivell, boolean projector, Boolean carac_lab[]) {
        // TODO: tenvio les dades aixi
        // proposta de com podria ser, pero no tinc npi
        // ctrDomini.send_AssigConcreta(name, quatris, nivell, projector, carac_lab);
    }

    public void save_AulaConcreta (String name, Integer capacitat, ArrayList<Boolean> carac) {
        // TODO: tencio les dades aixi
        // proposta
        // ctrDomini.send_AulaConcreta(name, capacitat, carac_lab);
    }

    public void save_PlaConcret (String name) {
        // TODO: dades
        // pueh com lo dabans

    }*/

    // check exitencies
    /*public boolean exists_AssigConcreta (String name) {
        // TODO: tenvio el nom de lassig i mirar si ja existeix (sí: true, no: false)
        return false;
    }

    public boolean exists_AulaConcreta (String name) {
        // TODO: tenvio el nom de l'aula i mirar si ja existeix (sí: true, no: false)
        return false;
    }

    public boolean exists_PlaConcret (String name) {
        // TODO: tenvio el nom del pla i mirar si ja existeix (sí: true, no: false)
        return false;
    }*/

    // carregar
    public void send_path(String path) {
        // TODO: per carregar un fitxer de luser per crear una a
        // 0 aula, 1 pla, 2 asig
        Integer type = singletonDialogs.getCalledby();
        if (type.equals(0)) {
            // ctrDomini.carregarAula(path) o joquese ajajja
        }
        else if (type.equals(1)) {
            //ctrDomini.carr...(path);
        }
        else {
            //ctrDomni.crr...(path);
        }

    }

    // eliminiar
    public void delete_concreta (String name) {
        // TODO: per carregar un fitxer de luser per crear una a
        // 0 aula, 1 pla, 2 asig
        Integer type = singletonDialogs.getCalledby();
        if (type.equals(0)) {
            // ctrDomini.eliminarAula(name) o joquese ajajja
        }
        else if (type.equals(1)) {
            //ctrDomini.eliminarPla(name);
        }
        else {
            //ctrDomni.eliminarAssig(name);
        }

    }

}