package Domini;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CjtRestriccions {
    private ArrayList<RestriccioSolapar>   rs;
    private ArrayList<RestriccioJornada>   rj;
    private ArrayList<RestriccioReserva>   rr;
    private ArrayList<RestriccioAssigTemp> ra;

    public CjtRestriccions() {
        this.rs = new ArrayList<>();
        this.rj = new ArrayList<>();
        this.rr = new ArrayList<>();
        this.ra = new ArrayList<>();
    }

    public ArrayList<RestriccioAssigTemp> getRa() {
        return ra;
    }

    public ArrayList<RestriccioJornada> getRj() {
        return rj;
    }

    public ArrayList<RestriccioReserva> getRr() {
        return rr;
    }

    public ArrayList<RestriccioSolapar> getRs() {
        return rs;
    }

    public void addRestriccioAssigTemp(RestriccioAssigTemp r) {
        this.ra.add(r);
    }

    public void addRestriccioJornada(RestriccioJornada r) {
        this.rj.add(r);
    }

    public void addRestriccioReserva(RestriccioReserva r) {
        this.rr.add(r);
    }

    public void addRestriccioSolapar(RestriccioSolapar r) {
        this.rs.add(r);
    }

    public boolean comprovarRestriccions(Sessio actual, ArrayList<Sessio> sessions, Horari horari) {
        boolean compleix = true;
        for (RestriccioSolapar r : rs) {
            compleix = compleix && r.compleixRestriccio(actual, sessions, horari);
            if (!compleix) return false;
        }
        return true;
    }
}
