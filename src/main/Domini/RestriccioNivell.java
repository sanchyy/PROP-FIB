package main.Domini;

import java.util.ArrayList;

public class RestriccioNivell extends Restriccio {

    private Sessio sessio_A;
    private Sessio sessio_B;

    public RestriccioNivell(Sessio a, Sessio b) {
        super(7);
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
                if (sessio.getAssignatura().getNivell().equals(comprovar.getAssignatura().getNivell())) {
                    return false;
                }
            }
        }
        return true;
    }

    public String escriuParellSessio() {
        return (sessio_A.mostrarSessio() + " " + sessio_B.mostrarSessio());
    }

    public boolean compleixRestriccio(Sessio comp, Aula aula) {
        return true;
    }

}
