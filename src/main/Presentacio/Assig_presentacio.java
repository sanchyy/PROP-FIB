package Presentacio;


import javafx.beans.property.*;

public class Assig_presentacio {
    private final StringProperty name;
    private final IntegerProperty quatri; // 1t 2n o tots (3)
    private final IntegerProperty nivell; // Troncal (1), Obligatori (2), Especialitat (3)
    private final BooleanProperty projector;
    private final ObjectProperty<Boolean[]> carac;


    /**
     * Default constructor
     */
    public Assig_presentacio() {
        this(null, null, null, null, null);
    }

    /**
     * Constructora amb dades inicials.
     * @param name
     */
    public Assig_presentacio (String name, Integer quatri, Integer nivell, Boolean projector, Boolean[] lab) {
        this.name = new SimpleStringProperty(name);
        this.quatri = new SimpleIntegerProperty(quatri);
        this.nivell = new SimpleIntegerProperty(nivell);
        this.projector = new SimpleBooleanProperty(projector);
        this.carac = new SimpleObjectProperty<Boolean[]>(lab);
    }

    public String getName () {
        return name.get();
    }

    public void setName (String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty () {
        return name;
    }

    public Integer getQuatri () {
        return quatri.get();
    }

    public void setQuatri (Integer quatri) {
        this.quatri.set(quatri);
    }

    public IntegerProperty quatriProperty () {
        return quatri;
    }

    public Integer getNivell () {
        return nivell.get();
    }

    public void setNivell (Integer nivell) {
        this.nivell.set(nivell);
    }

    public IntegerProperty nivellProperty () {
        return nivell;
    }

    public Boolean getProjector () {
        return projector.get();
    }

    public void setProjector (Boolean projector) {
        this.projector.set(projector);
    }

    public BooleanProperty projectorProperty () {
        return projector;
    }

    public Boolean[] getCarac () {
        return carac.get();
    }

    public void setCarac (Boolean[] carac) {
        this.carac.set(carac);
    }

    public ObjectProperty<Boolean[]> caracProperty () {
        return carac;
    }

}
