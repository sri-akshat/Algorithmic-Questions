package su.problems;

import org.junit.Assert;

import java.util.List;

/**
 * Created by Akshat on 1/23/2015.
 */
public class TestBasinHill {

    @org.junit.Test
    public void testComputeBasins()
    {
        int[][] grid = {
                {1, 0, 2, 5, 8},
                {2, 3, 4, 7, 9},
                {3, 5, 7, 8, 9},
                {1, 2, 5, 4, 2},
                {3, 3, 5, 2, 1}};
        BasinHill basinHill = new BasinHill();
        List<Integer> arr = basinHill.compute(grid);
        Assert.assertEquals(11,arr.get(2).intValue());
        Assert.assertEquals(7,arr.get(1).intValue());
        Assert.assertEquals(7,arr.get(0).intValue());
    }
}
