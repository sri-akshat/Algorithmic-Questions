package su.algorithms;

import org.junit.Test;
import org.junit.Assert;

/**
 * Created by Akshat on 1/11/2015.
 */
public class TestKadane {

    @Test
    public void testComputeMaxContiguousSum()
    {
        Kadane kadane = new Kadane();
        int[] array = {2,-3,3,4,-8,1};
        Assert.assertEquals(7, kadane.computeMaxContiguousSum(array));
    }

    @Test
    public void testComputeMaxContiguousSum1()
    {
        Kadane kadane = new Kadane();
        int[] array = {3,-11,11,-5};
        Assert.assertEquals(11, kadane.computeMaxContiguousSum(array));
    }
}
