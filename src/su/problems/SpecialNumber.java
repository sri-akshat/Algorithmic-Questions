package su.problems;

import su.algorithms.NewtonRaphson;

import java.util.*;

/**
 * Created by Akshat on 5/15/2014.
 *
 * Game of numbers is a game where you are given two integers (X and Y), and you have to print the number of special numbers between X and Y both inclusive.
 The property of a special numbers is as follows:
 A special number is not divisible by any number of the form Z*Z where (Z>1).

 Input:
 T, the number of testcases. Each testcase consists of two space separated integers denoting X and Y.

 Output: The required answer in one line for each testcase.

 Constraints:
 1 <= T <= 100
 1 <= X,Y <= 10^9
 0 <= |X-Y| <= 10^6

 Sample Input (Plaintext Link)
 1
 1 10
 Sample Output (Plaintext Link)
 7
 Explanation
 In given testcase, 4,8 and 9 are not special.
 *
 */
public class SpecialNumber {

    Set<Double> perfectSquareArray = new LinkedHashSet<Double>();
    Set<Double> notSpecial = new LinkedHashSet<Double>();
    double notSpecialCount = 0;
    protected double evaluate(double x, double y)
    {
        NewtonRaphson newtonRaphson = new NewtonRaphson();
        double root;
        int count = 0;
        for(double i=2;i<y+1;i++)
        {
            root = newtonRaphson.evaluate(i/2, i);
            if(Math.pow(Math.round(root),2) == i && !perfectSquareArray.contains(root))
            {
                perfectSquareArray.add(i);
                count++;
            }
        }

        Set<Double> notSpecialDups = new HashSet<Double>();

        for(double i : perfectSquareArray)
        {
            for(double j : perfectSquareArray)
            {
                if(j > i)
                    break;
                if(i!=j)
                {
                    if(i%j == 0)
                    {
                        notSpecialDups.add(i);
                        break;
                    }
                }
            }
        }

        for(double num : notSpecialDups)
        {
            perfectSquareArray.remove(num);
        }

        for(double i : perfectSquareArray)
        {
            int start = (int) (x/i);
            for(double j = start*i; j <= y; j+=i)
            {
                if(j>=x && j<=y)
                {
                    notSpecial.add(j);
                }
            }
        }


        System.out.println(notSpecial.size());
        return y - x - notSpecial.size() + 1;
    }

    public static void main(String[] args){

        SpecialNumber specialNumber = new SpecialNumber();
        System.out.println(specialNumber.evaluate(1, 9000));
    }
}
