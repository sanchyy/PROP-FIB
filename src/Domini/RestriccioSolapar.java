package Domini;

//Sanchy
//aquesta restricció es dona quan dues assignatures volen estar a la mateixa franja

import java.util.ArrayList;

public class RestriccioSolapar extends Restriccio {

    private Sessio sessio_A;
    private Sessio sessio_B;

    public RestriccioSolapar(Sessio a, Sessio b) {
        super(0);
        this.sessio_A = a;
        this.sessio_B = b;
    }

    //FUNCTIONS AUX
    public boolean comprovaRestriccio(Sessio comp, ArrayList<Sessio> sessions) {
        Sessio comprovar = null;
        if (sessio_A.getGrup() == comp.getGrup() && sessio_A.getAssignatura().getNomAssig().equals(comp.getAssignatura().getNomAssig())) {
            comprovar = sessio_B;
        } else if (sessio_B.getGrup() == comp.getGrup() && sessio_B.getAssignatura().getNomAssig().equals(comp.getAssignatura().getNomAssig())) {
            comprovar = sessio_A;
        }
        if (comprovar != null) {
            for (Sessio sessio : sessions) {
                if (sessio.getGrup() == comprovar.getGrup() && sessio.getAssignatura().getNomAssig().equals(comprovar.getAssignatura().getNomAssig())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean compleixRestriccio() {
        return true;
    }

}
