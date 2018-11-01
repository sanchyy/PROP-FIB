package Domain;

import Domain.Assignatura;

//Sanchy
//aquesta restricció es dona quan dues assignatures volen estar a la mateixa franja
public class RestriccioSolapament {

    private ArrayList <pair<Assignatura,grup>>

    public RestriccioSolapament() {
        this.AssAct  = null;
        this.AssNova = null;
        this.GrupAct = null;
        this.GrupNou = null;
    }

    public RestriccioSolapament(Assignatura AssAct, Assignatura AssNova, Integer NvlAct, Integer NvlNou, Integer GrupAct, Integer GrupNou) {
        this.AssAct  = AssAct;
        this.AssNova = AssNova;
        this.GrupAct = GrupAct;
        this.GrupNou = GrupNou;
    }

    //Setters
    public void setAssAct(Assignatura assAct) {
        AssAct = assAct;
    }

    public void setAssNova(Assignatura assNova) {
        AssNova = assNova;
    }

    public void setGrupAct(Integer grupAct) {
        GrupAct = grupAct;
    }

    public void setGrupNou(Integer grupNou) {
        GrupNou = grupNou;
    }

    //Getters
    public Assignatura getAssAct() {
        return AssAct;
    }

    public Assignatura getAssNova() {
        return AssNova;
    }

    public Integer getGrupAct() {
        return GrupAct;
    }

    public Integer getGrupNou() {
        return GrupNou;
    }

    //FUNCTIONS AUX

    public Boolean esSolapa() {

    }

}