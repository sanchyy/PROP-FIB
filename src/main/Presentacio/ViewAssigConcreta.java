package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;

public class ViewAssigConcreta {
    @FXML private Button tornar, mode_btn;
    @FXML private Label title_label, description_label,name_label, quatri_label, teo_label, nivell_label, lab_label;
    @FXML private TextField name_input;
    @FXML private RadioButton yes_radio, no_radio;
    @FXML private ToggleGroup projector_group, nivell_group;
    //@FXML private HBox nivell_box;
    @FXML private RadioButton init_rad, obli_rad, esp_rad;
    @FXML private CheckBox projector, ubuntu, LW, fisica, embeded, xarxes, q1, q2;

    private CtrlPresentacio ctrlPresentacio;
    private int actual_mode = 0; // 0 crear, 1 consultar, 2 modificar
    private Assig_presentacio assig;

    /**
     * Assignar controlador de presentació.
     *
     * @param ctrlPresentacio el controlador de la capa de presentació.
     */
    public void setViewController(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    public void setAssig (Assig_presentacio assig) {
        this.assig = assig;
    }

    @FXML
    public void init_Mod (boolean pre_consultar) throws IOException {
        title_label.setText("MODIFICAR ASSIGNATURA");
        description_label.setText("Pots modificar els següents camps:");
        if (pre_consultar) init_properties(true);
        else load_values();
        mode_btn.setText("Guardar canvis");
        actual_mode = 2;
    }

    // bloquejar edicio camps entrada + carregar info

    /**
     * Inicialitzar els atributs de l'assignatura i modificar el títol a consultar i el botó específic a "Modificar"
     */
    @FXML
    public void init_Consultar () {
        title_label.setText("CONSULTAR ASSIGNATURA");
        description_label.setText("Conté la següent informació:");
        init_properties(false);
        load_values();
        mode_btn.setText("Modificar");
        actual_mode = 1;
    }

    /**
     * Posa els camps d'entrada com a editables (true) o ReadOnly (false)
     * @param editable indica si la informació mostrada ha de poder-se editar (true) o no
     */
    private void init_properties (boolean editable) {
        name_input.setEditable(editable);
        name_input.setMouseTransparent(!editable);
        name_input.setFocusTraversable(editable);

        q1.setDisable(!editable);
        q1.setStyle("-fx-opacity: 1");
        q2.setDisable(!editable);
        q2.setStyle("-fx-opacity: 1");

        init_rad.setDisable(!editable);
        init_rad.setStyle("-fx-opacity: 1");
        obli_rad.setDisable(!editable);
        obli_rad.setStyle("-fx-opacity: 1");
        esp_rad.setDisable(!editable);
        esp_rad.setStyle("-fx-opacity: 1");

        yes_radio.setDisable(!editable);
        yes_radio.setStyle("-fx-opacity: 1");
        no_radio.setDisable(!editable);
        no_radio.setStyle("-fx-opacity: 1");

        projector.setDisable(!editable);
        projector.setStyle("-fx-opacity: 1");
        ubuntu.setDisable(!editable);
        ubuntu.setStyle("-fx-opacity: 1");
        LW.setDisable(!editable);
        LW.setStyle("-fx-opacity: 1");
        fisica.setDisable(!editable);
        fisica.setStyle("-fx-opacity: 1");
        embeded.setDisable(!editable);
        embeded.setStyle("-fx-opacity: 1");
        xarxes.setDisable(!editable);
        xarxes.setStyle("-fx-opacity: 1");
    }


    /**
     * S'ha clicat el botó Tornar.
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void onTornar_pressed() throws IOException {
        ctrlPresentacio.showAssignatures();
    }

    /**
     * S'ha clicat el botó mode ("Crear" a la creació, "Modificar" a la consulta o "Guardar canvis" a la modificació.
     * @throws IOException
     */
    public void onMode_pressed() throws IOException {
        if (actual_mode == 1) {
            init_Mod(true);
        }
        else {
            save_values();
        }
    }

    /**
     * Carrega els valors dels atributs de l'assignatura seleccionada i els mostra.
     */
    private void load_values () {
        // TODO: agafar dades, demanar a domini
        String name = assig.getName(); // agafar nom, demanar domini
        Integer quatris = assig.getQuatri(); // agafar quatris
        Integer nivell = assig.getNivell(); // agafar nivell
        Boolean projector_teo = assig.getProjector(); // agafar carac teo
        Boolean carac_lab[] = assig.getCarac(); // agafar carac lab
        // Berni: ara estan inicialitzats pero era per testejar,
        // tambe pot servir per comprovar si va be el pas per referencia

        //ctrlPresentacio.load_AssigConcreta(name, quatris, nivell, projector_teo, carac_lab);

        name_input.setText(name);

        if (quatris.equals(3) || quatris.equals(1)) {
            q1.setSelected(true);
        }
        else if (quatris.equals(3) || quatris.equals(2)) {
            q2.setSelected(true);
        }

        if (nivell.equals(1)) init_rad.setSelected(true);
        else if (nivell.equals(2)) obli_rad.setSelected(true);
        else esp_rad.setSelected(true);

        if (projector_teo) yes_radio.setSelected(true);
        else no_radio.setSelected(true);

        if (carac_lab[0]) projector.setSelected(true);
        if (carac_lab[1]) ubuntu.setSelected(true);
        if (carac_lab[2]) LW.setSelected(true);
        if (carac_lab[3]) fisica.setSelected(true);
        if (carac_lab[4]) embeded.setSelected(true);
        if (carac_lab[5]) xarxes.setSelected(true);
    }

    /**
     * S'ha clicat el botó Crear, captura els valors dels camps d'entrada, els valida i els envia al controlador de domini.
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void save_values() throws IOException {
        ArrayList<Boolean> errors = new ArrayList<Boolean>();
        for (Integer i = 0; i < 5; i++) {
            errors.add(false);
        }
        // String error_text = new String(); // en cas d'uitlitzar finestra d'errors
        String name = name_input.getText();
        if (name == null || name.isEmpty()) {
            errors.set(0, true);
        }
        // TODO: comprovar si ja existeix l'assig amb aquell nom
        else if (actual_mode == 2 && !assig.getName().equals(name) && ctrlPresentacio.exists_AssigConcreta(name)) {
            errors.set(0, true);
        }
        else if(actual_mode == 0) {
            errors.set(0, ctrlPresentacio.exists_AssigConcreta(name));
        }
        setLabelColor(name_label, errors, 0);

        //quatri
        if (!q1.isSelected() && !q2.isSelected()) {
            errors.set(1, true);
        }
        setLabelColor(quatri_label, errors, 1);

        // nivell
        if (nivell_group.getSelectedToggle() == null) {
            errors.set(2, true);
        }
        setLabelColor(nivell_label, errors, 2);

        // projector teoria
        if (projector_group.getSelectedToggle() == null) {
            errors.set(3, true);
        }
        setLabelColor(teo_label, errors, 3);

        ArrayList<Boolean> carac = new ArrayList<Boolean>();
        carac.add(projector.isSelected());
        carac.add(ubuntu.isSelected());
        carac.add(LW.isSelected());
        carac.add(fisica.isSelected());
        carac.add(embeded.isSelected());
        carac.add(xarxes.isSelected());
        if (!carac.contains(true)) errors.set(4, true);
        setLabelColor(lab_label, errors, 4);

        if (!errors.contains(true)) {
            boolean projector_teo;
            if (no_radio.isSelected()) projector_teo = false;
            else projector_teo = true;

            int quatri;
            if (q1.isSelected() && q2.isSelected()) quatri = 3;
            else if (q1.isSelected()) quatri = 1;
            else quatri = 2;

            int nivell;
            RadioButton nivell_btn = (RadioButton) nivell_group.getSelectedToggle();
            String nivell_selected = nivell_btn.getText();
            if (nivell_selected.equals("Inicial"))
                nivell = 1;
            else if (nivell_selected.equals("Obligatoria"))
                nivell = 2;
            else nivell = 3;

            Boolean[] carac_lab = new Boolean[6];
            for (int i = 0; i < carac.size(); i++) {
                carac_lab[i] = carac.get(i);
            }

            if (actual_mode == 0) ctrlPresentacio.save_AssigNew(name, quatri, nivell, projector_teo, carac_lab);
            else ctrlPresentacio.save_AssigConcreta(assig.getName(), name, quatri, nivell, projector_teo, carac_lab);
            ctrlPresentacio.showAssignatures();
        }
        // else something like introdueix els camps remanents
    }

    /**
     * Si hi ha un error canvia el color de l'etiqueta a vermell, sinó el posa negre.
     * @param label etiqueta a modificar
     * @param error on consultar error
     * @param i posicio a consultar
     */
    private void setLabelColor (Label label, ArrayList<Boolean> error, int i) {
        if (error.get(i)) label.setTextFill(Color.RED);
        else label.setTextFill(Color.BLACK);
    }

}
