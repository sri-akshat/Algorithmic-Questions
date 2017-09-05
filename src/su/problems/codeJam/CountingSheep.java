package su.problems.codeJam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
 * Created by asrivastava6 on 4/10/16.
 *
 * Problem

 Bleatrix Trotter the sheep has devised a strategy that helps her fall asleep faster. First, she picks a number N. Then she starts naming N, 2 × N, 3 × N, and so on. Whenever she names a number, she thinks about all of the digits in that number. She keeps track of which digits (0, 1, 2, 3, 4, 5, 6, 7, 8, and 9) she has seen at least once so far as part of any number she has named. Once she has seen each of the ten digits at least once, she will fall asleep.

 Bleatrix must start with N and must always name (i + 1) × N directly after i × N. For example, suppose that Bleatrix picks N = 1692. She would count as follows:

 N = 1692. Now she has seen the digits 1, 2, 6, and 9.
 2N = 3384. Now she has seen the digits 1, 2, 3, 4, 6, 8, and 9.
 3N = 5076. Now she has seen all ten digits, and falls asleep.
 What is the last number that she will name before falling asleep? If she will count forever, print INSOMNIA instead.

 Input

 The first line of the input gives the number of test cases, T. T test cases follow. Each consists of one line with a single integer N, the number Bleatrix has chosen.

 Output

 For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the last number that Bleatrix will name before falling asleep, according to the rules described in the statement.

 Limits

 1 ≤ T ≤ 100.
 Small dataset

 0 ≤ N ≤ 200.
 Large dataset

 0 ≤ N ≤ 106.
 Sample


 Input

 Output

 5
 0
 1
 2
 11
 1692

 Case #1: INSOMNIA
 Case #2: 10
 Case #3: 90
 Case #4: 110
 Case #5: 5076

 *
 */
public class CountingSheep {

    public static void main(String[] args) throws IOException {

        Writer writer = new FileWriter("/Users/asrivastava6/myProjects/Algorithmic-Questions/resource/countingSheepOutput.txt");
        Scanner scanner = new Scanner(new File("/Users/asrivastava6/myProjects/Algorithmic-Questions/resource/countingSheepInput.txt"));
        int num = Integer.parseInt(scanner.next());

        CountingSheep countingSheep = new CountingSheep();
        for(int i=0; i<num; i++){
            int input = scanner.nextInt();
            int k = i+1;
            writer.write("Case #"+k+": "+countingSheep.calculate(input)+"\n");
        }
        writer.flush();
        writer.close();
        scanner.close();
    }

    private String calculate(int input) {

        Set<Character> charSet = new HashSet<>();

        if(input == 0 )
            return "INSOMNIA";

        int i = 1;
        int product = input;
        while(charSet.size()<10){
            product = input*i;
            for(Character c : String.valueOf(product).toCharArray()){
                charSet.add(c);
            }
            i++;
        }
        return String.valueOf(product);
    }
}
