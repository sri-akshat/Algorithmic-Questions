package su.problems;

import org.junit.Assert;

/**
 * Created by Akshat on 1/13/2015.
 */
public class TestNumToWord
{
    @org.junit.Test
    public void testGetWord()
    {
        int[] arr = {1,2,3,4};
        NumToWord numToWord = new NumToWord();

        Assert.assertEquals("ONE THOUSAND TWO HUNDRED THIRTY FOUR",numToWord.getWord(arr, new StringBuilder()));
    }

    @org.junit.Test
    public void testGetWord1()
    {
        int[] arr = {5,7,1,2,3,4};
        NumToWord numToWord = new NumToWord();

        Assert.assertEquals("FIVE LAKH SEVENTY ONE THOUSAND TWO HUNDRED THIRTY FOUR",numToWord.getWord(arr, new StringBuilder()));
    }

}
