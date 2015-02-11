package su.problems;

import org.junit.Assert;

/**
 * Created by Akshat on 2/8/2015.
 */
public class TestPermutationSum {

    @org.junit.Test
    public void testCompute()
    {
        PermutationSum permutationSum = new PermutationSum();
        Assert.assertEquals(17,permutationSum.compute(6));
        Assert.assertEquals(1,permutationSum.compute(2));
        Assert.assertEquals(3,permutationSum.compute(3));
        Assert.assertEquals(23,permutationSum.compute(7));
        Assert.assertEquals(599981,permutationSum.compute(100000));
    }

    @org.junit.Test
    public void testCompute1()
    {
        PermutationSum permutationSum = new PermutationSum();
        Assert.assertEquals(11,permutationSum.compute(5));
    }
    @org.junit.Test
    public void testCompute2()
    {
        PermutationSum permutationSum = new PermutationSum();
        Assert.assertEquals(31,permutationSum.compute(8));
    }

}
