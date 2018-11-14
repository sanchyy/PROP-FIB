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
        String  nom = "a500";
        Integer cap = 20;
        String  tip = "laboratori";
        ArrayList<CaracteristiquesAula> car= null;

        Aula a = new Aula(nom,cap,tip,car);
        Assert.assertNotNull(a);
    }

    
}