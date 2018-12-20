package Presentacio;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Assig_presentacio {
    private final SimpleStringProperty name;


    /**
     * Default constructor
     */
    public Assig_presentacio() {
        this(null);
    }

    /**
     * Constructora amb dades inicials.
     * @param name
     */
    public Assig_presentacio (String name) {
        this.name = new SimpleStringProperty(name);
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
}
