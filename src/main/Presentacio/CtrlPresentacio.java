package Presentacio;


import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.xml.internal.fastinfoset.util.CharArrayString;
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
import java.util.List;

import Domini.CtrDomini;
import Domini.Pair;

/**
 * Tipus controlador de presentació.
 */
public class CtrlPresentacio extends Application{

    private CtrDomini ctrDomini;
    private Stage primaryStage;
    private Scene baseView;

    private BaseView baseController;
    private SingletonDialogs singletonDialogs = SingletonDialogs.getInstance();

    private ObservableList<Aula_presentacio> aulaData = FXCollections.observableArrayList();
    private ObservableList<Assig_presentacio> assigData = FXCollections.observableArrayList();
    private ObservableList<Pla_presentacio> plaData = FXCollections.observableArrayList();

    public CtrlPresentacio () {
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.getIcons().add(new Image(getClass().getResource("/icon4.png").toExternalForm()));
        this.primaryStage = primaryStage;
        ctrDomini = new CtrDomini();
        singletonDialogs.setCtrlPresentacio(this);
        FXMLLoader loader = new FXMLLoader();
        SplitPane p = loader.load(getClass().getResource("/BaseView.fxml").openStream()); // Change when the main view is done
        baseController = loader.getController();   // change when the main view is done
        baseController.setViewController(this);     // change

        primaryStage.setTitle("Generador d'horaris");
        baseView = new Scene(p,740,400); // change when the main view is done
        // viewPla.getStylesheets().add("/mainMenuStyle.css"); // add it if we have a css
        primaryStage.setScene(baseView);
        primaryStage.show();

        boolean carregat = ctrDomini.carregaAules("./DB/Aules/aules.txt");
        if (!carregat) singletonDialogs.display_errorCarregar();
        ArrayList<Pair<String, Pair<Integer, Boolean[]>>> aules = ctrDomini.getAules();
        for (Pair<String, Pair<Integer, Boolean[]>> aula : aules) {
            aulaData.add(new Aula_presentacio(aula.getFirst(), aula.getSecond().getFirst(), aula.getSecond().getSecond()));
        }

        carregat = ctrDomini.carregaPlansEstudis("./DB/PlaEstudi/plansEstudis.txt");
        if (!carregat) singletonDialogs.display_errorCarregar();
        ArrayList<String> plans = ctrDomini.getPlansEstudis();
        for (String pla : plans) {
            plaData.add(new Pla_presentacio(pla));
        }

        carregat = ctrDomini.carregaAssignatures("./DB/Assignatures/assignatures.txt");
        if (!carregat) singletonDialogs.display_errorCarregar();
        ArrayList<Pair<String, Pair<Integer, Pair<Integer, Pair<Boolean, Boolean[]>>>>> assigs = ctrDomini.getAssignatures();
        for (Pair<String, Pair<Integer, Pair<Integer, Pair<Boolean, Boolean[]>>>> assig : assigs) {
            String nom = assig.getFirst();
            Integer quatri = assig.getSecond().getFirst();
            Integer nivell = assig.getSecond().getSecond().getFirst();
            Boolean projector = assig.getSecond().getSecond().getSecond().getFirst();
            Boolean[] caracs = assig.getSecond().getSecond().getSecond().getSecond();
            assigData.add(new Assig_presentacio(nom, quatri, nivell, projector, caracs));
        }
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
     * Returns the data as an observable list of Aules.
     * @return ObservableList d'aula presentació
     */
    public ObservableList<Aula_presentacio> getAulaData() {
        return aulaData;
    }

    /**
     * Returns the data as an observable list of Assignatures.
     * @return ObservableList d'assignatura presentació
     */
    public ObservableList<Assig_presentacio> getAssigData () {
        return assigData;
    }

    /**
     * Returns the data as an observable list of Plans d'estudis.
     * @return ObservableList de pla d'estudis presentació
     */
    public ObservableList<Pla_presentacio> getPlaData () {
        return plaData;
    }

    public String prova () {
        return "xd";
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
    public void showPlaConsultar (Pla_presentacio pla) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewPlaConcret.fxml").openStream()); //change
        ViewPlaConcret consultarController = loader.getController(); // change
        consultarController.setViewController(this); // change
        consultarController.setPla(pla);
        consultarController.init_Consultar(); // per preparar a l'escena en mode consultar
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la de Modificar Assignatura.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void showPlaMod (Pla_presentacio pla) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewPlaConcret.fxml").openStream()); //change
        ViewPlaConcret modController = loader.getController(); // change
        modController.setViewController(this); // change
        modController.setPla(pla);
        modController.init_Mod(false); // si no funciona mirar aixo, mirar l'ordre
        baseController.getGestioView().getChildren().setAll(a);
    }

    public void showPlaAssig (Pla_presentacio pla) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewPlaAssig.fxml").openStream()); //change
        ViewPlaAssig modController = loader.getController(); // change
        modController.setViewController(this); // change
        modController.setPla(pla);
        modController.init_pla();
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
    public void showAssigConsultar (Assig_presentacio assig) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAssigConcreta.fxml").openStream()); //change
        ViewAssigConcreta consultarController = loader.getController(); // change
        consultarController.setViewController(this); // change
        consultarController.setAssig(assig);
        consultarController.init_Consultar(); // per preparar a l'escena en mode consultar
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la de Modificar Assignatura.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void showAssigMod (Assig_presentacio assig) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAssigConcreta.fxml").openStream()); //change
        ViewAssigConcreta modController = loader.getController(); // change
        modController.setViewController(this); // change
        modController.setAssig(assig);
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
        AnchorPane a = loader.load(getClass().getResource("/ViewAulaConcreta.fxml").openStream()); //change
        ViewAulaConcreta crearController = loader.getController(); // change
        crearController.setViewController(this); // change
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la de Consultar una certa aula.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void showAulaConsultar (Aula_presentacio aula) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAulaConcreta.fxml").openStream()); //change
        ViewAulaConcreta consultarController = loader.getController(); // change
        consultarController.setViewController(this); // change
        consultarController.setAula(aula);
        consultarController.init_Consultar(); // per preparar a l'escena en mode consultar
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la de Modificar Aula.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void showAulaMod (Aula_presentacio aula) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewAulaConcreta.fxml").openStream()); //change
        ViewAulaConcreta modController = loader.getController(); // change
        modController.setViewController(this); // change
        modController.setAula(aula);
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
        horariController.init_scrolls();
        baseController.getGestioView().getChildren().setAll(a);
    }

    /**
     * Canviar la vista de gestions a la d'Aules.
     *
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void showHorariMostrar (ArrayList<ArrayList<ArrayList<Pair<String, Integer>>>> items) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewHorariMostrar.fxml").openStream()); //change
        ViewHorariMostrar horariController = loader.getController(); // change
        horariController.setViewController(this); // change
        horariController.setHorari(items);
        horariController.init_horari();
        baseController.getGestioView().getChildren().setAll(a);
    }

    public void showHorariSessions (String name) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane a = loader.load(getClass().getResource("/ViewHorariSessions.fxml").openStream()); //change
        ViewHorariSessions horariController = loader.getController(); // change
        horariController.setViewController(this); // change
        horariController.init_table(name);
        baseController.getGestioView().getChildren().setAll(a);
    }

    // exit
    /**
     * Tancar l'aplicació.
     * @throws IOException excepció d'entrada/sortida.
     */

    public void exit_app (Button btn) throws IOException {
        ctrDomini.guardarDades();
        // get a handle to the stage
        Stage stage = (Stage) btn.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public void borrarAula(String nom) {
        ctrDomini.borrarAula(nom);
    }

    // load values
  /*  public void load_AssigConcreta(String name, Integer quatris, Integer nivell, boolean projector, Boolean carac_lab[]) {
        // TODO: demanar que domini em deixi les dades
        // BERNI no se com faras per tornar pero a la capcelera tens el que necessito i en principi mels has de deixar alla
        // tot i que no estic segura que aixo funcioni del tot, pots canviar com enviarli a load values d'assig
        // pero els tipus no plis
        // el name es de quina assig carregar
        // ctrDomini.something();
    }
    */

    /*public void load_PlaConcreta (String old_name, String name) {
        for (Pla_presentacio a : plaData) {
            if (a.getName().equals(old_name)) {
                plaData.remove(a);
                break;
            }
        }
        plaData.add(new Pla_presentacio(name));
        //ctrDomini.modificarPla(old_name, name);

    }*/

   // public void load_

    // save values
    public void save_AssigConcreta (String old_name, String name, Integer quatris, Integer nivell, boolean projector, Boolean carac_lab[]) {
        for (Assig_presentacio a : assigData) {
            if (a.getName().equals(old_name)) {
                assigData.remove(a);
                break;
            }
        }
        assigData.add(new Assig_presentacio(name, quatris, nivell, projector, carac_lab));
        ctrDomini.modificarAssignatura(old_name, name, quatris, nivell, projector, carac_lab);
    }

    public void save_AssigNew (String name, Integer quatris, Integer nivell, boolean projector, Boolean carac_lab[]) {
        Assig_presentacio ap = new Assig_presentacio(name, quatris, nivell, projector, carac_lab);
        assigData.add(ap);
        Boolean[] caracs = {projector, false, false, false, false, false};
        ctrDomini.afegirAssignaturaPlaEstudis(name, quatris, nivell, caracs, carac_lab);
    }

    public void save_AulaConcreta (String old_name, String name, Integer capacitat, Boolean[] carac) {
        for (Aula_presentacio a : aulaData) {
            if (a.getName().equals(old_name)) {
                aulaData.remove(a);
                break;
            }
        }
        aulaData.add(new Aula_presentacio(name, capacitat, carac));
        ctrDomini.modificarAula(old_name, name, capacitat, carac);
    }

    public void save_AulaNew(String name, Integer capacitat, Boolean[] carac) {
        ctrDomini.afegirAula(name, capacitat, carac);
        Aula_presentacio ap = new Aula_presentacio(name, capacitat, carac);
        aulaData.add(ap);
    }

    public void save_PlaConcret (String old_name, String name) {
        for (Pla_presentacio a : plaData) {
            if (a.getName().equals(old_name)) {
                plaData.remove(a);
                break;
            }
        }
        plaData.add(new Pla_presentacio(name));
        ctrDomini.modificarPlaEstudis(old_name, name);
    }

    public void save_PlaNew (String name) {
        Pla_presentacio plap = new Pla_presentacio(name);
        plaData.add(plap);
        ctrDomini.afegirPlaEstudis(name);
    }

    // check exitencies
    public boolean exists_AssigConcreta (String name) {
        // TODO: tenvio el nom de lassig i mirar si ja existeix (sí: true, no: false)
        // ctrDomini.exists_Aula(name);
        return false;
    }

    public boolean exists_AulaConcreta (String name) {
        // TODO: tenvio el nom de l'aula i mirar si ja existeix (sí: true, no: false)

        return false;
    }

    public boolean exists_PlaConcret (String name) {
        // TODO: tenvio el nom del pla i mirar si ja existeix (sí: true, no: false)
        return false;
    }

    // carregar
    public void send_path(String path) {
        Integer type = singletonDialogs.getCalledby();
        if (type.equals(0)) {
            boolean carregat = ctrDomini.carregaAules(path);
            if (!carregat) singletonDialogs.display_errorCarregar();
            ArrayList<Pair<String, Pair<Integer, Boolean[]>>> aules = ctrDomini.getAules();
            for (Pair<String, Pair<Integer, Boolean[]>> aula : aules) {
                aulaData.add(new Aula_presentacio(aula.getFirst(), aula.getSecond().getFirst(), aula.getSecond().getSecond()));
            }
        } else if (type.equals(1)) {
            boolean carregat = ctrDomini.carregaPlansEstudis(path);
            if (!carregat) singletonDialogs.display_errorCarregar();
            ArrayList<String> plans = ctrDomini.getPlansEstudis();
            for (String pla : plans) {
                plaData.add(new Pla_presentacio(pla));
            }
        } else {
            boolean carregat = ctrDomini.carregaAssignatures(path);
            if (!carregat) singletonDialogs.display_errorCarregar();
            ArrayList<Pair<String, Pair<Integer, Pair<Integer, Pair<Boolean, Boolean[]>>>>> assigs = ctrDomini.getAssignatures();
            for (Pair<String, Pair<Integer, Pair<Integer, Pair<Boolean, Boolean[]>>>> assig : assigs) {
                String nom = assig.getFirst();
                Integer quatri = assig.getSecond().getFirst();
                Integer nivell = assig.getSecond().getSecond().getFirst();
                Boolean projector = assig.getSecond().getSecond().getSecond().getFirst();
                Boolean[] caracs = assig.getSecond().getSecond().getSecond().getSecond();
                assigData.add(new Assig_presentacio(nom, quatri, nivell, projector, caracs));
            }
        }
    }

    public void delete_concreta (String name) {
        Integer type = singletonDialogs.getCalledby();
        if (type.equals(0)) {
            ctrDomini.borrarAula(name);
        } else if (type.equals(1)) {
            ctrDomini.borrarPlaEstudis(name);
        } else {
            ctrDomini.borrarAssignatura(name);
        }

    }


    public void send_inputHorari (String pla, ArrayList<String> aules) {
        ctrDomini.itemsHorari(pla, aules);
    }

    public ArrayList<ArrayList<ArrayList<Pair<String, Integer>>>> send_sessionsHorari (ArrayList<Pair<String, Pair<Integer, Pair<Integer, Integer>>>> sessions) {
        return ctrDomini.sessionsHorari(sessions);
    }

    public void send_AssigPla (String pla, ArrayList<String> assig) {
        ctrDomini.assignarAssignatures(pla, assig);
    }

    public ArrayList<String> getAulesLliures () {
        return ctrDomini.assignaturesLliures();
    }

    public ArrayList<String> getAssigPla(String name) {
        return ctrDomini.assignaturesFromPla(name);
    }
}