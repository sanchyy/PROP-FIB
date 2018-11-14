package Domini;

import java.util.ArrayList;

public class RestriccioReserva extends Restriccio {

    private String  aula;
    private Integer dia ;
    private Integer hora;

    public RestriccioReserva (String aula, Integer dia, Integer hora) {
        super(1);
        this.aula = aula;
        this.dia  = dia ;
        this.hora = hora;
    }

    public RestriccioReserva (String aula, Integer dia) {
        super(1);
        this.aula = aula;
        this.dia  = dia ;
        this.hora = null;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    public String getAula() {
        return aula;
    }

    public Integer getDia() {
        return dia;
    }

    public Integer getHora() {
        return hora;
    }

    public boolean compleixRestriccio(Sessio actual, ArrayList<Sessio> sessions, Integer dia, Integer hora, Horari horari) {
        return true;
    }

    public boolean compleixRestriccio(Sessio comp, Aula aula) {
        return true;
    }

    public boolean esPotReservar (Integer h_i, Integer h_fi, String aula, Integer dia) {
        //Esta reservat tot el dia?
        if (hora == null)
            return !(this.dia.intValue() == dia.intValue() && this.aula.equals(this.aula));

         return !(pertany(h_i,h_fi,hora) && this.dia.intValue() == dia.intValue() && this.aula.equals(aula));
    }
}