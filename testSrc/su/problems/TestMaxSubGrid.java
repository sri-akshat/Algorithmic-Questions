package su.problems;

import org.junit.*;

/**
 * Created by Akshat on 1/11/2015.
 */
public class TestMaxSubGrid {


    @org.junit.Test
    public void testCompute()
    {
        int[][] grid = {{1, 2, -1, -4, -20},
                        {-8, -3, 4, 2, 1},
                        {3, 8, 10, 1, 3},
                        {-4, -1, 1, 7, -6}
        };

        MaxSubGrid maxSubGrid = new MaxSubGrid();
        Assert.assertEquals(29, maxSubGrid.compute(grid, grid[0].length, grid.length));
    }
}
