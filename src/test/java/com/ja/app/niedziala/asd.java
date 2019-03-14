package com.ja.app.niedziala;

import com.ja.app.nieddziala.Przeploty;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Ola Podorska
 */
public class asd {

    @Test(invocationCount = 100)
    public void testCountOfSaasdldo() {
        Przeploty p = new Przeploty();
//        System.out.println(p.getSaldo());
        Assert.assertEquals(p.getSaldo(),1000000);
    }
}
