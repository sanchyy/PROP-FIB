package Domini;

import java.util.ArrayList;

public class RestriccioCorrequisit extends Restriccio {

    private Sessio sessio_A;
    private Sessio sessio_B;

    public RestriccioCorrequisit(Sessio a, Sessio b) {
        super(4);
        this.sessio_A = a;
        this.sessio_B = b;
    }

    public boolean compleixRestriccio(Sessio actual, ArrayList<Sessio> sessions, Integer dia, Integer hora, Horari horari) {
        Sessio comprovar = null;
        if (sessio_A.sonIguals(actual))
            comprovar = sessio_B;
        else if (sessio_B.sonIguals(actual))
            comprovar = sessio_A;

        if (comprovar != null) {
            for (Sessio sessio : sessions) {
                if (sessio.getGrup().intValue() == comprovar.getGrup().intValue() && sessio.getAssignatura().getNom().equals(comprovar.getAssignatura().getNom())) {
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
