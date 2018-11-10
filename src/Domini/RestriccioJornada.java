package Domini;

import java.util.ArrayList;

public class RestriccioJornada extends Restriccio {

    private Integer hora;
    private ArrayList<Integer>[] grups;
    private boolean jornada; // 0 <- mati (8 -14) : 1 <- tarda (14-20)

    public RestriccioJornada(Integer hora, ArrayList<Integer>[] grups, boolean jornada) {
        super(1);
        this.hora    = hora;
        this.grups   = grups;
        this.jornada = jornada;

    }


    //Setters
    public void setGrups(ArrayList<Integer>[] grups) {
        this.grups = grups;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    public void setJornada(boolean jornada) {
        this.jornada = jornada;
    }

    //Getters
    public ArrayList<Integer>[] getGrups() {
        return grups;
    }

    public Integer getHora() {
        return hora;
    }

    public boolean getJornada() {
        return jornada;
    }

    //AUXILIAR FUNCTIONS
    public boolean compleixRestriccio() {
        return true;
    }

    public boolean esPotJornada() {
        //!Jornada <- (8h - 14h )
        // Jornada <- (14h - 20h)
        return (!jornada ? (hora >= 8 && hora < 14) : (hora >= 14 && hora < 20));
    }
}
