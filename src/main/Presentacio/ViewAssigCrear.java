package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.io.IOException;

public class ViewAssigCrear {
    @FXML private Button tornar, crear;
    @FXML private Label name_label, quatri_label, teo_label;
    @FXML private TextField name_input;
    //@FXML private RadioButton yes_radio, no_radio;
    @FXML private ToggleGroup quatri_group, projector_group;
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
        ctrlPresentacio.showAssignatures();
    }

    /**
     * S'ha clicat el botó Crear.
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void onCrear_pressed() throws IOException {
        //ctrlPresentacio.showPlaView();
        boolean errors = false;
        // String error_text = new String(); // en cas d'uitlitzar finestra d'errors
        if (name_input.getText() == null || name_input.getText().isEmpty()) {
            errors = true;
            name_label.setTextFill(Color.RED);
        }

        //name_input.appendText("crear pressed");

        // quatris
        if (quatri_group.getSelectedToggle() == null) {
            errors = true;
            quatri_label.setTextFill(Color.RED);
        }

        // projector teoria
        if (projector_group.getSelectedToggle() == null) {
            errors = true;
            teo_label.setTextFill(Color.RED);
        }
/*
        boolean lab[] = new boolean[6];
        for (int i = 0; i < 6; i++) {

        }*/
        if (!errors) {
            String name = name_input.getText();

            boolean projector_teo;
            if (projector_group.getSelectedToggle().getUserData().toString().equals("No"))
                projector_teo = false;

            else
                projector_teo = true;

            int quatri;
            if (quatri_group.getSelectedToggle().getUserData().toString().equals("Q1"))
                quatri = 1;
            else
                quatri = 2;



        }
    }


}

