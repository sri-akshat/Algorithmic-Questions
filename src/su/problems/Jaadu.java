package su.problems;

import java.util.Scanner;

/**
 * Created by Akshat on 9/1/2014.
 */
public class Jaadu {


        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            for (int i = 0; i < num; i++) {

                String text = scanner.next();
                String pattern = scanner.next();
                boolean output = false;

                for(char ele:pattern.toCharArray())
                {
                    if(text.contains(""+ele))
                    {
                        output = true;
                        break;
                    }
                }
                System.out.println(output?"YES":"NO");
            }
        }
}
