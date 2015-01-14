package su.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshat on 1/6/2015.
 */
public class MagicGrid {
    /**
     Given a grid, find the maximum sum possible by picking a number from each row (such that no two consecutive number are from same column)

     1,1,1
     1,1,7
     1,8,9

     sum = 1+7+8 = 16
     **/

    int maxSum = 0;

    public int getMax(int[][] array){
        List<Integer> arrayList = new ArrayList<Integer>();
        List<Integer> indexArray = new ArrayList<Integer>();

        int counter = 0;
        for(int i=0;i<array.length;i++)
            for(int j=0;j<array[i].length;j++)
            {
                arrayList.add(array[i][j]);
                indexArray.add(counter++);
            }
        evaluate(arrayList, indexArray, maxSum, array.length);
        return maxSum;
    }


    private void evaluate(List<Integer> array, List<Integer> indexArray, int sum, int size)
    {

        if(!array.isEmpty())
        {
            for(int i=0;i<array.size();i++)
            {
                Object[] result = getFilteredArray(array, indexArray, indexArray.get(i), size);
                evaluate((List<Integer>)result[0], (List<Integer>)result[1], sum+array.get(i), size);
            }
        }else{
            if(sum > maxSum)
                maxSum = sum;
        }
    }

    private Object[] getFilteredArray(List<Integer> array, List<Integer> indexArray, int index, int size)
    {
        List<Integer> newArray = new ArrayList<Integer>();
        List<Integer> newIndexArray = new ArrayList<Integer>();

        int row = index/size;
        int column = index%size;

        for(int i=0;i<indexArray.size();i++)
        {
            int currRow = indexArray.get(i)/size;
            int currColumn = indexArray.get(i)%size;

            if(row != currRow && !(Math.abs(currRow-row)<2 && column==currColumn))
            {
                newArray.add(array.get(i));
                newIndexArray.add(indexArray.get(i));
            }
        }

        Object[] result = new Object[2];
        result[0] = newArray;
        result[1] = newIndexArray;
        return result;
    }
}
