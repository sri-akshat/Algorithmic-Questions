package su.problems;

import java.util.Scanner;

/**
 * Created by Akshat on 8/23/2014.
 */
public class AniruddhaQueue {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0; i<T; i++)
        {
            int sum = 0;
            int days = scanner.nextInt();
            int[] array = new int[100000];
            int lastNonZeroDay = 0;
            for(int j=0; j<days; j++)
            {
                array[j] = scanner.nextInt();
                if(array[j] > 0)
                {
                    lastNonZeroDay = j+1;
                }
                sum = sum + array[j];
            }

            int input = scanner.nextInt();
            int rem = input % sum;

            if(input == 0)
            {
                System.out.println(1);
            }else{
                if(rem == 0)
                {
                    System.out.println(lastNonZeroDay);
                }else {
                    int cumulative = 0;
                    for (int j = 0; j < days; j++) {
                        cumulative = cumulative + array[j];
                        if(rem <= cumulative)
                        {
                            System.out.println(j+1);
                            break;
                        }
                    }
                }
            }

        }

    }
}
