package su.problems.codeJam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by asrivastava6 on 8/28/16.
 */
public class SherlockAndParentheses {
    private Map<Integer, Integer> memo = new HashMap<>();
    public int compute(int L, int R) {
        int min = Math.min(L,R);
        return (min*(min+1))/2;
    }

    public static void main(String[] args) throws IOException {

        Writer writer = new FileWriter("/Users/asrivastava6/myProjects/Algorithmic-Questions/resource/SherlockAndParenthesesOutput.txt");
        Scanner scanner = new Scanner(new File("/Users/asrivastava6/myProjects/Algorithmic-Questions/resource/SherlockAndParenthesesInput.txt"));
        int num = Integer.parseInt(scanner.next());
        int L,R;
        scanner.nextLine();

        SherlockAndParentheses sherlockAndParentheses = new SherlockAndParentheses();
        for(int i=0; i<num; i++){
            L = scanner.nextInt();
            R = scanner.nextInt();
            int k = i+1;
            writer.write("Case #"+k+": "+sherlockAndParentheses.compute(L,R)+"\n");
        }
        writer.flush();
        writer.close();
        scanner.close();
    }
}
