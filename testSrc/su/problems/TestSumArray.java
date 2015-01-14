package su.problems;

import org.junit.Assert;

/**
 * Created by Akshat on 1/14/2015.
 */
public class TestSumArray {

    @org.junit.Test
    public void testCompute()
    {
        int[] array = {10, -2, -1, 3};
        SumArray sumArray = new SumArray();
        Assert.assertTrue(sumArray.compute(array));
    }

    @org.junit.Test
    public void testCompute1()
    {
        int[] array = {10, -2, 1};
        SumArray sumArray = new SumArray();
        Assert.assertTrue(sumArray.compute(array));
    }

    @org.junit.Test
    public void testCompute2()
    {
        int[] array = {10, 2, 1};
        SumArray sumArray = new SumArray();
        Assert.assertFalse(sumArray.compute(array));
    }
}
