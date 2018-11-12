package Domini;

import java.util.ArrayList;

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

    public void afegirPlaEstudis(String nom) {
        PlaEstudis pe = new PlaEstudis(nom);
        unitatsDocents.get(plaEstudisSeleccionat).afegirPlaEstudis(pe);
    }

}
