package su.problems;

import java.util.Scanner;

/**
 * Created by Akshat on 9/23/2014.
 */
public class DoorClosing {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        DoorClosing doorClosing = new DoorClosing();
        for (int i = 0; i < num; i++) {
            System.out.println(doorClosing.compute(scanner.next()));
        }
    }

    protected String compute(String input) {
        int grp = 0;
        for(String sub : input.split("_"))
        {
            grp = grp^sub.length();
        }
        return grp==0?"Bob":"Alice";
    }
}
