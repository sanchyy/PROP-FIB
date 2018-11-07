/*
package test.domini;

import Domini.Aula;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class TestingAula {

    private double expected;
    private double valueOne;
    private double valueTwo;

    public TestingAula(double e, double v1, double v2) {
        this.expected = e;
        this.valueOne = v1;
        this.valueTwo = v2;
    }

    @Parameters
    public static Collection<Double[]> getTestParameters () {
        return Arrays.asList( new Double[][] {
                { 0.0, 1.0, -1.0},  // expected, valueOne, valueTwo
                { 10.0, 90.0, -80.0},
                { 100.0, -1000.0, 1100.0},
                { 5.0, 2.0, 3.0},
                { 2.0, 1.0, 1.0},
        });
    }

    @Test
    public void crearAula() {
        Aula aula = new aula();
        assertEquals( expected, calculator.add(valueOne,valueTwo), 0 );
    }
}
*/