package su.problems.threads;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Akshat on 1/29/2015.
 */
public class TestPrintOddEvenNum {

    @Test
    public void testExecute() throws InterruptedException {
        int[] arr = new PrintOddEvenNum().execute();
        Assert.assertEquals(0,arr[0]);
        Assert.assertEquals(1,arr[1]);
        Assert.assertEquals(2,arr[2]);
        Assert.assertEquals(3,arr[3]);
        Assert.assertEquals(4,arr[4]);
        Assert.assertEquals(5,arr[5]);
        Assert.assertEquals(6,arr[6]);
        Assert.assertEquals(7,arr[7]);
        Assert.assertEquals(8,arr[8]);
        Assert.assertEquals(9,arr[9]);
        Assert.assertEquals(10,arr[10]);
    }


}
