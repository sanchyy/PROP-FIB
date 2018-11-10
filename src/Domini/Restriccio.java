package Domini;

//Sanchy
public abstract class Restriccio {

    private int id; //identificador restriccio

    public Restriccio(Integer id) {
        this.id = id;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }


    //Getters
    public int getId() {
        return id;
    }


    //AUXILIAR FUNCTIONS

    public static boolean pertany (Integer h_i, Integer h_f, Integer h) {
        for (int i = h_i; i <= h_f; ++i) {
            if (h_i.intValue() == h.intValue()) return true;
        }
        return false;
    }

    public abstract boolean compleixRestriccio();
}
