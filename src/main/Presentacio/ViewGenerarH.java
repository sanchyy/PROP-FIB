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

        pla_grid.add(new CheckBox("FIB"), 0, 0);

        int i = 0;

        for (Pla_presentacio p : ctrlPresentacio.getPlaData()) {
            /*RadioButton radio = new RadioButton(p.getName());
            radio.setToggleGroup(pla_group);
            plans_list.add(new RadioButton(p.getName()));
            pla_grid.add(new RadioButton(p.getName()), i%3, i/3);
*/
            CheckBox tmp = new CheckBox(p.getName());
            plans_list.add(i, tmp);
            //plans_list.add(new CheckBox(p.getName()));
            pla_grid.add(new CheckBox(p.getName()), i%3, i/3);
            i++;
        }

        aules_list = new ArrayList<>();
        i = 0;
        for (Aula_presentacio a : ctrlPresentacio.getAulaData()) {
            CheckBox tmp = new CheckBox(a.getName());
            aules_list.add(i, tmp);
            //aules_list.add(new CheckBox(a.getName()));
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
        errors.add(true);
        errors.add(true);
        String pla_selected = "xd";
        /*final ToggleGroup pla_group = plans_list.get(0).getToggleGroup();
        if (pla_group.getSelectedToggle() == null) errors.set(0, true);
        setLabelColor(pla_label, errors, 0);*/
        /*for (CheckBox ca : plans_list) {
            debbuging.appendText("entro for");
            if (ca.isSelected()) {
                debbuging.appendText("1");
                if (errors.get(0)) errors.set(0, false);
                //aules_selected.add(ca.getUserData().toString());
                pla_selected = ca.getUserData().toString();
                debbuging.appendText(ca.getUserData().toString());
            }
        }*/
        for (int i = 0; i < plans_list.size(); i++) {
            for (int j = 0; j < 3; j++) {
                CheckBox ca = plans_list.get(i*3+j);
                if (ca.isSelected()) {
                    debbuging.appendText("1");
                    if (errors.get(0)) errors.set(0, false);
                    //aules_selected.add(ca.getUserData().toString());
                    pla_selected = ca.getUserData().toString();
                    debbuging.appendText(ca.getUserData().toString());
                }
            }
        }
        setLabelColor(pla_label, errors, 0);
        ArrayList<String> aules_selected = new ArrayList<>();
        debbuging.appendText("pre");
        for (CheckBox ca : aules_list) {
            debbuging.appendText("entro for2");
            if (ca.isSelected()){
                if (errors.get(1)) errors.set(1, false);
                aules_selected.add(ca.getUserData().toString());
                System.out.println(ca.getUserData().toString());
            }
        }
        setLabelColor(aules_label, errors, 1);
        if (!errors.contains(true)) {
            //pla_selected = pla_group.getSelectedToggle().toString();

            ctrlPresentacio.send_inputHorari(pla_selected, aules_selected);
            ctrlPresentacio.showHorariMostrar();
        }
    }


    private void setLabelColor (Label label, ArrayList<Boolean> error, int i) {
        if (error.get(i)) label.setTextFill(Color.RED);
        else label.setTextFill(Color.BLACK);
    }
}
