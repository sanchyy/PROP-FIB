package Domini;

import java.util.ArrayList;

class CjtUnitatDocent {

    private ArrayList<UnitatDocent> unitatsDocents = new ArrayList<>();
    private static CjtUnitatDocent instancia = null;

    public static CjtUnitatDocent getInstance() {
        if (instancia == null)
            instancia = new CjtUnitatDocent();

        return instancia;
    }

    public UnitatDocent get(Integer i) {
        return unitatsDocents.get(i);
    }

    public void add(UnitatDocent ud) {
        this.unitatsDocents.add(ud);
    }

    public Integer size() {
        return unitatsDocents.size();
    }
}
