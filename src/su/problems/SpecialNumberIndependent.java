package su.problems;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Akshat on 5/16/2014.
 */
public class SpecialNumberIndependent {


    protected double evaluate(double x, double y)
    {
        Set<Double> perfectSquareArray = new LinkedHashSet<Double>();
        Set<Double> notSpecial = new LinkedHashSet<Double>();
        double notSpecialCount = 0;

        double root;
        int count = 0;
        for(double i=2;i<y+1;i++)
        {
            root = evaluateRoot(i/2, i);
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


//        System.out.println(notSpecial.size());
        return y - x - notSpecial.size() + 1;
    }

    public static void main(String[] args){

        SpecialNumberIndependent specialNumber = new SpecialNumberIndependent();
        Scanner scanner = new Scanner(System.in);
        int records = scanner.nextInt();
        for(int i=0; i<records ;i++)
        {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println((int)specialNumber.evaluate(x, y));
        }
    }

    //our functio f(x)
    double f(double x, double w) {
        return x*x - w;
    }

    //f'(x) /*first derivative*/
    double fprime(double x) {
        return 2*x;
    }

    public double evaluateRoot(double x, double w) {
        double tolerance = .000000001; // Stop if you're close enough
        int max_count = 200; // Maximum number of Newton's method iterations

        for( int count=1;
            //Carry on till we're close, or we've run it 200 times.
             (Math.abs(f(x, w)) > tolerance) && ( count < max_count);
             count ++)  {

            x= x - f(x, w)/fprime(x);  //Newtons method.
//            System.out.println("Step: "+count+" x:"+x+" Value:"+f(x, w));
        }
        //OK, done let's report on the outcomes.
        if( Math.abs(f(x, w)) <= tolerance) {
//            System.out.println("Zero found at x="+x);
            return x;
        } else {
//            System.out.println("Failed to find a zero");
            return 0;
        }
    }




}
