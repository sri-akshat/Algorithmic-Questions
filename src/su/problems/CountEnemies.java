package su.problems;

import java.util.Scanner;

/**
 * Created by Akshat on 8/24/2014.
 */
public class CountEnemies {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {

            int output = 0;
            String input = scanner.next();
            for(String str: input.split("\\*"))
            {
                if(!str.contains("X"))
                {
                    output += str.length();
                }
            }
            System.out.println(output);
        }
    }
}
