package test.domini;

import Domini.*;

import java.util.*;
import static org.junit.Assert.*;

import Domini.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class TestingPeriode {
    private Date expected;
    private Date dateInit;
    private Date dateFi;

    public void Testing_setPeriode(Date e, Date di, Date df) {
        this.expected = e;
        this.dateInit = di;
        this.dateFi = df;
    }

    @Parameters
    public static Collection<Double[]> getTestParameters () {
        return Arrays.asList( new Date[][]{
                {},
        }
        }

    @test
    public void testsomething(){

    }
}
