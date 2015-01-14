package su.problems;

import java.util.Scanner;

/**
 * Created by Akshat on 8/24/2014.
 */
public class Quantum {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for(int i=0; i < num; i++)
        {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();

            int x = modexp(a,b,c);
            int y = c;




        }
    }

    private static int modexp(int x, int y, int n) {
        if(y==0)
            return 1;
        int z = modexp(x, Math.floorDiv(y,2), n);
        if(y%2==0)
            return (z*z)%n;
        else
            return (x*z*z)%n;
    }


}
