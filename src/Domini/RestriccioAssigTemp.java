package Domini;

import java.util.ArrayList;

public class RestriccioAssigTemp extends Restriccio {
    private Integer dia;
    private Integer hora;
    private String  nomAssig;

    public RestriccioAssigTemp(Integer dia, Integer hora, String nomAssig) {
        super(3);
        this.dia      = dia;
        this.hora     = hora;
        this.nomAssig = nomAssig;
    }

    //Una assignatura vagi a un dia, però no importi la hora
    public RestriccioAssigTemp (Integer dia, String nomAssig) {
        super(3);
        this.dia      = dia;
        this.hora     = null;
        this.nomAssig = nomAssig;
    }

    //Setters
    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    public void setNomAssig(String nomAssig) {
        this.nomAssig = nomAssig;
    }

    //Getters
    public Integer getDia() {
        return dia;
    }

    public Integer getHora() {
        return hora;
    }

    public String getNomAssig() {
        return nomAssig;
    }

    //AUXILIAR FUNCTIONS
    public boolean compleixRestriccio(Sessio comp, ArrayList<Sessio> sessions, Horari horari) {
        return true;
    }

    public boolean compleixRestriccio(Sessio comp, Aula aula) {
        return true;
    }

    public boolean esPotAssigTemp(Integer dia, Integer hora, String nomAssig) {

        if (this.hora == null) { //Tot el dia
            return this.dia.intValue() == dia.intValue() && this.nomAssig.equals(nomAssig);
        }

        return this.dia.intValue() == dia.intValue() && this.hora.intValue() == hora.intValue() && this.nomAssig.equals(nomAssig);

    }

}