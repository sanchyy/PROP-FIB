package main.Presentacio;

import javafx.beans.property.*;

public class Aula_presentacio {
    private final StringProperty name;
    private final IntegerProperty capacity;
    private final ObjectProperty<Boolean[]> carac;

    /**
     * Default constructor
     */
    public Aula_presentacio() {
        this(null, null, null);
    }

    /**
     * Constructora amb dades inicials.
     * @param name
     * @param capacity
     * @param carac
     */
    public Aula_presentacio (String name, Integer capacity, Boolean carac[]) {
        this.name = new SimpleStringProperty(name);
        this.capacity = new SimpleIntegerProperty(capacity);
        this.carac = new SimpleObjectProperty<Boolean[]>(carac);
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

    public Integer getCapacity () {
        return capacity.get();
    }

    public void setCapacity (Integer capacity) {
        this.capacity.set(capacity);
    }

    public IntegerProperty capacityProperty () {
        return capacity;
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
