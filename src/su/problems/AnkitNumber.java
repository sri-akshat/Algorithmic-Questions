package su.problems;

import java.util.Scanner;

/**
 * Created by Akshat on 9/21/2014.
 */
public class AnkitNumber {

    public double evaluate(int num, int[] array)
    {
        double sum = 0;
        double freq = Math.pow(2,num-1);
        for(int i=1;i<=num;i++)
        {
            sum = sum+i*freq;
        }
        return sum;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        AnkitNumber ankitNumber = new AnkitNumber();
        for (int i = 0; i < num; i++) {

            int input = scanner.nextInt();
            int[] array = new int[input];
            for(int j=1;j<=input;j++)
            {
                array[j-1] = j;
            }
            System.out.printf("%.0f",ankitNumber.evaluate(input, array));
        }
    }

}
