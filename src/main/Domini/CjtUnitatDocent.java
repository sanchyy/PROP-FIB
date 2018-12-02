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

    public ArrayList<UnitatDocent> getUnitatsDocents() {
        return unitatsDocents;
    }

    public void del(UnitatDocent ud) {
        this.unitatsDocents.remove(ud);
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
