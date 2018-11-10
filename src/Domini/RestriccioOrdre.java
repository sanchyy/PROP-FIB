package Domini;

import java.util.ArrayList;

public class RestriccioOrdre extends Restriccio {
    //private ArrayList <Pair<Sessio,Pair<String,Integer>>>[] distribAssig;
    private ArrayList <Pair<String,Integer>>[] distribAssig;

    public RestriccioOrdre(ArrayList<Pair<String,Integer>>[] distribAssig) {
        super(3);
        this.distribAssig = distribAssig;
    }

    //Setters
    public void setTotalAssignatures(ArrayList<Pair<String,Integer>>[] distribAssig) {
        this.distribAssig = distribAssig;
    }


    //Getters
    public ArrayList<Pair<String,Integer>>[] getDistribAssig () {
        return distribAssig;
    }


    //AUXILIAR FUNCTIONS
    public boolean compleixRestriccio() {
        return true;
    }
    /*
    //Com nommés tindrem teoria i problemes, primer vol dir que aquest anirà abans que
    public boolean esPotOrdre(String ordre) {
        if (distribAssig.length == 0)
            return ordre.equals("");

        else {
            for (Pair<Sessio,Pair<String,Integer>> x : distribAssig) {

            }
        }
    }*/

}
