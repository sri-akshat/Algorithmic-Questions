package su.problems;

import java.util.*;

/**
 * Created by Akshat on 1/23/2015.
 */
public class BasinHill {

    public List<Integer> compute(int[][] grid) {

        int[][] markerGrid = new int[grid.length][grid.length];
        Map<Integer, Integer> basinMap = new HashMap<>();
        int identifier = Integer.MAX_VALUE - grid.length*grid.length;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid.length;j++)
            {
                if(markerGrid[i][j]>-1) {

                    traverseCanal(i,j,grid, markerGrid,basinMap,-identifier++);
                }
            }
        }

        List<Integer> basinArea = new ArrayList<Integer>(basinMap.values());
        Collections.sort(basinArea);
        return basinArea;
    }

    private int traverseCanal(int i, int j, int[][] grid, int[][] markerGrid, Map<Integer, Integer> basinMap, int identifier)
    {
        int markerCurr = markerGrid[i][j];
        int curr = grid[i][j];
        int top = i==0?Integer.MAX_VALUE:grid[i-1][j];
        int bottom = i==grid.length-1?Integer.MAX_VALUE:grid[i+1][j];
        int left = j==0?Integer.MAX_VALUE:grid[i][j-1];
        int right = j==grid.length-1?Integer.MAX_VALUE:grid[i][j+1];

        // if already part of basin
        if(markerCurr < 0)
        {
            return markerCurr;
        }

        //if new sink
        if(isSink(curr, top, bottom, left, right))
        {
            markCell(i, j, markerGrid, basinMap, identifier);
            return identifier;
        }

        // recurse until basin found
        int marker = traverseCanal(getNextI(curr, top, bottom, left, right, i), getNextJ(curr, top, bottom, left, right, j), grid, markerGrid, basinMap, identifier);
        if(marker < 0)
        {
            markCell(i, j, markerGrid, basinMap, marker);
        }
        return marker;
    }

    private int getNextI(int curr, int top, int bottom, int left, int right, int i) {
        int[] arr = getSortedArray(top, bottom, left, right);
        if(arr[0]<curr){
            if(arr[0]==top)
                return i-1;
            if(arr[0]==bottom)
                return i+1;
        }
        return i;
    }

    private int[] getSortedArray(int top, int bottom, int left, int right) {
        int[] arr = new int[]{top,left,bottom,right};
        Arrays.sort(arr);
        return arr;
    }

    private int getNextJ(int curr, int top, int bottom, int left, int right, int j) {
        int[] arr = getSortedArray(top, bottom, left, right);
        if(arr[0]<curr){
            if(arr[0]==left)
                return j-1;
            if(arr[0]==right)
                return j+1;
        }
        return j;
    }

    private void markCell(int i, int j, int[][] grid, Map<Integer, Integer> basinMap, int identifier)
    {
        System.out.println("marking "+i+","+j+"="+grid[i][j]+" with "+identifier);
        grid[i][j] = identifier;
        if(basinMap.get(identifier)==null)
            basinMap.put(identifier, 0);
        basinMap.put(identifier, basinMap.get(identifier)+1);
    }

    private boolean isSink(int curr, int top, int bottom, int left, int right) {
        return Math.abs(curr)<Math.abs(top) && Math.abs(curr)<Math.abs(bottom)
                && Math.abs(curr)<Math.abs(right) && Math.abs(curr)<Math.abs(left);
    }
}
