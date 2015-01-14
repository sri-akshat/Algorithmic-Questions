package su.problems;

import su.algorithms.Kadane;

/**
 * Created by Akshat on 1/11/2015.
 */
public class MaxSubGrid {



    public int compute(int[][] grid, int columns, int rows) {

        Kadane kadane = new Kadane();
        int maxSum = 0;
        for(int i=0;i<columns;i++)
        {
            int[] arr = new int[rows];
            int sum = 0;
            for(int j=i;j<columns;j++)
            {
                for(int m=0;m<rows;m++)
                    arr[m] += grid[m][j];

                sum = kadane.computeMaxContiguousSum(arr);
                if(sum>maxSum)
                    maxSum = sum;
            }

        }
        return maxSum;
    }
}
