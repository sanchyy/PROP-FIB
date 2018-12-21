package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;

public class ViewHorariModificar {
    @FXML private Label sessio_label, dia_label, hora_label;
    @FXML private ComboBox<String> sessio_combo, dia_combo, hora_combo;

    private ArrayList<String> sessions;
    private CtrlPresentacio ctrlPresentacio;
    private SingletonDialogs singletonDialogs = SingletonDialogs.getInstance();

    public void setViewController(CtrlPresentacio ctrlPresentacio) {
        this.ctrlPresentacio = ctrlPresentacio;
    }

    public void setSessions (ArrayList<String> sessions) {
        this.sessions = sessions;
    }

    public void init_modificacions () {
        sessio_combo.getItems().addAll(sessions);
    }
    public void onTornar_pressed() throws IOException {
        ctrlPresentacio.showGenerarH();
    }
    public void onAssignar_pressed() {
        String s = sessio_combo.getValue();
        System.out.println(s);
        ArrayList<Boolean> errors = new ArrayList<>();
        for (int i = 0; i < 3; i++) errors.add(false);
        if (s == null || !s.isEmpty()) {
            errors.set(0, true);
        }
        setLabelColor(sessio_label, errors, 0);

        if(ctrlPresentacio.restriccioModificar("xd", 1, 2)) {

        }

    }
    private void setLabelColor (Label l, ArrayList<Boolean> error, int i) {
        if (error.get(i)) l.setTextFill(Color.RED);
        else l.setTextFill(Color.BLACK);
    }
}
