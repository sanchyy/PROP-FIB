package Domini;

//Sanchy
//aquesta restricció es dona quan dues assignatures volen estar a la mateixa franja

import java.util.ArrayList;

public class RestriccioSolapar extends Restriccio {

    private Sessio sessio_A;
    private Sessio sessio_B;

    public RestriccioSolapar(Sessio a, Sessio b) {
        super(4);
        this.sessio_A = a;
        this.sessio_B = b;
    }

    //FUNCTIONS AUX
    public boolean compleixRestriccio(Sessio comp, ArrayList<Sessio> sessions, Horari horari) {
        Sessio comprovar = null;
        if (sessio_A.getGrup().intValue() == comp.getGrup().intValue() && sessio_A.getAssignatura().getNomAssig().equals(comp.getAssignatura().getNomAssig()))
            comprovar = sessio_B;
        else if (sessio_B.getGrup().intValue() == comp.getGrup().intValue() && sessio_B.getAssignatura().getNomAssig().equals(comp.getAssignatura().getNomAssig()))
            comprovar = sessio_A;

        if (comprovar != null) {
            for (Sessio sessio : sessions) {
                if (sessio.getGrup().intValue() == comprovar.getGrup().intValue() && sessio.getAssignatura().getNomAssig().equals(comprovar.getAssignatura().getNomAssig())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean compleixRestriccio(Sessio comp, Aula aula) {
        return true;
    }

}
