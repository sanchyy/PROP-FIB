package Domini;

//Sanchy
public abstract class SAT {

    private int id; //identificador restriccio

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public abstract boolean compleixRestriccio();
}
