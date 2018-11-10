package Domini;

//Sanchy
//aquesta restricció es dona quan dues assignatures volen estar a la mateixa franja

import java.util.ArrayList;

public class RestriccioSolapament extends Restriccio {

    private ArrayList <Pair <Assignatura, Integer>> assignSlot;

    public RestriccioSolapament() {
        super(0);
        assignSlot = new ArrayList <Pair <Assignatura, Integer>> ();
    }

    public RestriccioSolapament(ArrayList <Pair <Assignatura, Integer>> assignSlot) {
        super(0);
        this.assignSlot = assignSlot;
    }

    //Setters
    public void setAssignSlot(ArrayList <Pair <Assignatura, Integer>> AssignaturaSlot) {
        this.assignSlot = AssignaturaSlot;
    }

    //Getterss

    public ArrayList <Pair <Assignatura, Integer>> getAssignSlot() {
        return assignSlot;
    }

    //FUNCTIONS AUX
    public boolean compleixRestriccio() {
        return true;
    }

/*
    public boolean esPotSolaparRequisit() {

        incorporar "type" de requisits
        recorrer "type" i es podrà posar si:
            1) Pre-requisit (ja que com no es poden fer les dues, es podrà solapar)
            2)


    }
*/
    //Pre: Assignatura a es l'assignatura que es vol afegir i grup el grup on pertany
    //Post: True si es pot afegir, else si no
    public boolean podemSolapar(Assignatura a, int grup) {
        for (Pair<Assignatura,Integer> x : assignSlot) {
            //Labo i teoria del mateix grup no poden anar junts
            if ((x.getFirst()).isEqual(a)) return false; //dues assignatures iguals en la mateixa franja
            if ((x.getFirst()).getNivell().intValue() == a.getNivell().intValue()
                && grup == x.getSecond())
                    return false; //mateix pla d'estudis, nivell i grup no pot coincidir en una franja

        }
        return true;
    }

}