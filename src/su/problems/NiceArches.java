package su.problems;

import java.util.Scanner;

/**
 * Created by Akshat on 8/23/2014.
 */
public class NiceArches {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int output = 0;
        for(int i=0; i < num; i++)
        {
            String inputOrig = scanner.next();
            String input = new String(inputOrig);

            for(int k=0; k < inputOrig.length()/2; k++)
            {
                String original = new String(input);
                input = input.replaceAll("(AA)*", "");
                input = input.replaceAll("(BB)*", "");
                if(input.isEmpty()) {
                    output++;
                    break;
                }else if(original.equals(input))
                {
                    break;
                }
            }
        }
        System.out.println(output);

    }
}
