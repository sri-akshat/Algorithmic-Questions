package su.problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Akshat on 1/23/2015.
 */
public class BasinHill {

    public Integer[] compute(int[][] grid) {

        Map<Integer, Integer> basinMap = new HashMap<>();
        int identifier = 'a';
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid.length;j++)
            {
                if(grid[i][j]!=-1) {

                    traverseCanal(i,j,grid,basinMap,0,-identifier++);
                }
            }
        }

        List<Integer> basinArea = (List<Integer>) basinMap.values();
        Collections.sort(basinArea);
        Integer[] arr = (Integer[]) basinArea.toArray();
        return arr;
    }

    private void traverseCanal(int i, int j, int[][] grid, Map<Integer, Integer> basinMap, int count, int identifier)
    {
        int curr = grid[i][j];
        int top = i==0?Integer.MAX_VALUE:grid[i-1][j];
        int bottom = i==grid.length-1?Integer.MAX_VALUE:grid[i+1][j];
        int left = j==0?Integer.MAX_VALUE:grid[i][j-1];
        int right = j==grid.length-1?Integer.MAX_VALUE:grid[i][j+1];

        //base condition - if basin
        if(curr<top && curr<bottom && curr<right && curr<left)
        {

        }
    }
}
