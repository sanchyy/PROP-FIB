package test.domini;

import main.Domini.Aula;
import main.Domini.CaracteristiquesAula;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AulaTest {
    @Test
    public void checkAula() {
        String  nom = "A500";
        Integer cap = 20;
        ArrayList<CaracteristiquesAula> car= null;

        Aula a = new Aula(nom,cap,car);
        Assert.assertNotNull(a);
    }

    @Test
    public void checkNom() {
        Aula a = new Aula();
        a.setNom("A500");
        Assert.assertEquals("A500", a.getNom());
    }

    @Test
    public void checkcapacitat() {
        Aula a = new  Aula();
        a.setCapacitat(20);
        Assert.assertEquals(20,a.getCapacitat().intValue());
    }

}