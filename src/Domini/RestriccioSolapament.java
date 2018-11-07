package Domini;

//Sanchy
//aquesta restricció es dona quan dues assignatures volen estar a la mateixa franja

import java.util.ArrayList;

public class RestriccioSolapament {

    private ArrayList <Pair <Assignatura, Integer>> assignSlot;

    public RestriccioSolapament() {
        assignSlot = new ArrayList <Pair <Assignatura, Integer>> ();
    }

    public RestriccioSolapament(ArrayList <Pair <Assignatura, Integer>> assignSlot) {
        this.assignSlot = assignSlot;
    }

    //Setters
    public void setAssignSlot(ArrayList <Pair <Assignatura, Integer>> AssignaturaSlot) {
        this.assignSlot = AssignaturaSlot;
    }
    //Getters

    public ArrayList <Pair <Assignatura, Integer>> getAssignSlot() {
        return assignSlot;
    }

    //FUNCTIONS AUX
/*
    //Pre: Assignatura a es l'assignatura que es vol afegir i grup el grup on pertany
    //Post: True si es pot afegir, else si no
    public boolean podemSolapar(Assignatura a, int grup) {
        for (Pair<Assignatura,int> x : assignSlot) {
            //Labo i teoria del mateix grup no poden anar junts
            //En un pla d'estudis, no poden haver dues assig del mateix nivell i del mateix grup
            if (this.isEqual(a) && this.grup == grup) return false;
            // Mateix Pla d'estudis && if (x.first.getNivell() == a.getNivell() && grup == x.second) return false;
        }
        return true;
    }
*/
}