package Domain;

import Domain.Date;

public class Periode {

    private Date data_i;
    private Date data_fi;


    public Periode (Date d1, Date d2) {
        Integer any = d1.getAny();
        Integer mes = d1.getMes();
        Integer dia = d1.getDia();
        this.data_i  = new Date (any,mes,dia);

        Integer any = d1.getAny();
        Integer mes = d1.getMes();
        Integer dia = d1.getDia();
        this.data_fi = new Date (any,mes,dia);
    }

    public Periode () {
        this.data_i  = new Data();
        this.data_fi = new Data();
    }

    //Setters
    public void setData_i (Date d) {
        Integer any = d.getAny();
        Integer mes = d.getMes();
        Integer dia = d.getDia();

        this.data_i = new Date(any,mes,dia);
    }

    public void setData_fi (Date data_fi) {
        Integer any = d.getAny();
        Integer mes = d.getMes();
        Integer dia = d.getDia();

        this.data_fi = new Date(any,mes,dia);
    }

    //getters

    public Date getData_i () {
        return this.data_i;
    }

    public Date getData_fi () {
        return this.data_fi;
    }
}
