package su.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Akshat on 10/18/2014.
 */
public class TestLongestIncreasingSubSequence {

    @Test
    public void testCalculate()
    {
        int[] array = {5,2,8,6,3,6,9,7};
        String expected = "5,6,6,9";
        LongestIncreasingSubSequence subSequence = new LongestIncreasingSubSequence();
        Assert.assertEquals(expected, subSequence.calculate(array));
    }
}
