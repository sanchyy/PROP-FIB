package Domain;

import Domain.Assignatura;
import java.util.ArrayList;

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
    public Boolean podemSolapar(Assignatura a, int grup) {
        for (Pair<Assignatura,int> x : assignSlot) {
            if (x.second == grup) return false;
            if (x.first.getNivell == a.getNivell()) return false;
            
            return true;
        }
    }

}