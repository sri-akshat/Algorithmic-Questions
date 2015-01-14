package su.algorithms;

/**
 * Created by Akshat on 1/11/2015.
 */
public class Kadane {
    public int computeMaxContiguousSum(int[] array) {

        int globalMax = 0;
        int sum = 0;
        for(int num : array)
        {
            sum += num;
            if(sum > 0){
                if(sum > globalMax)
                    globalMax = sum;
            }else{
                sum = 0;
            }
        }
        return globalMax;
    }

}
