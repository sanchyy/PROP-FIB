package main.Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ViewAssigMod {
    @FXML private Button tornar, modificar;
    @FXML private Label name_label, quatri_label, teo_label, nivell_label;
    @FXML private TextField name_input;
    @FXML private RadioButton yes_radio, no_radio;
    @FXML private ToggleGroup projector_group, nivell_group;
    @FXML private CheckBox projector, ubuntu, LW, fisica, embeded, xarxes, q1, q2;
    @FXML private RadioButton inicial, obligatoria, especialitat;

    private CtrlPresentacio ctrlPresentacio;
    private String name_before;

    /**
     * Assignar controlador de presentació.
     *
     * @param ctrlPresentacio el controlador de la capa de presentació.
     */
    public void setViewController(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

   /* public void inicialitzar () {
        // TODO: agafar dades, demanar a domini
        // per name input, agafar
        String name = name_before; // agafar nom, demanar domini 
        name_input.setPromptText(name);

        Integer quatris = 1; // agafar quatris
        if (quatris.equals(3) || quatris.equals(1)) {
            q1.setSelected(true);
        }
        else if (quatris.equals(3) || quatris.equals(2)) {
            q2.setSelected(true);
        }

        Integer nivell = 1; // agafar nivell
        if (nivell.equals(1)) inicial.setSelected(true);
        else if (nivell.equals(2)) obligatoria.setSelected(true);
        else especialitat.setSelected(true);

        boolean projector_teo = true; // agafar carac teo
        if (projector_teo) yes_radio.setSelected(true);
        else no_radio.setSelected(true);

        Boolean carac_lab[] = {true, false, false, true, false, false}; // agafar carac lab
        if (carac_lab[0]) projector.setSelected(true);
        if (carac_lab[1]) ubuntu.setSelected(true);
        if (carac_lab[2]) LW.setSelected(true);
        if (carac_lab[3]) fisica.setSelected(true);
        if (carac_lab[4]) embeded.setSelected(true);
        if (carac_lab[5]) xarxes.setSelected(true);

    }*/

    // buttons
    /**
     * S'ha clicat el botó Tornar.
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void onTornar_pressed() throws IOException {
        ctrlPresentacio.showAssignatures();
    }

    /**
     * S'ha clicat el botó Crear, captura els valors dels camps d'entrada, els valida i els envia a la capa de Domini.
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void onModificar_pressed() throws IOException {
        /*ArrayList<Boolean> errors = new ArrayList<Boolean>();
        for (Integer i = 0; i < 4; i++) {
            errors.add(false);
        }
        // String error_text = new String(); // en cas d'uitlitzar finestra d'errors
        if (name_input.getText() == null || name_input.getText().isEmpty()) {
            errors.set(0, true);
        }
        else if (name_before != name_input.getText()) {
            // TODO: comprovar si ja existeix l'assig amb aquell nom
            // si ja existia errors.set(0, true);    
        }
        // TODO: comprovar si ja existeix l'assig amb aquell nom
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

        if (!errors.contains(true)) {
            String name = name_input.getText();

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

            Boolean lab_carac[] = new Boolean[6];
            lab_carac[0] = projector.isSelected();
            lab_carac[1] = ubuntu.isSelected();
            lab_carac[2] = LW.isSelected();
            lab_carac[3] = fisica.isSelected();
            lab_carac[4] = embeded.isSelected();
            lab_carac[5] = xarxes.isSelected();

            // TODO: passar tot la domini
            // maybe posar finestra no bloquejant de que hsa creat correctament l'assignatura
            ctrlPresentacio.showAssignatures();
        }*/
        // else something like introdueix els camps remanents
    }

    private void setLabelColor (Label l, ArrayList<Boolean> error, int i) {
        if (error.get(i)) l.setTextFill(Color.RED);
        else l.setTextFill(Color.BLACK);
    }


}

