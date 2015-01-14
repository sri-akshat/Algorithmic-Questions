package su.problems;

/**
 * Created by Akshat on 1/12/2015.
 */
public class Pow {

    public double pow(double x, double y, int powerOf2, double originalX)
    {
        if(2*powerOf2 > y)
        {
            for(int i=0;i<y-powerOf2;i++)
            {
                x *= originalX;
            }
            return x;
        }

        return pow(x*x, y, powerOf2+2, originalX);

    }

    public double compute(double x, double y) {
        return pow(x, y, 0, x);
    }
}
