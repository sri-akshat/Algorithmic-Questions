package su.problems;

import org.junit.Assert;

/**
 * Created by Akshat on 1/12/2015.
 */
public class TestPow {

    @org.junit.Test
    public void testCompute()
    {
        double x = 7;
        double y = 3;

        Assert.assertEquals(Math.pow(x,y), new Pow().compute(x,y),1);
    }
}
