package Domini;

public class RestriccioReserva extends Restriccio {

    String  aula;
    String  dia ;
    Integer hora;

    public RestriccioReserva (String aula, String dia, Integer hora) {
        this.aula = aula;
        this.dia  = dia ;
        this.hora = hora;
    }

    public RestriccioReserva (String aula, String dia) {
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
/*
    public boolean esPot() {

    }
    */
}
