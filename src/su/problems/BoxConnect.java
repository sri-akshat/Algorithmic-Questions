package su.problems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Akshat on 8/24/2014.
 */
public class BoxConnect {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        int[] array = new int[N+1];
        int counter = 1001;
        Set<Integer> zeroArray = new HashSet<Integer>();

        for(int i=1; i<N+1; i++)
        {
            array[i] = i;
        }

        for (int k = 0; k < Q; k++) {

            int i = scanner.nextInt();
            int j = scanner.nextInt();
            boolean output = true;

            if(i==j)
                output = false;
            else if(array[i]>1000 || array[i]<0 || array[j]<0 || array[j]>1000)
                output = false;
            else {
                if (i > j) {
                    int tmp = i;
                    i = j;
                    j = tmp;
                }

                int sum = 0;
                for (int pos : zeroArray) {
                    if (pos > i && pos < j)
                    {
                        sum = sum + array[pos];
                    }
                }
                if(sum != 0)
                    output = false;
            }


            if(output)
            {
                System.out.println("YES");
                array[i] = counter;
                array[j] = -counter;
                zeroArray.add(i);
                zeroArray.add(j);
                counter+=100;
            }else{
                System.out.println("NO");
            }
        }
    }
}
