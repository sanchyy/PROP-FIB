package Domini;

public class Teo_aula extends Aula {
    private boolean projector;

    // Constructores
    public Teo_aula (boolean projector) {
        super();
        this.projector = projector;
    }

    public Teo_aula (String nom_aula, Integer capacitat, boolean projector) {
        super(nom_aula, capacitat);
        this.projector = projector;
    }

    // Setters

    public void setProjector(boolean projector) {
        this.projector = projector;
    }

    // Getters
    public boolean needsProjector () {
        return projector;
    }
}
