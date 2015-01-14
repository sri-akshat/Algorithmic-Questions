package su.problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Akshat on 1/3/2015.
 *
 * 1
 * 121
 * 1331
 * 14641
 * 15101051
 *
 *
 */
public class TestPascalsTriangle {

    @Test
    public void testGenPascalTriangle()
    {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<List<Integer>> arr = pascalsTriangle.generate(15);
        Assert.assertEquals(1,arr.get(0).size());
        Assert.assertEquals(3,arr.get(1).size());
        Assert.assertEquals(4,arr.get(2).size());
        Assert.assertEquals(3,arr.get(2).get(1).intValue());
        Assert.assertEquals(3,arr.get(2).get(2).intValue());
    }

}
