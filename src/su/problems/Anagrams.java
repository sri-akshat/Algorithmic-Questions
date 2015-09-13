package su.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Akshat on 2/6/2015.
 */
public class Anagrams {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new Anagrams().check(scanner.nextLine(), scanner.nextLine()));
    }

    public String check(String line1, String line2) {

        Map<Character, Integer> frequency = new HashMap<>();
        line1.replaceAll(" ","");
        line2.replaceAll(" ","");
        for(Character c : line1.toCharArray())
        {
            frequency.put(c, frequency.get(c)==null ? 1 : frequency.get(c)+1);
        }

        for(Character c : line2.toCharArray())
        {
            frequency.put(c, frequency.get(c)==null ? 1 : frequency.get(c)-1);
        }

        for(Integer i : frequency.values())
            if(i!=0)
                return "Not anagrams!";


        return "Anagrams!";
    }
}
