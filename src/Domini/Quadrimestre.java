package Domini;

import java.util.ArrayList;

// Berni
public class Quadrimestre {
    private Periode periode;
    private ArrayList<Sessio> sessions;

    //Constructora
    public Quadrimestre() {
        this.periode = null;
        this.sessions = new ArrayList<>();
    }

    public Periode getPeriode() {
        return periode;
    }

    public ArrayList<Sessio> getSessions() {
        return sessions;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public void setSessions(ArrayList<Sessio> sessions) {
        this.sessions = sessions;
    }
}
