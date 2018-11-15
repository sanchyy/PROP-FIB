package Domini;

import java.util.ArrayList;

public class CjtRestriccions {

    private ArrayList<RestriccioSolapar> rs;
    private ArrayList<RestriccioReserva> rr;
    private ArrayList<RestriccioAssigTemp> ra;
    private ArrayList<RestriccioMatins> rm;
    private ArrayList<RestriccioTardes> rt;
    private ArrayList<RestriccioCaracteristicaAula> rca;
    private ArrayList<RestriccioNivell> rn;
    private ArrayList<RestriccioCorrequisit> rc;

    public CjtRestriccions() {
        this.rs  = new ArrayList<>();
        this.rr  = new ArrayList<>();
        this.ra  = new ArrayList<>();
        this.rm  = new ArrayList<>();
        this.rt  = new ArrayList<>();
        this.rca = new ArrayList<>();
        this.rn  = new ArrayList<>();
        this.rc  = new ArrayList<>();
    }

    public void addRestriccioAssigTemp(RestriccioAssigTemp r) {
        this.ra.add(r);
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

    public void addRestriccioMatins(RestriccioMatins r) {
        this.rm.add(r);
    }

    public void addRestriccioTardes(RestriccioTardes r) {
        this.rt.add(r);
    }

    public void addRestriccioNivell(RestriccioNivell r) {
        this.rn.add(r);
    }

    public void addRestriccioCorrequisit(RestriccioCorrequisit r) {
        this.rc.add(r);
    }

    public boolean comprovarRestriccionsColocar(Sessio actual, ArrayList<Sessio> sessions, Integer dia, Integer hora, Horari horari) {
        boolean compleix = true;
        for (RestriccioSolapar r : rs) {
            compleix = compleix && r.compleixRestriccio(actual, sessions, dia, hora, horari);
            if (!compleix) return false;
        }
        for (RestriccioMatins r : rm) {
            compleix = compleix && r.compleixRestriccio(actual, sessions, dia, hora, horari);
            if (!compleix) return false;
        }
        for (RestriccioTardes r : rt) {
            compleix = compleix && r.compleixRestriccio(actual, sessions, dia, hora, horari);
            if (!compleix) return false;
        }
        for (RestriccioNivell r : rn) {
            compleix = compleix && r.compleixRestriccio(actual, sessions, dia, hora, horari);
            if (!compleix) return false;
        }
        for (RestriccioCorrequisit r : rc) {
            compleix = compleix && r.compleixRestriccio(actual, sessions, dia, hora, horari);
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
