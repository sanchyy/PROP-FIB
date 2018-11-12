package Domini;

import java.util.ArrayList;

// Berni
public class CtrDomini {
    private ArrayList<UnitatDocent> unitatsDocents;
    private Integer unitatDocentSeleccionada;
    private Integer plaEstudisSeleccionat;
    private Integer quadrimestreSeleccionat;

    private ArrayList<RestriccioSolapar> rs;
    private ArrayList<RestriccioJornada> rj;
    private ArrayList<RestriccioReserva> rr;

    public CtrDomini() {
        this.unitatsDocents = new ArrayList<>();
        this.unitatDocentSeleccionada = null;
        this.plaEstudisSeleccionat = null;
        this.quadrimestreSeleccionat = null;
        this.rs = new ArrayList<>();
        this.rj = new ArrayList<>();
        this.rr = new ArrayList<>();
    }

    public ArrayList<UnitatDocent> getUnitatsDocents() {
        return unitatsDocents;
    }

    public Integer getPlaEstudisSeleccionat() {
        return plaEstudisSeleccionat;
    }

    public Integer getQuadrimestreSeleccionat() {
        return quadrimestreSeleccionat;
    }

    public Integer getUnitatDocentSeleccionada() {
        return unitatDocentSeleccionada;
    }

    public void setPlaEstudisSeleccionat(Integer plaEstudisSeleccionat) {
        this.plaEstudisSeleccionat = plaEstudisSeleccionat;
    }

    public void setQuadrimestreSeleccionat(Integer quadrimestreSeleccionat) {
        this.quadrimestreSeleccionat = quadrimestreSeleccionat;
    }

    public void setUnitatDocentSeleccionada(Integer unitatDocentSeleccionada) {
        this.unitatDocentSeleccionada = unitatDocentSeleccionada;
    }

    public UnitatDocent getUnitatDocent() {
        return unitatsDocents.get(unitatDocentSeleccionada);
    }

    public PlaEstudis getPlaEstudis() {
        return getUnitatDocent().getPlansEstudis().get(plaEstudisSeleccionat);
    }

    public Quadrimestre getQuadrimestre() {
        return getPlaEstudis().getQuadrimestres().get(quadrimestreSeleccionat);
    }

    public void afegirAulaUnitatDocent(String nom, Integer capacitat) {
        Aula a = new Aula(nom, capacitat);
        this.getUnitatDocent().afegirAulaDisponible(a);

    }

    public void afegirAssignaturaPlaEstudis(String nom, Integer quadri, Integer nivell) {
        Assignatura a = new Assignatura(nom, quadri, nivell);
        getPlaEstudis().afegirAssignatura(a);
    }

    public void afegirAssignaturaPlaEstudis(String nom, Integer quadri, Integer nivell, String plaEstudis) {
        Assignatura a = new Assignatura(nom, quadri, nivell, plaEstudis);
        getPlaEstudis().afegirAssignatura(a);
    }

    // TODO: La restriccio horaria no hi hauria de ser
    public void afegirSessioQuadrimestre(Integer grup, String nomAssignatura, Pair<Integer, Integer> restriccioHoraria) {
        Assignatura assignatura = getAssignatura(nomAssignatura);
        Sessio s = new Sessio(grup, assignatura, restriccioHoraria);
        getQuadrimestre().afegirSessio(s);
    }

    public boolean existeixPlaEstudis(String nom) {
        PlaEstudis p = getUnitatDocent().buscarPlaEstudis(nom);
        return p != null;
    }

    public boolean existeixAssignatura(String nom) {
        Assignatura a = getAssignatura(nom);
        return a != null;
    }

    public Assignatura getAssignatura(String nom) {
        return getPlaEstudis().getAssignatura(nom);
    }

    public void afegirPlaEstudis(String nom) {
        PlaEstudis pe = new PlaEstudis(nom);
        getUnitatDocent().afegirPlaEstudis(pe);
        plaEstudisSeleccionat = getUnitatDocent().getPlansEstudis().size()-1;
    }

    public void afegirUnitatDocent(String nom) {
        UnitatDocent ud = new UnitatDocent(nom);
        unitatsDocents.add(ud);
        unitatDocentSeleccionada = getUnitatsDocents().size()-1;
    }

    public void afegirQuadrimestre() {
        Quadrimestre q = new Quadrimestre();
        getPlaEstudis().afegirQuadrimestre(q);
        quadrimestreSeleccionat = getPlaEstudis().getQuadrimestres().size()-1;
    }

    public String llistaSessions() {
        Integer i = 0;
        String sessions = "";
        for (Sessio s : getQuadrimestre().getSessions()) {
            sessions += "[" + i++ + "] " + s.getAssignatura().getNomAssig() + "-" + s.getGrup() + "\n";
        }
        return sessions;
    }

    // TODO: Restriccio de prova
    public void crearRestriccio(Integer a, Integer b) {
        Sessio sa = getQuadrimestre().getSessions().get(a);
        Sessio sb = getQuadrimestre().getSessions().get(b);
        RestriccioSolapar r = new RestriccioSolapar(sa, sb);
        rs.add(r);
    }

    public void generarHorari() {
        Horari horariActual = new Horari();
        System.out.println("Es generarà l'horari amb els següents objectes:");
        System.out.println("    Pla d'Estudis: " + getPlaEstudis().getNom());
        System.out.println("    Aules: ");
        for (Aula a : getUnitatDocent().getAulesDisponibles()) {
            System.out.println("        - " + a.getNom_aula());
        }
        System.out.println("    Assignatures: ");
        for (Assignatura a : getPlaEstudis().getAssignatures()) {
            System.out.println("        - " + a.getNomAssig());
        }
        System.out.println("    Sessions: ");
        for (Sessio s : getQuadrimestre().getSessions()) {
            System.out.println("        - " + s.getAssignatura().getNomAssig() + " " + s.getRestriccio().toString());
        }
        Generador bt = new Generador(horariActual, getPlaEstudis(), getQuadrimestre().getSessions(), rs.get(0));
        bt.generarHorari(getUnitatDocent().getAulesDisponibles());
        horariActual = bt.getHorari();
        horariActual.mostrarHorari();
    }

    public void llistaAssignatures() {
        System.out.println("LLISTANT ASSIGNATURES");
        for (Assignatura a : getPlaEstudis().getAssignatures()) {
            System.out.println("Nom: " + a.getNomAssig());
        }
    }

}
