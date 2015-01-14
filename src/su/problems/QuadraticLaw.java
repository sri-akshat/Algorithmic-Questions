package su.problems;

/**
 * Created by Akshat on 10/4/2014.
 */
public class QuadraticLaw {

    public long getTime(long d)
    {
        long c = -d;
        double temp1 = Math.sqrt(1 * 1 - 4 * 1 * c);

        long root1 = (long) ((-1 +  temp1) / (2*1));
        long root2 = (long) ((-1 -  temp1) / (2*1));

        return root1 > root2 ? root1 : root2;
    }
}
