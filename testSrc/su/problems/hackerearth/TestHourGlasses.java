package su.problems.hackerearth;

import org.junit.Test;
import org.junit.Assert;


/**
 * Created by asivastava6 on 2/13/16.
 */
public class TestHourGlasses {

    @Test
    public void testCompute(){

        int sizeA = 7, sizeB = 9;
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        Assert.assertEquals("00000010101011111111", new HourGlasses().compute(sizeA, sizeB, array));
    }
}
