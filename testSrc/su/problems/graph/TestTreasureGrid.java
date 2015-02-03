package su.problems.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by Akshat on 2/3/2015.
 */
public class TestTreasureGrid {

    @Test
    public void testCompute()
    {
        int[][] grid = {{1,1,0},
                       {0,1,1},
                       {0,1,3}};

        TreasureGrid treasureGrid = new TreasureGrid();
        List<Map<Integer, Integer>> paths = treasureGrid.compute(grid, 0, 0, 3, new HashMap<>(), new HashSet<>());
        Assert.assertEquals(2, paths.size());
    }
}
