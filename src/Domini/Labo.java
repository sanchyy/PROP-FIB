package Domini;

//Sanchy
public class Labo extends Assignatura {

    private Integer numHores;
    private boolean[] necessita;

    public Labo(Integer num_hores, boolean[] necessita) {
        super();
        this.numHores   = num_hores;
        this.necessita   = necessita;
    }

    public Labo(String nomAssig, Integer num_alumnes, Integer ngrups, Integer nsub, Integer quatri, Integer nivell, Integer num_hores, boolean[] necessita) {
        super(nomAssig,num_alumnes,ngrups,nsub ,quatri, nivell);
        this.numHores   = num_hores;
        this.necessita   = necessita;
    }

    //Setters
    public void setNum_hores (Integer num_hores) {
        this.numHores = num_hores;
    }

    public void setNecessita(boolean[] necessita) {
        this.necessita = necessita;
    }



    //Getters
    public Integer getNum_hores () {
        return numHores;
    }

    public boolean[] getNecessitat() { return necessita; }


    //AUXILIAR FUNCTIONS

    public Integer getNum_alumnes () {
        return (super.getNumAlumnes()/super.getNgrups()) / super.getNsubgrups();
    }

    public boolean hoNecesita (Integer i) {
        return necessita[i-1];
    }

    public void canviNecessitat(Integer i, boolean b) {
        necessita[i-1] = b;
    }
}
