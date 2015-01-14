package su.problems;

import java.util.Scanner;

/**
 * Created by Akshat on 9/20/2014.
 */
public class CircleAndRectangle {

    public static void main(String[] args) {

//        long k = (long) (Math.pow(10,18)+7);
//        System.out.println(k);
//        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {

            long L = scanner.nextLong();
            long B = scanner.nextLong();
            long D = scanner.nextLong();

            if(L<D || B<D) {
                System.out.println(0);
                continue;
            }

            long out = (L / D) * (B / D);
            System.out.println((out % (1000000000 + 7)));

        }
    }

}
