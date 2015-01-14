package su.problems;

import org.junit.Assert;

/**
 * Created by Akshat on 1/18/2015.
 */
public class TestIncreasingDecreasingArray {

    @org.junit.Test
    public void testSearch()
    {
        int[] arr = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
        IncreasingDecreasingArray increasingDecreasingArray = new IncreasingDecreasingArray();
        Assert.assertTrue(increasingDecreasingArray.search(arr, 10));
        Assert.assertTrue(increasingDecreasingArray.search(arr, 500));
        Assert.assertTrue(increasingDecreasingArray.search(arr, 1));
        Assert.assertTrue(increasingDecreasingArray.search(arr, 2));
    }

    @org.junit.Test
    public void testSearch1()
    {
        int[] arr = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
        IncreasingDecreasingArray increasingDecreasingArray = new IncreasingDecreasingArray();
        Assert.assertFalse(increasingDecreasingArray.search(arr, 11));
    }
}

