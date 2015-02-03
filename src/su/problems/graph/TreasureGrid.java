package su.problems.graph;

import java.util.*;

import static java.util.Map.Entry;

/**
 * Created by Akshat on 2/3/2015.
 */
public class TreasureGrid
{
    static List<Map<Integer, Integer>> paths = new ArrayList<>();
    public List<Map<Integer, Integer>> compute(int[][] grid, int x, int y, int end, Map<Integer, Integer> path, Set<String> alreadyTraversed)
    {
        if(grid[x][y] == end)
        {
           path.put(x,y);
           paths.add(path);
        }else {

            for (Entry<Integer, Integer> entry : getTraversablePaths(grid, x, y))
            {
//                if(!alreadyTraversed.contains(entry.getKey()+","+entry.getValue())) {
                    Map<Integer, Integer> newPath = new LinkedHashMap<>(path);
                    System.out.println(entry.getKey()+","+entry.getValue());
                    newPath.put(entry.getKey(), entry.getValue());
                    Set<String> newAlreadyTraversedPath = new HashSet<>(alreadyTraversed);
                    newAlreadyTraversedPath.add(entry.getKey()+","+entry.getValue());
                    compute(grid, entry.getKey(), entry.getValue(), end, newPath, newAlreadyTraversedPath);
//                }
            }
        }

        return paths;
    }

    private Set<Entry<Integer, Integer>> getTraversablePaths(int[][] grid, int x, int y) {

        Map<Integer, Integer> map = new LinkedHashMap<>();
        if(x+1 < grid.length && grid[x+1][y]>0)
        {
            map.put(x+1,y);
        }
        if(x-1 > -1 && grid[x-1][y]>0)
        {
            map.put(x-1,y);
        }
        if(y+1 < grid.length && grid[x][y+1]>0)
        {
            map.put(x,y+1);
        }
        if(y-1 > -1 && grid[x][y-1]>0)
        {
            map.put(x,y-1);
        }

        return map.entrySet();
    }
}
