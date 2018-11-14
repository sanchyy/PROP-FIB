package Domini;

import java.util.ArrayList;

public class Quadrimestre {

    // private Periode periode;
    private ArrayList<Sessio> sessions;

    //Constructora
    public Quadrimestre() {
        // this.periode = null;
        this.sessions = new ArrayList<>();
    }

    public ArrayList<Sessio> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<Sessio> sessions) {
        this.sessions = sessions;
    }

    public void afegirSessio(Sessio sessio) {
        this.sessions.add(sessio);
    }
}
