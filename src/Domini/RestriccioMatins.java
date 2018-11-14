package Domini;

// Berni
import java.util.ArrayList;

public class RestriccioMatins extends Restriccio {

    private Sessio sessio;

    public RestriccioMatins(Sessio a) {
        super(7);
        this.sessio = a;
    }

    //FUNCTIONS AUX
    public boolean compleixRestriccio(Sessio actual, ArrayList<Sessio> sessions, Integer dia, Integer hora, Horari horari) {
        if (sessio.sonIguals(actual)) {
            return hora < 6;
        } else {
            return true;
        }
    }

    public boolean compleixRestriccio(Sessio comp, Aula aula) {
        return true;
    }

}
