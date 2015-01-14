package su.problems;

/**
 * Created by Akshat on 10/26/2014.
 */
public class Test {

    public static void main(String[] args)
    {
        int sum = 0;
        for(int i=1;i<1000;i++)
        {
            if(i%3 == 0 || i%5 == 0)
            {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
