package Domini;

import java.util.ArrayList;

public abstract class Restriccio {

    private int id;

    public Restriccio(Integer id) {
        this.id = id;
    }

    public static boolean pertany (Integer h_i, Integer h_f, Integer h) {
        for (int i = h_i; i <= h_f; ++i) {
            if (h_i.intValue() == h.intValue()) return true;
        }
        return false;
    }

    public abstract boolean compleixRestriccio(Sessio actual, ArrayList<Sessio> sessions, Integer dia, Integer hora, Horari horari);
    public abstract boolean compleixRestriccio(Sessio comp, Aula aula);
}
