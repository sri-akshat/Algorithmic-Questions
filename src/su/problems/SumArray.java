package su.problems;

/**
 * Created by Akshat on 1/14/2015.
 */
/** {10, -2, -1, 3} -> true
 {10, -2, 1} -> true -2 + 1 +1 =0 **/

public class SumArray{

    public boolean compute(int[] array)
    {
        int[] explodedArray = getExplodedArray(array);
        return traverseArray(explodedArray, 0, 0, false);
    }

    private boolean traverseArray(int[] array, int count, int sum, boolean result)
    {
        if(result)
            return result;

        if(count==3)
        {
            if(sum == 0)
                return true;
            else
                return false;
        }

        boolean finalResult = false;
        for(int curr:array)
        {
            int[] newArr = new int[array.length-1];
            System.arraycopy(array,1,newArr,0,array.length-1);
            finalResult = traverseArray(newArr, count+1, sum+curr, result);
            if(finalResult)
                break;
        }

        return finalResult;
    }

    private int[] getExplodedArray(int[] array)
    {
        int[] newArray = new int[array.length*3];
        for(int y=0;y<array.length;y++)
        {
            for(int i=y*3;i<y*3+3;i++)
            {
              newArray[i] = array[y];
            }
        }
        return newArray;
    }


}
