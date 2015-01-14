package su.problems;

/**
 * Created by Akshat on 10/18/2014.
 */
public class LongestIncreasingSubSequence {
    public String calculate(int[] array) {

        int[] size = new int[array.length];
        String[] sequence = new String[array.length];
        int maxI = 0;

        for(int i=0;i<array.length;i++)
        {
            size[i] = 1;
            sequence[i] = ""+array[i];
        }

        for(int i=1; i<array.length; i++)
            for(int j=0; j<i; j++)
            {
                if(array[i] >= array[j] && size[i] <= size[j])
                {
                    size[i]++;
                    sequence[i] = sequence[j] + "," + array[i];
                    System.out.println("sequence for "+array[i]+" = "+sequence[i].toString());
                    if(size[maxI] < size[i])
                        maxI = i;
                }
            }

        return sequence[maxI];
    }
}
