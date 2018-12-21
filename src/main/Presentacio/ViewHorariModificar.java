package Presentacio;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<String> tmp = Arrays.asList("Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres");
        sessio_combo.getItems().addAll(sessions);
        dia_combo.getItems().addAll(tmp);
        List<String> tmp2 =Arrays.asList("8 - 9", "9 - 10", "10 - 11", "11 - 12", "12 - 13", "13 - 14", "14 - 15",
                "15 - 16", "16 - 17", "17 - 18", "18 - 19", "19 - 20");
        hora_combo.getItems().addAll(tmp2);
    }
    public void onTornar_pressed() throws IOException {
        ctrlPresentacio.showGenerarH();
    }
    public void onAssignar_pressed() {
        String s = sessio_combo.getValue();
        System.out.println(s);
        ArrayList<Boolean> errors = new ArrayList<>();
        for (int i = 0; i < 3; i++) errors.add(false);

        if (s == null || s.toString().isEmpty()) {
            errors.set(0, true);
        }
        setLabelColor(sessio_label, errors, 0);

        String dia = dia_combo.getValue();
        if (dia == null || dia.toString().isEmpty()) {
            errors.set(1, true);
        }
        setLabelColor(dia_label, errors, 1);

        String hora = hora_combo.getValue();
        if (hora == null || hora.toString().isEmpty()) {
            errors.set(2, true);
        }
        setLabelColor(hora_label, errors, 2);

        if (!errors.contains(true)) {
            System.out.println(dia);
            int d;
            if (dia.equals("Dilluns")) d = 0;
            else if (dia.equals("Dimarts")) d = 1;
            else if (dia.equals("Dimecres")) d = 2;
            else if (dia.equals("Dijous")) d = 3;
            else d = 4;

            int h;
            if (hora.equals("8 - 9")) h = 0;
            else if (hora.equals("9 - 10")) h = 1;
            else if (hora.equals("10 - 11")) h = 2;
            else if (hora.equals("11 - 12")) h = 3;
            else if (hora.equals("12 - 13")) h = 4;
            else if (hora.equals("13 - 14")) h = 5;
            else if (hora.equals("14 - 15")) h = 6;
            else if (hora.equals("15 - 16")) h = 7;
            else if (hora.equals("16 - 17")) h = 8;
            else if (hora.equals("17 - 18")) h = 9;
            else if (hora.equals("18 - 19")) h = 10;
            else if (hora.equals("19 - 20")) h = 11;

            if(ctrlPresentacio.restriccioModificar(s, 1, 2)) {
                singletonDialogs.display_confirmHorari();
            }
            else singletonDialogs.display_errorHorari();
        }

    }
    private void setLabelColor (Label l, ArrayList<Boolean> error, int i) {
        if (error.get(i)) l.setTextFill(Color.RED);
        else l.setTextFill(Color.BLACK);
    }
}
