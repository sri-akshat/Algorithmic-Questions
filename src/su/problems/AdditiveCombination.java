package su.problems;

import java.util.Set;

/**
 * Created by Akshat on 6/7/2014.
 */
public class AdditiveCombination {

    public void evaluate(int num, int input, int[] arr, int level)
    {
        if(input - num < 1)
        {
            System.out.println("");
            for(int ele=0; ele<level ; ele++)
            {
                System.out.print(arr[ele] + ",");
            }
        }

        for(int i=1; i<= (input - num); i++)
        {
            System.out.println("level="+level+" i="+i+" num="+num + " input-num="+(input-num));
            arr[level] = i;
            evaluate(num + i, input, arr, level+1);
        }
    }

    public static void main(String[] args)
    {
        AdditiveCombination additiveCombination = new AdditiveCombination();
        int[] arr = new int[500];
        additiveCombination.evaluate(0, 10, arr, 0);
    }
}
