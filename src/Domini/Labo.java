package Domini;

//Sanchy
public class Labo extends Assignatura {

    private Integer num_hores;
    private Integer nLabs;
    private Integer freq;
    private boolean[] necessita;

    public Labo(String nomAssig, boolean quatri, Integer nivell, Integer num_hores, Integer nLabs, Integer freq, boolean[] necessita) {
        super();
        this.num_hores   = num_hores;
        this.nLabs       = nLabs;
        this.necessita   = necessita;
        this.freq        = freq;
    }

    //Setters
    public void setNum_hores (Integer num_hores) {
        this.num_hores = num_hores;
    }

    public void setnLabs (Integer nLabs) {
        this.nLabs = nLabs;
    }

    public void setNecessita(boolean[] necessita) {
        this.necessita = necessita;
    }

    public void setFreq(Integer freq) {
        this.freq = freq;
    }


    //Getters
    public Integer getNum_hores () {
        return num_hores;
    }

    public Integer getnLabs () {
        return nLabs;
    }

    public Integer getFreq() {
        return freq;
    }

    public boolean[] getNecessitat() { return necessita; }


    //AUXILIAR FUNCTIONS

    public Integer getNum_alumnes () {
        return super.getNum_alumnes() / super.getNsubgrups();
    }

    public boolean hoNecesita (Integer i) {
        return necessita[i];
    }

    public void canviNecessitat(Integer i, boolean b) {
        necessita[i] = b;
    }
}
