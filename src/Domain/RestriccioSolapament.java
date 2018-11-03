package Domain;

//Sanchy
//aquesta restricció es dona quan dues assignatures volen estar a la mateixa franja

public class RestriccioSolapament {

    private ArrayList <Pair <Assignatura, int>> assignSlot;

    public RestriccioSolapament() {
        assignSlot = new ArrayList <Pair <Assignatura, int>> ();
    }

    public RestriccioSolapament(ArrayList <Assignatura, int> assignSlot) {
        this.assignaturassignSlotaSlot = assignSlot;
    }

    //Setters
    public void setAssignSlot(ArrayList <Assignatura, int> AssignaturaSlot) {
        this.AssignaturaSlot = AssignaturaSlot;
    }
    //Getters

    public ArrayList<Pair<Assignatura, int>> getAssignSlot() {
        return assignSlot;
    }

    //FUNCTIONS AUX

    //Pre: Assignatura a es l'assignatura que es vol afegir i grup el grup on pertany
    //Post: True si es pot afegir, else si no
    public boolean podemSolapar(Assignatura a, int grup) {
        for (Pair<Assignatura,int> x : assignSlot) {
            if (this.isEqual(a)) return false;
            if (/*Mateix Pla d'estudis &&*/x.first.getNivell() == a.getNivell() && grup == x.second) return false;
            

        }
        return true;
    }

}