package Domini;

//Sanchy
//aquesta restricció es dona quan dues assignatures volen estar a la mateixa franja

import java.util.ArrayList;

public class RestriccioSolapament extends Restriccio {

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
        for (Pair<Assignatura,Integer> x : assignSlot) {
            //Labo i teoria del mateix grup no poden anar junts
            if (this.isEqual(a)) return false; //dues assignatures iguals en la mateixa franja
            if (a.getPlaEstudis()        == (x.first).getPlaEstudis()
                && (x.first).getNivell() == a.getNivell()
                && grup == x.second)
                    return false; //mateix pla d'estudis, nivell i grup no pot coincidir en una franja

        }
        return true;
    }
*/
}