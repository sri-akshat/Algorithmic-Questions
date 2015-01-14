package su.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Akshat on 7/27/2014.
 */
public class SwapIt {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int i=0; i< N; i++)
        {
            int num = scanner.nextInt();
            int swaps = scanner.nextInt();

            List<Integer> list = new ArrayList<Integer>();
            for(int j=0; j<num; j++)
            {
                list.add(scanner.nextInt());
            }

            System.out.println(listToString(generate(list, swaps)));
        }
        scanner.close();
    }

    public static List<Integer> generate(List<Integer> array, int swaps) {

        int minNumberIndexInSwapLimit = getMinNumberIndexInSwapLimit(array, swaps);
        int tmp = array.get(minNumberIndexInSwapLimit);
        for(int i=minNumberIndexInSwapLimit; i > 0; i--)
        {
            array.set(i, array.get(i-1));
        }
        array.set(0, tmp);

        if(swaps > minNumberIndexInSwapLimit && array.size() > 1)
        {
            generate(array.subList(1, array.size()), swaps - minNumberIndexInSwapLimit);
        }

        return array;
    }

    private static int getMinNumberIndexInSwapLimit(List<Integer> array, int swaps) {
        if(swaps >= array.size())
            swaps = array.size() - 1;

        int minIndex = 0;
        for(int i=1; i<swaps + 1; i++)
        {
            if(array.get(i) < array.get(minIndex))
            {
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static String listToString(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int ele : list)
        {
            stringBuilder.append(ele + " ");
        }
        return stringBuilder.toString();
    }
}
