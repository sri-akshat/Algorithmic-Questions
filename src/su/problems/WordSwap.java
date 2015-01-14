package su.problems;

import java.util.Scanner;

/**
 * Created by Akshat on 8/30/2014.
 */
public class WordSwap {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        for(int i=0; i < num; i++)
        {
            String input = scanner.nextLine();
            String[] array = input.split(" ");
            for(int j = array.length-1; j>-1; j--)
            {
                System.out.print(array[j]+" ");
            }
            System.out.println("");

        }
    }
}
