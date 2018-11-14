package Domini;

import java.util.ArrayList;

public class RestriccioCaracteristicaAula extends Restriccio {

    private Sessio sessio;
    private ArrayList<CaracteristiquesAula> caracteristiques;

    public RestriccioCaracteristicaAula(Sessio sessio, ArrayList<CaracteristiquesAula> caracteristiques) {
        super(5);
        this.sessio = sessio;
        this.caracteristiques = caracteristiques;
    }

    public boolean compleixRestriccio(Sessio actual, ArrayList<Sessio> sessions, Integer dia, Integer hora, Horari horari) {
        return true;
    }

    public boolean compleixRestriccio(Sessio comp, Aula aula) {
        if (comp.sonIguals(sessio)) {
            Integer count = 0;
            for (CaracteristiquesAula carac : aula.getCaracteristiques()) {
                if (caracteristiques.contains(carac)) ++count;
            }
            return count == caracteristiques.size();
        }
        return true;
    }

}
