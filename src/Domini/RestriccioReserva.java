package Domini;

public class RestriccioReserva extends Restriccio {

    private String  aula;
    private String  dia ;
    private Integer hora;

    public RestriccioReserva (String aula, String dia, Integer hora) {
        super(1);
        this.aula = aula;
        this.dia  = dia ;
        this.hora = hora;
    }

    public RestriccioReserva (String aula, String dia) {
        super(1);
        this.aula = aula;
        this.dia  = dia ;
        this.hora = null;
    }


    //Setters
    public void setAula(String aula) {
        this.aula = aula;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }


    //Getters
    public String getAula() {
        return aula;
    }

    public String getDia() {
        return dia;
    }

    public Integer getHora() {
        return hora;
    }


    //Auxiliar Functions
    public boolean compleixRestriccio() {
        return true;
    }

    public boolean esPotReserva (Integer h_i, Integer h_fi, String a, String d) {

        //Esta reservat tot el dia?
        if (hora == null)
            return !(dia.equals(d) && aula.equals(a));

         return !(pertany(h_i,h_fi,hora) && dia.equals(d) && aula.equals(a));
    }
}
