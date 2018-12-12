package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class ViewAssigConsultar {
    //@FXML private Label name_label, quatri_label, teo_label, lab_label, nivell_label;
    @FXML private Label name_output, quatri_output, teo_output, lab_output, nivell_output;
    @FXML private Button tornar, modificar;

    private CtrlPresentacio ctrlPresentacio;

    public void setViewController (CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }
    @FXML
    public void init_labels() {
        // TODO: demanar dades a la capa de domini
        name_output.setText("el que digui domini");

        String quatri;
        int q = 1; // pillar de domini
        if(q == 1) quatri = "Q1";
        else if (q == 2) quatri ="Q2";
        else quatri = "Q1 & Q2";
        quatri_output.setText(quatri);

        String nivell;
        int n = 1; // pillar de domini
        if(n == 1) nivell = "Inicial";
        else if (n == 2) nivell ="Troncal";
        else nivell = "Especialitat";
        nivell_output.setText(nivell);

        boolean tmp = false; // pillar de domini i pot desapareixer aquest boolean tmp
        if(tmp) teo_output.setText("Sí");
        else teo_output.setText("No");

        // suposo que domini em retorna un array de bools
        boolean tmp_array[] = {true, false, true, false, true, false};
        String lab = "";
        if (tmp_array[0]) lab += "Projector\n";
        if (tmp_array[1]) lab += "Ubuntu\n";
        if (tmp_array[2]) lab += "Linux/Windows\n";
        if (tmp_array[3]) lab += "Física\n";
        if (tmp_array[4]) lab += "Embeded\n";
        if (tmp_array[5]) lab += "Xarxes\n";
        //lab_output.setWrapText(true);
        lab_output.setText(lab);


    }

    /**
     * El botó Tornar s'ha clicat.
     * @throws IOException excepció d'entrada/sortida.
     */
    @FXML
    public void onTornar_pressed() throws IOException {
        ctrlPresentacio.showAssignatures();
    }

    /**
     * El botó modificar s'ha clicat.
     * @throws IOException excepció d'entrada/sortida.
     */
    @FXML
    public void onModificar_pressed() throws IOException {
        //ctrlPresentacio.showAssigMod();
    }




}
