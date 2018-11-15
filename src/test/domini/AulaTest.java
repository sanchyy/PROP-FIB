package test.domini;

import Domini.Aula;
import Domini.CaracteristiquesAula;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AulaTest {
    @Test
    public void checkAula() {
        String  nom = "A500";
        Integer cap = 20;
        String  tip = "laboratori";
        ArrayList<CaracteristiquesAula> car= null;

        Aula a = new Aula(nom,cap,tip,car);
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

    @Test
    public void checkTipus() {
        Aula a = new Aula();
        a.setTipus("Laboratori");
        Assert.assertEquals("Laboratori",a.getTipus());
    }

}