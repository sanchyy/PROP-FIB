package Domini;

//Sanchy
public abstract class Restricio {

    private int id; //identificador restriccio

    public Restricio(id) {
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

    public abstract boolean compleixRestriccio();
}
