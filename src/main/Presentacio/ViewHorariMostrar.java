package Presentacio;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;
import Domini.Pair;

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

    public void initialize () {
        // TODO: posar horari
        // horari = ctrlPresentacio.getHorari();
        ArrayList<Pair<String, Integer>> hores = new ArrayList<>();
        hores.add(new Pair<>("LP-12 A5203", 123));
        hores.add(new Pair<>("SO-14 A6102", 123));
        ArrayList<ArrayList<Pair<String, Integer>>> dia = new ArrayList<>();
        dia.add(hores);
        horari = new ArrayList<>();
        horari.add(dia);
        // TODO
        int ii, jj;
        ii = jj = 0;
        for (ArrayList<ArrayList<Pair<String, Integer>>> i : horari) {
            for (ArrayList<Pair<String, Integer>> j : i) {
                for (Pair<String, Integer> sessio : j) {
                    Label l = new Label(sessio.getFirst());
                    horari_grid.add(l, jj+1, ii+1);
                }
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

    public void init_drag () {
        source.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start a drag-and-drop gesture*/
                /* allow any transfer mode */
                Dragboard db = source.startDragAndDrop(TransferMode.MOVE);

                /* Put a string on a dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putString(source.getText());
                db.setContent(content);

                event.consume();
            }
        });
    }

}
