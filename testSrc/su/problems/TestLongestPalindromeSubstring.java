package su.problems;

import org.junit.*;

/**
 * Created by asrivastava6 on 4/13/15.
 */
public class TestLongestPalindromeSubstring {

    @org.junit.Test
    public void testCompute()
    {
        String input = "shdbjasddaalaadjasdfk";
        LongestPlaindromeSubstring longestPalindromeSubstring = new LongestPlaindromeSubstring();
        Assert.assertEquals(7, longestPalindromeSubstring.compute(input));
    }

}
