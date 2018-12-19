package main.Domini;

import java.util.ArrayList;

public class CjtRestriccions {

    private ArrayList<RestriccioSolapar> rs;
    private ArrayList<RestriccioMatins> rm;
    private ArrayList<RestriccioTardes> rt;
    private ArrayList<RestriccioCaracteristicaAula> rca;
    private ArrayList<RestriccioNivell> rn;
    private ArrayList<RestriccioCorrequisit> rc;

    public CjtRestriccions() {
        this.rs  = new ArrayList<>();
        this.rm  = new ArrayList<>();
        this.rt  = new ArrayList<>();
        this.rca = new ArrayList<>();
        this.rn  = new ArrayList<>();
        this.rc  = new ArrayList<>();
    }

    //Setters
    public void setRs(ArrayList<RestriccioSolapar> rs) {
        this.rs = rs;
    }

    public void setRm(ArrayList<RestriccioMatins> rm) {
        this.rm = rm;
    }

    public void setRt(ArrayList<RestriccioTardes> rt) {
        this.rt = rt;
    }

    public void setRca(ArrayList<RestriccioCaracteristicaAula> rca) {
        this.rca = rca;
    }

    public void setRc(ArrayList<RestriccioCorrequisit> rc) {
        this.rc = rc;
    }

    public void setRn(ArrayList<RestriccioNivell> rn) {
        this.rn = rn;
    }

    //Getters


    public ArrayList<RestriccioSolapar> getRs() {
        return rs;
    }

    public ArrayList<RestriccioMatins> getRm() {
        return rm;
    }

    public ArrayList<RestriccioTardes> getRt() {
        return rt;
    }

    public ArrayList<RestriccioCaracteristicaAula> getRca() {
        return rca;
    }

    public ArrayList<RestriccioCorrequisit> getRc() {
        return rc;
    }

    public ArrayList<RestriccioNivell> getRn() {
        return rn;
    }


    public void borraRs(int i) {
        rs.remove(i-1);
    }

    public void borraRm(int i) {
        rm.remove(i-1);
    }

    public void borraRt(int i) {
        rt.remove(i-1);
    }

    public void borraRca(int i) {
        rca.remove(i-1);
    }

    public void borraRc(int i) {
        rc.remove(i-1);
    }

    public void borraRn(int i) {
        rn.remove(i-1);
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
