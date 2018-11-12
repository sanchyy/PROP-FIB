package Domini;

public class Aula_lab extends Aula {
    private boolean[] caracteristiques  = new boolean[6];
    // Projector, Ubuntu, Linux/Windows, física, embeded, xarxes

    // Constructora
    public Aula_lab(boolean[] caracteristiques) {
        super();
        this.caracteristiques = caracteristiques;
    }

    public Aula_lab(String nom_aula, Integer capacitat, boolean[] caracteristiques) {
        super(nom_aula, capacitat);
        this.caracteristiques = caracteristiques;
    }

    // Setters
    public void setCaracterísitques (boolean[] caracteristiques){
        for (int i = 0; i < caracteristiques.length; i++) {
            this.caracteristiques[i] = caracteristiques[i];
        }
    }

    // Getters
    public boolean[] getCaracteristiques() {
        return this.caracteristiques;
    }

    // Check caracteristiques
    public boolean checkProjector () {
        return caracteristiques[0];
    }

    public boolean checkUbuntu () {
        return caracteristiques[1];
    }

    public boolean checkLW () {
        return caracteristiques[2];
    }

    public boolean checkFisica () {
        return caracteristiques[3];
    }

    public boolean checkEmbeded () {
        return caracteristiques[4];
    }

    public boolean checkXarxes() {
        return caracteristiques[5];
    }


}
