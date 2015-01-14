package su.problems;

import java.util.Scanner;

/**
 * Created by Akshat on 7/29/2014.
 */
public class MagguSubstring {

    public static void main(String[] args)
    {
        MagguSubstring magguSubstring = new MagguSubstring();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i< N; i++)
        {
            String input = scanner.nextLine();
            System.out.println(magguSubstring.evaluate(input));
        }
        scanner.close();
    }

    public int evaluate(String input) {

        int totalSeqCount = 0;
        int seqCount = 0;
        char[] array = {'A','a','B','b','C','c'};
        for(char ele : input.toCharArray())
        {
            if(contains(array, ele)) {
                seqCount ++;
            }else if(seqCount > 0) {
                totalSeqCount = totalSeqCount + fibb(seqCount);
                seqCount = 0;
            }
        }
        totalSeqCount = totalSeqCount + fibb(seqCount);
        return totalSeqCount;
    }

    private int fibb(int seqCount) {
        return (seqCount*(seqCount+1))/2;
    }

    private boolean contains(char[] array, char ele)
    {
        for(char c : array)
        {
            if(c == ele)
            {
                return true;
            }
        }
        return false;
    }
}
