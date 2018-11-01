package Domain;

import Domain.Date;

public class Date {

    private Integer dia;
    private Integer mes;
    private Integer any;

    //Constructora
    public Date (Integer any, Integer mes, Integer dia) {
        this.any = any;
        this.mes = mes;
        this.dia = dia;
    }

    public Date () {
        this.any = null;
        this.mes = null;
        this.dia = null;
    }

    //Setters
    public void setDia (Integer dia) {
        this.dia = dia;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public void setAny(Integer any) {
        this.any = any;
    }

    //Getters

    public Integer getAny() {
        return any;
    }

    public Integer getDia() {
        return dia;
    }

    public Integer getMes() {
        return mes;
    }

    //FUNCIONS AUXILIARS

    //Return true si data "objecte" és més petita
    public boolean compareDate(Date d) {
        Integer dia = d.getDia();
        Integer mes = d.getMes();
        Integer any = d.getAny();
        if (this.any < any)
            return true;
        if (this.any == any) {
            if (this.mes < mes)
                return true;
            if (this.mes == mes) {
                return this.dia < dia;
            }
        }
        return false;
    }

    //True si d1 < d2
    public static boolean compareDate(Date date1, Date date2) {
        Integer d1 = date1.getDia();
        Integer m1 = date1.getMes();
        Integer a1 = date1.getAny();

        // Integer d2 = date2.getDia();
        // Integer m2 = date2.getMes();
        // Integer a2 = date2.getAny();

        return date1.compareDate(date2);
    }

    //return true si si son iguals
    public boolean isEqual(Date d) {
        Integer dia = d.getDia();
        Integer mes = d.getMes();
        Integer any = d.getAny();

        return (this.dia == Dia && this.mes == mes && this.any == any);
    }

    public static boolean isValid (Date d) {
        Integer dia = d.getDia();
        Integer mes = d.getMes();
        Integer any = d.getAny();

        if (any < 0) return false;
        if (mes < 1 || mes > 12) return false;
        if (dia < 1 || dia > 31) return false;

        switch (mes) {
            case 4:
            case 6:
            case 9:
            case 11:
                return dia < 31;
            case 2:
                return ((any%400 == 0 || (any%4 == 0 && any%100 != 0)) ? return < 28 : return < 29);
            default:
                return true;
        }
    }
}
