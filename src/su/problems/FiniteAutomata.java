package su.problems;

import java.util.Scanner;

/**
 * Created by Akshat on 9/20/2014.
 */
public class FiniteAutomata {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            for(int j = 0;j < N; j++)
            {
                System.out.print(j+" ");
                System.out.print((j * 2) % N+" ");
                System.out.print((j * 2 + 1) % N);
                System.out.println("");
            }

    }

}
