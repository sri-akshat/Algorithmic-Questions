package su.problems;

import java.util.Scanner;

/**
 * Created by Akshat on 2/6/2015.
 */
public class LuckyNumber {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        LuckyNumber luckyNumber = new LuckyNumber();
        int N = scanner.nextInt();
        for(int i=0;i< N;i++) {
            System.out.println(luckyNumber.compute(scanner.next()));
        }
    }


    public String compute(String number) {

        int[] digits = new int[number.length()];
        StringBuilder newNumber = new StringBuilder();
        int cnt = 0;
        for(int i : number.toCharArray())
        {
            digits[cnt++] = i-48;
        }

        for(int i=digits.length-1; i>-1 ;i--) {
            int digit = digits[i];
            if (digit < 3) {
                newNumber.append(3);
            } else if (digit == 4) {
                newNumber.append(5);
            } else if (digit >= 5) {
                if (i == 0) {
                    if (digit != 5)
                        newNumber.append(33);
                    else
                        newNumber.append(digit);
                } else {
                    newNumber.append(3);
                    digits[i - 1]++;
                    newNumber = new StringBuilder();
                    for(int k=i;k<digits.length;k++)
                    {
                        newNumber.append(3);
                    }
                }
            } else {
                newNumber.append(digit);
            }

        }
        return newNumber.reverse().toString();
    }
}
