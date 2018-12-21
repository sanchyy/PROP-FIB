package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewPlaAssig {
    @FXML private Button tornar, crear;
    @FXML private GridPane assig_grid;
    @FXML private Label assig_label, description_label;

    private CtrlPresentacio ctrlPresentacio;
    private List<CheckBox> assig_list;
    private Pla_presentacio pla;
    public void setViewController(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    public void onTornar_pressed () throws IOException {
        ctrlPresentacio.showPlaEstudis();
    }

    public void setPla(Pla_presentacio pla) {
        this.pla = pla;
    }

    public void init_pla () {
        // TODO: demanar llista d'aules
        assig_list = new ArrayList<>();
        //List<Aula_presentacio> assig_lliures = ctrlPresentacio.getAulesLliures();
        int i = 0;
        for (String a : ctrlPresentacio.getAulesLliures()) {
            CheckBox tmp = new CheckBox(a);
            assig_list.add(tmp);
            assig_grid.add(tmp, i%4, i/4);
            i++;
        }
    }

    public void onAssignar_pressed() throws IOException {
        ArrayList<String> assig_selected = new ArrayList<>();
        Boolean error = true;
        for (CheckBox c : assig_list) {
            if (c.isSelected()){
                if (error) error = false;
                assig_selected.add(c.getText());
            }
        }
        if (error) description_label.setTextFill(Color.RED);
        else {
            description_label.setTextFill(Color.BLACK);
            ctrlPresentacio.send_AssigPla(pla.getName(), assig_selected);
            ctrlPresentacio.showPlaEstudis();
        }

    }

}
