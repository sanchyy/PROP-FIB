package main.Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import main.Domini.Pair;

import java.io.IOException;
import java.util.ArrayList;

public class ViewAulaConcreta {
    @FXML private Button tornar, mode_btn;
    @FXML private Label title_label, description_label, name_label, capacity_label, carac_label;
    @FXML private TextField name_input, capacity_input;
    @FXML private CheckBox projector, ubuntu, LW, fisica, embeded, xarxes;

    private CtrlPresentacio ctrlPresentacio;
    private int actual_mode = 0;

    /**
     * Assignar controlador de presentació.
     *
     * @param ctrlPresentacio el controlador de la capa de presentació.
     */
    public void setViewController(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    @FXML
    public void init_Mod (boolean pre_consultar) throws IOException {
        title_label.setText("MODIFICAR AULA");
        description_label.setText("Pots modificar els següents camps:");
        if (pre_consultar) init_properties(true);
        else load_values(new Aula_presentacio());
        mode_btn.setText("Guardar canvis");
        actual_mode = 2;
    }

    /**
     * Inicialitzar els atributs de l'assignatura i modificar el títol a consultar i el botó específic a "Modificar"
     */
    @FXML
    public void init_Consultar (Aula_presentacio aula) {
        title_label.setText("CONSULTAR AULA");
        description_label.setText("Conté la següent informació:");
        load_values(aula);
        init_properties(false);
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

        capacity_input.setEditable(editable);
        capacity_input.setMouseTransparent(!editable);
        capacity_input.setFocusTraversable(editable);

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
        ctrlPresentacio.showAules();
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
     * S'ha clicat el botó Crear, captura els valors dels camps d'entrada, els valida i els envia al controlador de domini.
     *
     * @throws NumberFormatException  excepció d'input no numéric en el camp capacitat.
     *  @throws IOException excepció d'entrada/sortida.
     */
    private void save_values () throws NumberFormatException, IOException {
        ArrayList<Boolean> errors = new ArrayList<Boolean>();
        for (Integer i = 0; i < 3; i++) {
            errors.add(false);
        }
        String error_text = new String(); // en cas d'uitlitzar finestra d'errors
        if (name_input.getText() == null || name_input.getText().isEmpty()) {
            errors.set(0, true);
        }
        // TODO: comprovar si ja existeix l'assig amb aquell nom
        //else errors.set(0, ctrlPresentacio.exists_AulaConcreta(name_input.getText()));
        setLabelColor(name_label, errors, 0);

        if (capacity_input.getText() == null || capacity_input.getText().isEmpty()) {
            errors.set(1, true);
            error_text += "Introdueix la capacitat de l'aula. \n";
        }
        else if (Integer.parseInt(capacity_input.getText()) <= 0) {
            errors.set(1, true);
            error_text += "Introdueix un valor vàlid (> 0) per la capacitat. \n ";
        }
        // TODO: pillar number format error i posar en vermell etiqueta
        setLabelColor(capacity_label, errors, 1);

        ArrayList<Boolean> carac = new ArrayList<Boolean>();
        carac.add(projector.isSelected());
        carac.add(ubuntu.isSelected());
        carac.add(LW.isSelected());
        carac.add(fisica.isSelected());
        carac.add(embeded.isSelected());
        carac.add(xarxes.isSelected());

        if (!carac.contains(true)) errors.set(2, true);
        setLabelColor(carac_label, errors, 2);

        if (!errors.contains(true)) {
            String name = name_input.getText();

            Integer capacity = Integer.parseInt(capacity_input.getText());

            // TODO: passar tot a domini + carac[]
            //ctrlPresentacio.save_AulaConcreta(name, capacity, carac);
            // maybe posar finestra no bloquejant de que hsa creat correctament l'aula
            ctrlPresentacio.showAules();
        }

    }
    private void setLabelColor (Label l, ArrayList<Boolean> error, int i) {
        if (error.get(i)) l.setTextFill(Color.RED);
        else l.setTextFill(Color.BLACK);
    }

    /**
     * Carrega els valors dels atributs de l'assignatura seleccionada i els mostra.
     */
    private void load_values (Aula_presentacio aula) {
        // per name input, agafar
        String name = aula.getName();
        Integer capacitat = aula.getCapacity();
        Boolean[] carac_lab = aula.getCarac();

        name_input.setText(name);
        capacity_input.setText(capacitat.toString());

        if (carac_lab[0]) projector.setSelected(true);
        if (carac_lab[1]) ubuntu.setSelected(true);
        if (carac_lab[2]) LW.setSelected(true);
        if (carac_lab[3]) fisica.setSelected(true);
        if (carac_lab[4]) embeded.setSelected(true);
        if (carac_lab[5]) xarxes.setSelected(true);
    }
}
