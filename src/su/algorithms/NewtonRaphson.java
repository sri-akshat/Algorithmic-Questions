package su.algorithms;

/**
 * Created by Akshat on 5/15/2014.
 */
public class NewtonRaphson  {

    //our functio f(x)
    static double f(double x, double w) {
        return x*x - w;
    }

    //f'(x) /*first derivative*/
    static double fprime(double x) {
        return 2*x;
    }

    public static void main(String argv[]) {

/* x is our current guess. If no command line guess is given,
   we take 0 as our starting point. */

        double x = 0;

        if(argv.length==1) {
            x= Double.valueOf(argv[0]).doubleValue();
        }

        new NewtonRaphson().evaluate(x, 64);
    }

    public double evaluate(double x, double w) {
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