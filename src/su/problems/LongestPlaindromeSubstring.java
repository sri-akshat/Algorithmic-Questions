package su.problems;

/**
 * Created by asrivastava6 on 4/13/15.
 */
public class LongestPlaindromeSubstring {
    public int compute(String input) {

        int[][] memo = new int[input.length()][input.length()];
        int max = 1;

        for(int i=0;i<input.length();i++)
        {
            memo[i][i] = 1;
        }

        for(int i=0;i<input.length()-1;i++)
        {
            if(input.charAt(i) == input.charAt(i+1)) {
                memo[i][i+1] = 1;
                max = 2;
            }
        }

        for(int k=3;k<input.length();k++)
        {
            for(int i=0;i<input.length()-k;i++)
            {
                int j = i+k-1;
                if(memo[i+1][j-1]==1 && input.charAt(i) == input.charAt(j))
                {
                    memo[i][j] = 1;
                    max = k;
                }
            }
        }

        return max;
    }
}
