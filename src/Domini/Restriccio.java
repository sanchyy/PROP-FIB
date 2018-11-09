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

    public abstract boolean compleixRestriccio();
}
