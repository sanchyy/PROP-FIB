package Domini;

import java.util.ArrayList;

public class Quadrimestre {

    private ArrayList<Sessio> sessions;

    //Constructora
    public Quadrimestre() {
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
