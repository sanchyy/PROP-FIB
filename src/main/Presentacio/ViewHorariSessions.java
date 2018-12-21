package Presentacio;

import Domini.Pair;
import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ViewHorariSessions {
    @FXML private GridPane sessions_grid;

    private CtrlPresentacio ctrlPresentacio;
    private List<Label> assig_list;
    private List<TextField> text_list;

    public void setViewController (CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    public void init_table(String name) {
        assig_list = new ArrayList<>();
        text_list = new ArrayList<>();
        int i = 1;
        for (String a : ctrlPresentacio.getAssigPla(name)) {
            Label tmp = new Label(a);
            System.out.println(tmp.getText());
            assig_list.add(tmp);
            sessions_grid.add(tmp, 0, i);
            TextField grups = new TextField();
            grups.setPrefWidth(20);
            TextField subgrups = new TextField();
            subgrups.setPrefWidth(20);
            TextField tardes = new TextField();
            tardes.setPrefWidth(20);
            sessions_grid.add(grups, 1, i);
            sessions_grid.add(subgrups, 2, i);
            sessions_grid.add(tardes, 3, i);
            text_list.add(grups);
            text_list.add(subgrups);
            text_list.add(tardes);
            i++;
        }
    }

    public void onCrear_pressed() throws NumberFormatException {
        ArrayList<Boolean> errors = new ArrayList<>();
        ArrayList<Pair<String, Pair<Integer, Pair<Integer, Integer>>>> sessions = new ArrayList<>();
        for(int i = 0; i < assig_list.size(); i++) {
            Integer g, s, t;
            g = Integer.parseInt(text_list.get(i*3).getText());
            s = Integer.parseInt(text_list.get(i*3 + 1).getText());
            t = Integer.parseInt(text_list.get(i*3 + 2).getText());
            Pair<Integer, Integer> tmp = new Pair(s,t);
            Pair<Integer, Pair<Integer, Integer>> tmp2 = new Pair(g, tmp);
            Pair<String, Pair<Integer, Pair<Integer, Integer>>> tmp3 = new Pair(assig_list.get(i).getText(), tmp2);
            sessions.add(tmp3);
            if (g < 0 || s < 0 || t < 0) errors.add(true);
            if (g < 0 || s < 0 || t < 0) errors.add(true);
            else errors.add(false);

        }
        if (errors.contains(true)) {
            for (int i = 0; i < errors.size(); i++)
                setLabelColor(assig_list.get(i), errors, i);
        } else {
            try {
                ArrayList<ArrayList<ArrayList<Pair<String, Integer>>>> items = ctrlPresentacio.send_sessionsHorari(sessions);
                ctrlPresentacio.showHorariMostrar(items);
            } catch(IOException ex) {}
        }
    }

    private void setLabelColor (Label l, ArrayList<Boolean> error, int i) {
        if (error.get(i)) l.setTextFill(Color.RED);
        else l.setTextFill(Color.BLACK);
    }

    public void onTornar_pressed () throws IOException {
        ctrlPresentacio.showGenerarH();
    }
}
