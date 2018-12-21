package Presentacio;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;
import Domini.Pair;
import javafx.scene.layout.VBox;

public class ViewHorariMostrar {
    @FXML private GridPane horari_grid;
    @FXML private TextArea debug;
    @FXML private Label source;

    private CtrlPresentacio ctrlPresentacio;
    private boolean modified = false; // 0 crear, 1 consultar, 2 modificar
    private ArrayList<ArrayList<ArrayList<Pair<String, Integer>>>> horari;

    /**
     * Assignar controlador de presentació.
     *
     * @param ctrlPresentacio el controlador de la capa de presentació.
     */
    public void setViewController(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    public void setHorari(ArrayList<ArrayList<ArrayList<Pair<String, Integer>>>> items) {
        this.horari = items;
    }

    public void init_horari () {
        // TODO: per cada pla diferent, color diferent
        int ii, jj;
        ii = 1;
        for (ArrayList<ArrayList<Pair<String, Integer>>> i : horari) {
            jj = 1;
            for (ArrayList<Pair<String, Integer>> j : i) {
                VBox slot = new VBox();
                slot.setAlignment(Pos.TOP_CENTER);
                System.out.println(ii);
                System.out.println(jj);
                for (Pair<String, Integer> sessio : j) {
                    //Label l = new Label(sessio.getFirst());
                    slot.getChildren().add(new Label(sessio.getFirst()));
                }
                horari_grid.add(slot, ii, jj);
                jj++;
            }
            ii++;
        }
    }
    /**
     * S'ha clicat el botó Tornar.
     * @throws IOException excepcio d'entrada/sortida.
     */
    public void onTornar_pressed() throws IOException {
        ctrlPresentacio.showGenerarH();
    }

    public void onModRestric_pressed () {

    }

    public void onGuardar_pressed() {

    }


}
