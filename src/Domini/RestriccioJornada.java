package Domini;

import java.util.ArrayList;

public class RestriccioJornada extends Restriccio {

    private Integer hora_inici;
    private Integer hora_fi;
    private ArrayList<Integer>[] grups;
    private boolean jornada; // 0 <- mati (8 -14) : 1 <- tarda (14-20)

    public RestriccioJornada(Integer hora_inici, Integer hora_fi, ArrayList<Integer>[] grups, boolean jornada) {
        super(2);
        this.hora_inici = hora_inici;
        this.hora_fi    = hora_fi;
        this.grups      = grups;
        this.jornada    = jornada;
    }

    //Setters
    public void setGrups(ArrayList<Integer>[] grups) {
        this.grups = grups;
    }

    public void setJornada(boolean jornada) {
        this.jornada = jornada;
    }

    public void setHora_inici(Integer hora_inici) {
        this.hora_inici = hora_inici;
    }

    public void setHora_fi(Integer hora_fi) {
        this.hora_fi = hora_fi;
    }

    //Getters
    public ArrayList<Integer>[] getGrups() {
        return grups;
    }

    public Integer getHora_inici() {
        return hora_inici;
    }

    public Integer getHora_fi() {
        return hora_fi;
    }

    public boolean getJornada() {
        return jornada;
    }

    //AUXILIAR FUNCTIONS
    public boolean compleixRestriccio() {
        return true;
    }

    public boolean esPotJornada() {
        //!Jornada <- (8h  - 14h)
        // Jornada <- (14h - 20h)
        int marge = hora_fi - hora_inici; //dura 1 o 2h la classe
        if (!jornada) {
            if (marge == 1)
                return pertany(8,13,hora_fi);
            return pertany(8,12,hora_fi);
        }
        if (marge == 1)
            return pertany(14,19,hora_fi);
        return pertany(14,18,hora_fi);

    }

}
