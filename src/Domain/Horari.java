package Domain;

import java.util.ArrayList;


public class Horari {
    private ArrayList<ArrayList<ArrayList<String>>> slot_horari;

    // constructora
    public Horari (ArrayList<ArrayList<ArrayList<String>>> slot_horari) {
        this.slot_horari = slot_horari;
    }

    public Horari () {
        this.slot_horari = null;
    }

    // Setter
    public void setSlot_horari(ArrayList<ArrayList<ArrayList<String>>> slot_horari) {
        this.slot_horari = slot_horari;
    }

    // Getter
    public ArrayList<ArrayList<ArrayList<String>>> getSlot_horari () {
        return this.slot_horari;
    }

}
