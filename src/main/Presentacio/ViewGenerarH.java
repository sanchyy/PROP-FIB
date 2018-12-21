package Presentacio;

import Domini.Pair;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewGenerarH {
    @FXML private Button crearHorari;
    @FXML private TextArea debbuging;
    @FXML private Label pla_label, aules_label;
    @FXML private GridPane pla_grid, aules_grid;

    //private List<RadioButton> plans_list;
    private List<CheckBox> plans_list;
    private List<CheckBox> aules_list;

    private CtrlPresentacio ctrlPresentacio;

    /**
     * Assignar controlador de presentació.
     *
     * @param ctrlPresentacio el controlador de la capa de presentació.
     */
    public void setViewController(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    public void init_scrolls () {
        plans_list = new ArrayList<>();
        //final ToggleGroup pla_group = new ToggleGroup();

        int i = 0;

        for (Pla_presentacio p : ctrlPresentacio.getPlaData()) {
            CheckBox tmp = new CheckBox(p.getName());
            plans_list.add(tmp);
            pla_grid.add(tmp, i%3, i/3);
            i++;
        }

        aules_list = new ArrayList<>();
        i = 0;
        for (Aula_presentacio a : ctrlPresentacio.getAulaData()) {
            CheckBox tmp = new CheckBox(a.getName());
            aules_list.add(tmp);
            aules_grid.add(tmp, i%3, i/3);
            i++;
        }
    }
    /**
     * S'ha clicat el botó Crear horari.
     * @throws IOException
     */
    @FXML
    public void onafegirRestriccions_pressed () throws IOException {
        ArrayList<Boolean> errors = new ArrayList<>();
        errors.add(true);
        errors.add(true);
        String pla_selected = null;

        for (int i = 0; i < plans_list.size(); i++) {
            CheckBox ca = plans_list.get(i);
            if (ca.isSelected()) {
                if (errors.get(0)) errors.set(0, false);
                pla_selected = ca.getText();
            }
        }
        setLabelColor(pla_label, errors, 0);
        ArrayList<String> aules_selected = new ArrayList<>();
        for (CheckBox ca : aules_list) {
            if (ca.isSelected()){
                if (errors.get(1)) errors.set(1, false);
                aules_selected.add(ca.getText());
            }
        }
        setLabelColor(aules_label, errors, 1);

        if (!errors.contains(true)) {
            ctrlPresentacio.send_inputHorari(pla_selected, aules_selected);
            ctrlPresentacio.showHorariSessions();
        }
    }


    private void setLabelColor (Label label, ArrayList<Boolean> error, int i) {
        if (error.get(i)) label.setTextFill(Color.RED);
        else label.setTextFill(Color.BLACK);
    }
}
