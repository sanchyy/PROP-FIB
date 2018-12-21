package Presentacio;

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
    @FXML private ToggleGroup pla_group;
    private CtrlPresentacio ctrlPresentacio;
    @FXML private List<RadioButton> plans_list;
    @FXML private List<CheckBox> aules_list;

    /**
     * Assignar controlador de presentació.
     *
     * @param ctrlPresentacio el controlador de la capa de presentació.
     */
    public void setViewController(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    public void initialize () {
        System.out.println(ctrlPresentacio.prova());
        plans_list = new ArrayList<>();
        pla_group = new ToggleGroup();
        int i = 0;
        for (Pla_presentacio p : ctrlPresentacio.getPlaData()) {
            plans_list.add(new RadioButton(p.getName()));
            pla_grid.add(new CheckBox(p.getName()), i%3, i/3);
            i++;
        }

        aules_list = new ArrayList<>();
        i = 0;
        for (Aula_presentacio a : ctrlPresentacio.getAulaData()) {
            aules_list.add(new CheckBox(a.getName()));
            aules_grid.add(new CheckBox(a.getName()), i%3, i/3);
            i++;
        }
    }
    /**
     * S'ha clicat el botó Crear horari.
     * @throws IOException
     */
    @FXML
    public void oncrearHorari_pressed () throws IOException {
        ArrayList<Boolean> errors = new ArrayList<>();
        errors.add(false);
        errors.add(false);
        String pla_selected;
        if (pla_group.getSelectedToggle() == null) errors.set(0, true);
        setLabelColor(pla_label, errors, 0);

        ArrayList<String> aules_selected = new ArrayList<>();
        for (CheckBox ca : aules_list) {
            if (ca.isSelected()){
                if (!errors.get(1)) errors.set(1, true);
                aules_selected.add(ca.getUserData().toString());
                System.out.println(ca.getUserData().toString());
            }
        }
        setLabelColor(aules_label, errors, 1);
        if (!errors.contains(true)) {
            pla_selected = pla_group.getSelectedToggle().toString();
            ctrlPresentacio.send_inputHorari(pla_selected, aules_selected);
            ctrlPresentacio.showHorariMostrar();
        }
    }

    /**
     * S'ha clicat el botó Tornar.
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void onTornar_pressed() throws IOException {
        ctrlPresentacio.showPlaEstudis();
    }

    private void setLabelColor (Label label, ArrayList<Boolean> error, int i) {
        if (error.get(i)) label.setTextFill(Color.RED);
        else label.setTextFill(Color.BLACK);
    }
}
