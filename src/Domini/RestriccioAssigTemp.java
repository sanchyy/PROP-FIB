package Domini;

import java.util.ArrayList;

public class RestriccioAssigTemp extends Restriccio {
    private Integer dia;
    private Integer hora;


    public RestriccioAssigTemp(Integer dia, Integer hora) {
        super(3);
        this.dia      = dia;
        this.hora     = hora;
    }

    //Una assignatura vagi a un dia, però no importi la hora
    public RestriccioAssigTemp (Integer dia) {
        super(3);
        this.dia      = dia;
        this.hora     = null;
    }



    //Setters

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }



    //Getters


    public Integer getDia() {
        return dia;
    }

    public Integer getHora() {
        return hora;
    }


    //AUXILIAR FUNCTIONS
    public boolean compleixRestriccio() {
        return true;
    }

    public boolean esPotAssigTemp(Integer dia, Integer hora) {

        if (hora == null) { //Tot el dia
            return this.dia.intValue() == dia.intValue();
        }

        return this.dia.intValue() == dia.intValue() && this.hora.intValue() == hora.intValue();

    }

}
