package su.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Akshat on 1/30/2015.
 */
public class RSum {

    private static Map<Integer, Integer> factMap = new HashMap<>();
    static{
        factMap.put(0,0);
        factMap.put(1,1);
        factMap.put(2,2);
        factMap.put(3,6);
        factMap.put(4,6);
        factMap.put(5,3);
        factMap.put(6,9);
        factMap.put(7,9);
    }
    public int compute(int x, int y) {

        int sigmaRSum = 0;

        if(x>7)
        {
            return 9*(y-x+1);
        }else if(y>7){

            for(int i=x;i<=7;i++)
            {
                sigmaRSum += factMap.get(i);
            }

            return sigmaRSum + 9*(y-7);
        }else {

            for (int i = x; i <= y; i++) {
                sigmaRSum += factMap.get(i);
            }
            return sigmaRSum;
        }
    }

    public static void main(String[] args)
    {
        RSum rSum = new RSum();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for(int i=0;i<num;i++)
        {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(rSum.compute(x,y));
        }
    }
}
