package Domini;

import java.util.ArrayList;

// Berni
public class CtrDomini {
    private ArrayList<UnitatDocent> unitatsDocents;
    private Integer unitatDocentSeleccionada;
    private Integer plaEstudisSeleccionat;
    private Integer quadrimestreSeleccionat;

    private CjtRestriccions restriccions;

    public CtrDomini() {
        this.unitatsDocents = new ArrayList<>();
        this.unitatDocentSeleccionada = null;
        this.plaEstudisSeleccionat    = null;
        this.quadrimestreSeleccionat  = null;
        this.restriccions             = new CjtRestriccions();
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

    public void afegirAulaUnitatDocent(String nom, Integer capacitat, String tipus, ArrayList<CaracteristiquesAula> caracteristiques) {
        Aula a = new Aula(nom, capacitat, tipus, caracteristiques);
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

    public void afegirSessioQuadrimestre(Integer grup, String nomAssignatura) {
        Assignatura assignatura = getAssignatura(nomAssignatura);
        Sessio s = new Sessio(grup, assignatura);
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
            sessions += "[" + i++ + "] " + s.getAssignatura().getNom() + "-" + s.getGrup() + "\n";
        }
        return sessions;
    }

    //------ RESTRICCIONS ------

    public void crearRestriccioSolapar(Integer a, Integer b) {
        Sessio sa = getQuadrimestre().getSessions().get(a);
        Sessio sb = getQuadrimestre().getSessions().get(b);
        RestriccioSolapar r = new RestriccioSolapar(sa, sb);
        restriccions.addRestriccioSolapar(r);
    }

    public void crearRestriccioReservar(String aula, Integer dia, Integer hora) {
        RestriccioReserva r = new RestriccioReserva(aula, dia, hora);
        restriccions.addRestriccioReserva(r);
    }

    public void crearRestriccioAssigTemp(Integer dia, Integer hora, String nomAssig) {
        RestriccioAssigTemp r = new RestriccioAssigTemp(dia,hora,nomAssig);
        restriccions.addRestriccioAssigTemp(r);
    }

    public void crearRestriccioCaracteristicaAula(Integer a, ArrayList<CaracteristiquesAula> caracteristiques) {
        Sessio sessio = getQuadrimestre().getSessions().get(a);
        RestriccioCaracteristicaAula r = new RestriccioCaracteristicaAula(sessio, caracteristiques);
        restriccions.addRestriccioCaracteristicaAula(r);
    }

    public void crearRestriccioTardes(Integer a) {
        Sessio sessio = getQuadrimestre().getSessions().get(a);
        RestriccioTardes r = new RestriccioTardes(sessio);
        restriccions.addRestriccioTardes(r);
    }

    public void crearRestriccioMatins(Integer a) {
        Sessio sessio = getQuadrimestre().getSessions().get(a);
        RestriccioMatins r = new RestriccioMatins(sessio);
        restriccions.addRestriccioMatins(r);
    }


    public void generarHorari() {
        Horari horariActual = new Horari();
        System.out.println("Es generarà l'horari amb els següents objectes:");
        System.out.println("    Pla d'Estudis: " + getPlaEstudis().getNom());
        System.out.println("    Aules: ");
        for (Aula a : getUnitatDocent().getAulesDisponibles()) {
            System.out.println("        - " + a.getNom());
        }
        System.out.println("    Assignatures: ");
        for (Assignatura a : getPlaEstudis().getAssignatures()) {
            System.out.println("        - " + a.getNom());
        }
        System.out.println("    Sessions: ");
        for (Sessio s : getQuadrimestre().getSessions()) {
            System.out.println("        - " + s.getAssignatura().getNom());
        }
        Generador bt = new Generador(horariActual, getPlaEstudis(), getQuadrimestre().getSessions(), restriccions);
        bt.generarHorari(getUnitatDocent().getAulesDisponibles());
        horariActual = bt.getHorari();
        horariActual.mostrarHorari();
    }

    public void llistaAssignatures() {
        System.out.println("LLISTANT ASSIGNATURES");
        for (Assignatura a : getPlaEstudis().getAssignatures()) {
            System.out.println("Nom: " + a.getNom());
        }
    }

}
