package su.problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Akshat on 1/2/2015.
 */
public class TestNearbyWords {

    @Test
    public void testGetNearbyWords()
    {
        NearbyWords nearbyWords = new NearbyWords();
        List<String> arr = nearbyWords.getNearbyWords("hello");
        Assert.assertNotNull(arr);
        Assert.assertFalse(arr.isEmpty());
        Assert.assertEquals(2, arr.size());
        Assert.assertEquals("hello", arr.get(0));
        Assert.assertEquals("jello", arr.get(1));
    }

    @Test
    public void testGetNearbyWordsWhenEmpty()
    {
        NearbyWords nearbyWords = new NearbyWords();
        List<String> arr = nearbyWords.getNearbyWords("");
        Assert.assertTrue(arr.isEmpty());
    }
}
