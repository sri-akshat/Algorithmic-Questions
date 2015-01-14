package su.problems;

import java.util.Scanner;

/**
 * Created by Akshat on 9/1/2014.
 */
public class CrazyKangaroo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {

            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int multiple = scanner.nextInt();

            System.out.println(end/multiple - (start-1)/multiple);
        }
    }
}
