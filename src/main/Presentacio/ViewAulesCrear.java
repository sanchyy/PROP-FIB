package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;

public class ViewAulesCrear {
    @FXML private Button tornar, crear;
    @FXML private Label name_label, capacity_label, carac_label;
    @FXML private TextField name_input, capacity_input;
    @FXML private CheckBox projector, ubuntu, LW, fisica, embeded, xarxes;

    private CtrlPresentacio ctrlPresentacio;

    /**
     * Assignar controlador de presentació.
     *
     * @param ctrlPresentacio el controlador de la capa de presentació.
     */
    public void setViewController(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    // buttons
    /**
     * S'ha clicat el botó Tornar.
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void onTornar_pressed() throws IOException {
        ctrlPresentacio.showAules();
    }

    /**
    * S'ha clicat el botó Crear, captura els valors dels camps d'entrada, els valida i els envia al controlador de domini.
    *
    * @throws NumberFormatException  excepció d'input no numéric en el camp capacitat.
     *  @throws IOException excepció d'entrada/sortida.
    */
    public void onCrear_pressed () throws NumberFormatException, IOException {
        ArrayList<Boolean> errors = new ArrayList<Boolean>();
        for (Integer i = 0; i < 3; i++) {
            errors.add(false);
        }
        String error_text = new String(); // en cas d'uitlitzar finestra d'errors
        if (name_input.getText() == null || name_input.getText().isEmpty()) {
            errors.set(0, true);
        }
        // TODO: comprovar si ja existeix l'assig amb aquell nom
        setLabelColor(name_label, errors, 0);

        if (capacity_input.getText() == null || capacity_input.getText().isEmpty()) {
            errors.set(1, true);
            error_text += "Introdueix la capacitat de l'aula. \n";
        }
        else if (Integer.parseInt(capacity_input.getText()) <= 0) {
            errors.set(1, true);
            error_text += "Introdueix un valor vàlid (> 0) per la capacitat. \n ";
        }
        setLabelColor(capacity_label, errors, 1);

        /*Boolean carac[] = new Boolean[6];
        carac[0] = projector.isSelected();
        carac[1] = ubuntu.isSelected();
        carac[2] = LW.isSelected();
        carac[3] = fisica.isSelected();
        carac[4] = embeded.isSelected();
        carac[5] = xarxes.isSelected();
        Boolean some_carac_selected = false;
        for (Integer i = 0; i < 6 && (!some_carac_selected); i++) {
            if (carac[i]) some_carac_selected = true;
        }*/
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
            // maybe posar finestra no bloquejant de que hsa creat correctament l'aula
            ctrlPresentacio.showAules();
        }

    }
    private void setLabelColor (Label l, ArrayList<Boolean> error, int i) {
        if (error.get(i)) l.setTextFill(Color.RED);
        else l.setTextFill(Color.BLACK);
    }
}
