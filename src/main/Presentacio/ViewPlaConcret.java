package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;

public class ViewPlaConcret {
    @FXML private Button tornar, mode_btn;
    @FXML private TextField name_input;
    @FXML private Label title_label, description_label, name_label, assig_label;


    private CtrlPresentacio ctrlPresentacio;
    private int actual_mode = 0;
    private Pla_presentacio pla;

    public void setViewController (CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    public void setPla (Pla_presentacio pla) {
        this.pla = pla;
    }
    @FXML
    public void init_Mod (boolean pre_consultar) throws IOException {
        title_label.setText("MODIFICAR PLA D'ESTUDIS");
        description_label.setText("Pots modificar els següents camps:");
        if (pre_consultar) init_properties(true);
        else load_values();
        mode_btn.setText("Guardar canvis");
        actual_mode = 2;
    }

    /**
     * Inicialitzar els atributs de l'assignatura i modificar el títol a consultar i el botó específic a "Modificar"
     */
    @FXML
    public void init_Consultar () {
        title_label.setText("CONSULTAR PLA D'ESTUDIS");
        description_label.setText("Conté la següent informació:");
        load_values();
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
    }

    /**
     * S'ha clicat el botó Tornar.
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void onTornar_pressed() throws IOException {
        ctrlPresentacio.showPlaEstudis();
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
        for (Integer i = 0; i < 1; i++) {
            errors.add(false);
        }
        String error_text = new String(); // en cas d'uitlitzar finestra d'errors
        String name = name_input.getText();
        if (name == null || name.isEmpty()) {
            errors.set(0, true);
        }
        // TODO: comprovar si ja existeix l'assig amb aquell nom
        else if (actual_mode == 2 && !pla.getName().equals(name) && ctrlPresentacio.exists_PlaConcret(name)) {
            errors.set(0, true);
        }
        else if(actual_mode == 0) {
            errors.set(0, ctrlPresentacio.exists_PlaConcret(name));
        }
        //else errors.set(0, ctrlPresentacio.exists_PlaConcret(name));
        setLabelColor(name_label, errors, 0);

        if (!errors.contains(true)) {
            // TODO: passar tot a domini + carac[]
            if (actual_mode == 0) ctrlPresentacio.save_PlaNew(name);
            else ctrlPresentacio.save_PlaConcret(pla.getName(), name);

            ctrlPresentacio.showPlaEstudis();
        }

    }
    private void setLabelColor (Label l, ArrayList<Boolean> error, int i) {
        if (error.get(i)) l.setTextFill(Color.RED);
        else l.setTextFill(Color.BLACK);
    }

    /**
     * Carrega els valors dels atributs de l'assignatura seleccionada i els mostra.
     */
    private void load_values () {
        String name = pla.getName(); // agafar nom, demanar domini
        name_input.setText(name);
    }


}
