package su.problems;

import org.junit.Assert;

/**
 * Created by Akshat on 1/30/2015.
 */
public class TestRSum {

    @org.junit.Test
    public void testCompute()
    {
        RSum obj = new RSum();
        Assert.assertEquals(9,obj.compute(1, 3));
        Assert.assertEquals(12,obj.compute(3, 4));
        Assert.assertEquals(45,obj.compute(1, 8));
    }

    @org.junit.Test
    public void testCompute1()
    {
        RSum obj = new RSum();
        Assert.assertEquals(8964,obj.compute(1, 999));
        Assert.assertEquals(89964,obj.compute(1, 9999));
        Assert.assertEquals(8999973,obj.compute(0, 1000000));
    }
}
