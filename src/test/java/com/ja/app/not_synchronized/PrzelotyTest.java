package com.ja.app.not_synchronized;

import com.ja.app.not_synchronized.Przeloty;
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
        Assert.assertEquals(p.getSaldo(),1000000);
    }

}