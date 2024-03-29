package Domini;

import java.util.ArrayList;

public class RestriccioMatins extends Restriccio {

    private Sessio sessio;

    public RestriccioMatins(Sessio a) {
        super(7);
        this.sessio = a;
    }

    public boolean compleixRestriccio(Sessio actual, ArrayList<Sessio> sessions, Integer dia, Integer hora, Horari horari) {
        if (sessio.sonIguals(actual)) {
            return hora < 6;
        } else {
            return true;
        }
    }

    public String getSessio() {
        return sessio.mostrarSessio();
    }

    public boolean compleixRestriccio(Sessio comp, Aula aula) {
        return true;
    }

}
