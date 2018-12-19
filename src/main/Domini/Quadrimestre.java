package main.Domini;

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

    public Sessio getSessio(int i) {
        return sessions.get(i-1);
    }

    public void borrarSessio(Integer b) {
        sessions.remove(b-1);
    }
}
