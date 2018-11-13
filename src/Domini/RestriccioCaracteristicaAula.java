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

    //FUNCTIONS AUX
    public boolean compleixRestriccio(Sessio comp, ArrayList<Sessio> sessions, Horari horari) {
        return true;
    }

    public boolean compleixRestriccio(Sessio comp, Aula aula) {
        if (sessio.getGrup().intValue() == comp.getGrup().intValue() && sessio.getAssignatura().getNomAssig().equals(comp.getAssignatura().getNomAssig())) {
            Integer count = 0;
            for (CaracteristiquesAula carac : aula.getCaracteristiques()) {
                if (caracteristiques.contains(carac)) ++count;
            }
            System.out.println(count);
            return count == caracteristiques.size();
        }
        return true;
    }

}
