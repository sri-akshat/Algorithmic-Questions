package su.problems;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Akshat on 1/6/2015.
 */

/**
 Given a grid, find the maximum sum possible by picking a number from each row (such that no two consecutive number are from same column)

 1,1,1
 1,1,7
 1,8,9

 sum = 1+7+8 = 16
 **/

public class TestMagicGrid {

    @Test
    public void testEvaluate(){

        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        MagicGrid magicGrid = new MagicGrid();
        Assert.assertEquals(17, magicGrid.getMax(grid));
    }

    @Test
    public void testEvaluate1(){

        int[][] grid = {{1,1,1},{1,1,7},{1,8,9}};
        MagicGrid magicGrid = new MagicGrid();
        Assert.assertEquals(16, magicGrid.getMax(grid));
    }
}
