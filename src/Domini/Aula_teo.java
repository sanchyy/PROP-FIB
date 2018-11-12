package Domini;

public class Aula_teo extends Aula {
    private boolean projector;

    // Constructores
    public Aula_teo(boolean projector) {
        super();
        this.projector = projector;
    }

    public Aula_teo(String nom_aula, Integer capacitat, boolean projector) {
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
