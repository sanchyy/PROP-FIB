package Domini;

//Sanchy
public class Labo extends Assignatura {

    private Integer num_hores;
    private boolean[] necessita;

    public Labo(Integer num_hores, boolean[] necessita) {
        super();
        this.num_hores   = num_hores;
        this.necessita   = necessita;
    }

    public Labo(String nomAssig, Integer num_alumnes, Integer ngrups, Integer nsub, Integer quatri, Integer nivell, Integer num_hores, boolean[] necessita) {
        super(nomAssig,num_alumnes,ngrups,nsub ,quatri, nivell);
        this.num_hores   = num_hores;
        this.necessita   = necessita;
    }

    //Setters
    public void setNum_hores (Integer num_hores) {
        this.num_hores = num_hores;
    }

    public void setNecessita(boolean[] necessita) {
        this.necessita = necessita;
    }



    //Getters
    public Integer getNum_hores () {
        return num_hores;
    }

    public boolean[] getNecessitat() { return necessita; }


    //AUXILIAR FUNCTIONS

    public Integer getNum_alumnes () {
        return (super.getNum_alumnes()/super.getNgrups()) / super.getNsubgrups();
    }

    public boolean hoNecesita (Integer i) {
        return necessita[i-1];
    }

    public void canviNecessitat(Integer i, boolean b) {
        necessita[i-1] = b;
    }
}
