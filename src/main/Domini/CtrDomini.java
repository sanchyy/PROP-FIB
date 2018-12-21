package Domini;

import com.google.gson.Gson;
import Persistencia.CtrPersistencia;
import com.google.gson.JsonParseException;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

public class CtrDomini {

    private CjtUnitatDocent unitatsDocents = CjtUnitatDocent.getInstance();

    private Gson gson = new Gson();

    private Integer unitatDocentSeleccionada;
    private Integer plaEstudisSeleccionat;
    private Integer quadrimestreSeleccionat;
    private CjtRestriccions restriccions;
    private CtrPersistencia ctrPersistencia;
    private ArrayList<Assignatura> assigPool;

    private String PlansEstudisPath = null;
    private String AssignaturesPath = null;
    private String AulesPath = null;

    public CtrDomini(Integer lvl) {
        if (lvl == 0) {
            this.unitatDocentSeleccionada = null;
            this.plaEstudisSeleccionat    = null;
            this.quadrimestreSeleccionat  = null;
        } else {
            if (lvl > 0) afegirUnitatDocent("FIB");
            if (lvl > 1) afegirPlaEstudis("FIB_2010");
            if (lvl > 2) afegirQuadrimestre();
            if (lvl > 3) afegirAssignaturaPlaEstudis("PROP", 3, 2, "FIB", new ArrayList<>(), new ArrayList<>());
            if (lvl > 4) afegirAulaUnitatDocent("A6203", 30, new ArrayList<>());
            if (lvl > 5) afegirSessioQuadrimestre(11, "PROP");
        }
        this.restriccions = new CjtRestriccions();
        this.ctrPersistencia = new CtrPersistencia();
        this.assigPool = new ArrayList<>();
    }

    public CtrDomini() {
        this.unitatDocentSeleccionada = null;
        this.plaEstudisSeleccionat    = null;
        this.quadrimestreSeleccionat  = null;
        this.restriccions             = new CjtRestriccions();
        this.ctrPersistencia          = new CtrPersistencia();
        this.assigPool                = new ArrayList<>();

        // TODO: Treure quan acabem de provar presentacio
        afegirUnitatDocent("FIB");
        /*afegirPlaEstudis("FIB_2010");
        afegirQuadrimestre();
        afegirAssignaturaPlaEstudis("PROP", 3, 2, "FIB", new ArrayList<>(), new ArrayList<>());
        ArrayList<CaracteristiquesAula> caracs = new ArrayList<>();
        caracs.add(CaracteristiquesAula.UBUNTU);
        afegirAulaUnitatDocent("A6203", 30, caracs);
        afegirSessioQuadrimestre(11, "PROP");*/
    }

    public void guardarDades() {
        if (PlansEstudisPath != null) {
            ArrayList<String> plans = new ArrayList<>();
            for (PlaEstudis pe : getUnitatDocent().getPlansEstudis()) {
                plans.add(gson.toJson(pe));
            }
            ctrPersistencia.guardar(PlansEstudisPath, plans);
        }
        if (AssignaturesPath != null) {
            ArrayList<String> assignatures = new ArrayList<>();
            for (Assignatura a : assigPool) {
                assignatures.add(gson.toJson(a));
            }
            ctrPersistencia.guardar(AssignaturesPath, assignatures);
        }
        if (AulesPath != null) {
            ArrayList<String> aules = new ArrayList<>();
            for (Aula a : getUnitatDocent().getAulesDisponibles()) {
                aules.add(gson.toJson(a));
            }
            ctrPersistencia.guardar(AulesPath, aules);
        }
    }

    ////////

    public void afegirAula(String nom, Integer capacitat, Boolean[] caracs) {
        afegirAulaUnitatDocent(nom, capacitat, parseBooleansAula(caracs));
    }

    public void modificarAula(String nomAntic, String nomNou, Integer capacitat, Boolean[] caracs) {
        ArrayList<Aula> aules = getUnitatDocent().getAulesDisponibles();
        Aula antiga = null;
        for (Aula aula : aules) {
            if (aula.getNom().equals(nomAntic)) {
                antiga = aula;
                break;
            }
        }
        Aula nova = new Aula(nomNou, capacitat, parseBooleansAula(caracs));
        getUnitatDocent().modificarAula(antiga, nova);
    }

    public boolean carregaAules(String path) {
        AulesPath = path;
        getUnitatDocent().borrarAules();
        ArrayList<String> aules = ctrPersistencia.getAules(path);
        for (String a : aules) {
            try {
                Aula aula = gson.fromJson(a, Aula.class);
                getUnitatDocent().afegirAulaDisponible(aula);
            } catch (JsonParseException e) {
                return false;
            }
        }
        return true;
    }

    public Pair<String, Pair<Integer, Boolean[]>> parseAula(Aula a) {
        Boolean[] caracteristiques = new Boolean[6];
        caracteristiques[0] = false;
        caracteristiques[1] = false;
        caracteristiques[2] = false;
        caracteristiques[3] = false;
        caracteristiques[4] = false;
        caracteristiques[5] = false;
        ArrayList<CaracteristiquesAula> carac = a.getCaracteristiques();
        for (CaracteristiquesAula ca : carac) {
            if (ca == CaracteristiquesAula.PROJECTOR) {
                caracteristiques[0] = true;
            } else if (ca == CaracteristiquesAula.UBUNTU) {
                caracteristiques[1] = true;
            } else if (ca == CaracteristiquesAula.FISICA) {
                caracteristiques[2] = true;
            } else if (ca == CaracteristiquesAula.EMBEDED) {
                caracteristiques[3] = true;
            } else if (ca == CaracteristiquesAula.XARXES) {
                caracteristiques[4] = true;
            } else if (ca == CaracteristiquesAula.LINUX_WINDOWS) {
                caracteristiques[5] = true;
            }
        }
        Pair<Integer, Boolean[]> p2 = new Pair<>(a.getCapacitat(), caracteristiques);
        Pair<String, Pair<Integer, Boolean[]>> p1 = new Pair<>(a.getNom(), p2);
        return p1;
    }

    public ArrayList<CaracteristiquesAula> parseBooleansAula(Boolean[] ca) {
        ArrayList<CaracteristiquesAula> caracs = new ArrayList<>();
        if (ca[0]) {
            caracs.add(CaracteristiquesAula.PROJECTOR);
        }
        if (ca[1]) {
            caracs.add(CaracteristiquesAula.UBUNTU);
        }
        if (ca[2]) {
            caracs.add(CaracteristiquesAula.FISICA);
        }
        if (ca[3]) {
            caracs.add(CaracteristiquesAula.EMBEDED);
        }
        if (ca[4]) {
            caracs.add(CaracteristiquesAula.XARXES);
        }
        if (ca[5]) {
            caracs.add(CaracteristiquesAula.LINUX_WINDOWS);
        }
        return caracs;
    }

    public Boolean[] parseCaracsAula(ArrayList<CaracteristiquesAula> ca) {
        Boolean[] caracs = {false, false, false, false, false, false};
        if (ca.contains(CaracteristiquesAula.PROJECTOR)) {
            caracs[0] = true;
        }
        if (ca.contains(CaracteristiquesAula.UBUNTU)) {
            caracs[1] = true;
        }
        if (ca.contains(CaracteristiquesAula.FISICA)) {
            caracs[2] = true;
        }
        if (ca.contains(CaracteristiquesAula.EMBEDED)) {
            caracs[3] = true;
        }
        if (ca.contains(CaracteristiquesAula.XARXES)) {
            caracs[4] = true;
        }
        if (ca.contains(CaracteristiquesAula.LINUX_WINDOWS)) {
            caracs[5] = true;
        }
        return caracs;
    }

    public Aula getAulaConcreta(String nom) {
        ArrayList<Aula> aulesD = getUnitatDocent().getAulesDisponibles();
        for (Aula a : aulesD) {
            if (a.getNom().equals(nom)) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<Pair<String, Pair<Integer, Boolean[]>>> getAules() {
        ArrayList<Aula> aulesD = getUnitatDocent().getAulesDisponibles();
        ArrayList<Pair<String, Pair<Integer, Boolean[]>>> aules = new ArrayList<>();
        for (Aula a : aulesD) {
            aules.add(parseAula(a));
        }
        return aules;
    }

    public void borrarAula(String nom) {
        getUnitatDocent().borrarAula(getAulaConcreta(nom));
    }

    ////////

    public void modificarPlaEstudis(String nomAntic, String nomNou) {
        ArrayList<PlaEstudis> pes = getUnitatDocent().getPlansEstudis();
        PlaEstudis antic = null;
        for (PlaEstudis pe : pes) {
            if (pe.getNom().equals(nomAntic)) {
                antic = pe;
                break;
            }
        }
        PlaEstudis nou = new PlaEstudis(nomNou);
        getUnitatDocent().modificarPlaEstudis(antic, nou);
    }

    public boolean carregaPlansEstudis(String path) {
        PlansEstudisPath = path;
        getUnitatDocent().borrarPlansEstudis();
        ArrayList<String> pes = ctrPersistencia.agafar(path);
        for (String p : pes) {
            try {
                PlaEstudis pe = gson.fromJson(p, PlaEstudis.class);
                getUnitatDocent().afegirPlaEstudis(pe);
            } catch (JsonParseException e) {
                return false;
            }
        }
        return true;
    }

    public PlaEstudis getPlaEstudisConcret(String nom) {
        ArrayList<PlaEstudis> plaEstudis = getUnitatDocent().getPlansEstudis();
        for (PlaEstudis pe : plaEstudis) {
            if (pe.getNom().equals(nom)) {
                return pe;
            }
        }
        return null;
    }
    
    public ArrayList<String> getPlansEstudis() {
        ArrayList<PlaEstudis> plansEstudis = getUnitatDocent().getPlansEstudis();
        ArrayList<String> pes = new ArrayList<>();
        for (PlaEstudis pe : plansEstudis) {
            pes.add(pe.getNom());
        }
        return pes;
    }

    public void borrarPlaEstudis(String nom) {
        getUnitatDocent().borrarPlaEstudis(getPlaEstudisConcret(nom));
    }

    ////////

    public void modificarAssignatura(String nomAntiga, String nom, Integer quatri, Integer nivell, Boolean projector, Boolean[] caracs) {
        Assignatura antiga = null;
        for (Assignatura as : assigPool) {
            if (as.getNom().equals(nomAntiga)) {
                antiga = as;
                break;
            }
        }
        ArrayList<CaracteristiquesAula> teo = new ArrayList<>();
        if (projector) teo.add(CaracteristiquesAula.PROJECTOR);
        Assignatura nova = new Assignatura(nom, quatri, nivell, teo, parseBooleansAula(caracs));
        assigPool.remove(antiga);
        assigPool.add(nova);
    }

    public boolean carregaAssignatures(String path) {
        AssignaturesPath = path;
        assigPool.clear();
        ArrayList<String> ass = ctrPersistencia.agafar(path);
        for (String p : ass) {
            try {
                Assignatura as = gson.fromJson(p, Assignatura.class);
                assigPool.add(as);
            } catch (JsonParseException e) {
                return false;
            }
        }
        return true;
    }

    public Assignatura getAssignaturaConcreta(String nom) {
        for (Assignatura a : assigPool) {
            if (a.getNom().equals(nom)) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<Pair<String, Pair<Integer, Pair<Integer, Pair<Boolean, Boolean[]>>>>> getAssignatures() {
        ArrayList<Pair<String, Pair<Integer, Pair<Integer, Pair<Boolean, Boolean[]>>>>> ass = new ArrayList<>();
        for (Assignatura a : assigPool) {
            Pair<Boolean, Boolean[]> p4 = new Pair<>(a.getCaracteristiquesTeoria().contains(CaracteristiquesAula.PROJECTOR), parseCaracsAula(a.getCaracteristiquesLabo()));
            Pair<Integer, Pair<Boolean, Boolean[]>> p3 = new Pair<>(a.getNivell(), p4);
            Pair<Integer, Pair<Integer, Pair<Boolean, Boolean[]>>> p2 = new Pair<>(a.getQuadri(), p3);
            Pair<String, Pair<Integer, Pair<Integer, Pair<Boolean, Boolean[]>>>> p1 = new Pair<>(a.getNom(), p2);
            ass.add(p1);
        }
        return ass;
    }

    public void borrarAssignatura(String nom) {
        assigPool.remove(getAssignaturaConcreta(nom));
    }

    ////////

    public CjtUnitatDocent getUnitatsDocents() {
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

    public CjtRestriccions getRestriccions() { return restriccions; }

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

    public void afegirAulaUnitatDocent(String nom, Integer capacitat, ArrayList<CaracteristiquesAula> caracteristiques) {
        Aula a = new Aula(nom, capacitat, caracteristiques);
        this.getUnitatDocent().afegirAulaDisponible(a);
    }

    public void afegirAssignaturaPlaEstudis(String nom, Integer quadri, Integer nivell, Boolean[] teo, Boolean[] lab) {
        Assignatura a = new Assignatura(nom, quadri, nivell, parseBooleansAula(teo), parseBooleansAula(lab));
        assigPool.add(a);
    }

    public void afegirAssignaturaPlaEstudis(String nom, Integer quadri, Integer nivell, String plaEstudis, ArrayList<CaracteristiquesAula> teo, ArrayList<CaracteristiquesAula> lab) {
        Assignatura a = new Assignatura(nom, quadri, nivell, plaEstudis, teo, lab);
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

    public Assignatura getAssignatura(Integer i) {
        return getPlaEstudis().getAssignatura(i);
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

    public void borrarUnitatDocent(Integer i) {
        UnitatDocent ud = unitatsDocents.get(i);
        unitatsDocents.del(ud);
        this.unitatDocentSeleccionada = null;
    }

    public String llistaSessions() {
        Integer i = 1;
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

    public void crearRestriccioCorrequisit(Integer a, Integer b) {
        Sessio A = getQuadrimestre().getSessions().get(a);
        Sessio B = getQuadrimestre().getSessions().get(b);

        RestriccioCorrequisit r = new RestriccioCorrequisit(A,B);
        restriccions.addRestriccioCorrequisit(r);
    }

    public void crearRestriccioNivell(Integer a, Integer b) {
        Sessio A = getQuadrimestre().getSessions().get(a);
        Sessio B = getQuadrimestre().getSessions().get(b);

        RestriccioNivell r = new RestriccioNivell(A,B);
        restriccions.addRestriccioNivell(r);
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
        Generador bt = new Generador(horariActual, getPlaEstudis(), getQuadrimestre().getSessions(), restriccions);
        bt.generarHorari(getUnitatDocent().getAulesDisponibles());
        horariActual = bt.getHorari();
        horariActual.mostrarHorari();
    }

    public void llistaUnitatsDocents() {
        Integer i = 1;
        for (UnitatDocent ud : unitatsDocents.getUnitatsDocents()) {
            System.out.println("[" + i++ + "] " + ud.getNom());
        }
    }

    public ArrayList<CaracteristiquesAula> getLlistaCaracteristiquesTeoria(String nom) {
        Assignatura a = getPlaEstudis().getAssignatura(nom);
        if (a == null) return new ArrayList<>();
        else return a.getCaracteristiquesTeoria();
    }

    public ArrayList<CaracteristiquesAula> getLlistaCaracteristiquesLab(String nom) {
        Assignatura a = getPlaEstudis().getAssignatura(nom);
        if (a == null) return new ArrayList<>();
        else return a.getCaracteristiquesLabo();
    }

    public Integer midaUnitatsDocents() {
        return getUnitatsDocents().size();
    }

    public void llistaAssignatures() {
        int i = 1;
        for (Assignatura a : getPlaEstudis().getAssignatures()) {
            System.out.println("["+(i++)+"] " + a.getNom());
        }
    }

    public void llistaPlaEstudi() {
        int i = 1;
        for (PlaEstudis pe : getUnitatDocent().getPlansEstudis()) {
            System.out.println("["+(i++)+"] " + pe.getNom());
        }
    }

    public void borrarPlaEstudis(Integer b) {
        getUnitatDocent().getPlansEstudis().remove(getUnitatDocent().getPlansEstudis().get(b-1));
    }



    public void llistaQuadrimestres() {
        int i = 1;
        for (Quadrimestre q : getPlaEstudis().getQuadrimestres()) {
            System.out.println("["+i+"] Q"+i++);
        }
    }

    public void llistaAules() {
        int i = 1;
        for (Aula a : getUnitatDocent().getAulesDisponibles()) {
            System.out.println("["+(i++)+"] " + a.getNom());
        }
    }

}