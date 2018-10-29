package Domain;

import java.util.Date;

public class Periode {

    private Date data_i;
    private Date data_fi;


    public Periode (Date data_i, Date data_fi) {
        this.data_i  = data_i;
        this.data_fi = data_fi;
    }

    //Setters
    public void setData_i (Date data_i) {
        this.data_i = data_i;
    }

    public void setData_fi (Date data_fi) {
        this.data_fi = data_fi;
    }

    //getters

    public Date getData_i () {
        return this.data_i;
    }

    public Date getData_fi () {
        return this.data_fi;
    }
}
