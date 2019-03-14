package com.ja.app;

import com.ja.app.dziala.Przeloty;
import com.ja.app.nieddziala.Przeploty;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Ola Podorska
 */

@Test
public class PrzelotyTest {

    @Test(invocationCount = 100)
    public void testCountOfSaldo() {
        Przeloty p = new Przeloty();
//        System.out.println(p.getSaldo());
        Assert.assertEquals(p.getSaldo(),1000000);
    }

}