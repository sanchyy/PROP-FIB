package Domini;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CjtRestriccions {
    private ArrayList<RestriccioSolapar>   rs;
    private ArrayList<RestriccioJornada>   rj;
    private ArrayList<RestriccioReserva>   rr;
    private ArrayList<RestriccioAssigTemp> ra;
    private ArrayList<RestriccioCaracteristicaAula> rca;

    public CjtRestriccions() {
        this.rs = new ArrayList<>();
        this.rj = new ArrayList<>();
        this.rr = new ArrayList<>();
        this.ra = new ArrayList<>();
        this.rca = new ArrayList<>();
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

    public void addRestriccioCaracteristicaAula(RestriccioCaracteristicaAula r) {
        this.rca.add(r);
    }

    public boolean comprovarRestriccionsColocar(Sessio actual, ArrayList<Sessio> sessions, Horari horari) {
        boolean compleix = true;
        for (RestriccioSolapar r : rs) {
            compleix = compleix && r.compleixRestriccio(actual, sessions, horari);
            if (!compleix) return false;
        }
        return true;
    }

    public boolean comprovarRestriccionsAula(Sessio actual, Aula aula) {
        boolean compleix = true;
        for (RestriccioCaracteristicaAula r : rca) {
            compleix = compleix && r.compleixRestriccio(actual, aula);
            if (!compleix) return false;
        }
        return true;
    }
}
