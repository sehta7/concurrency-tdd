package com.ja.app.synchronize;

import com.ja.app.synchronize.Przeploty;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Ola Podorska
 */
public class PrzeplotyTest {

    @Test(invocationCount = 100)
    public void testCountOfSaasdldo() {
        Przeploty p = new Przeploty();
        Assert.assertEquals(p.getSaldo(),1000000);
    }
}
