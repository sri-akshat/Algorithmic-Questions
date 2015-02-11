package su.problems;

import org.junit.Assert;

/**
 * Created by Akshat on 2/6/2015.
 */
public class TestAnagrams {

    @org.junit.Test
    public void testCheck()
    {
        Anagrams anagrams = new Anagrams();
        Assert.assertEquals("Anagrams!", anagrams.check("the eyes","they see"));
        Assert.assertEquals("Not anagrams!", anagrams.check("the eyes","they do see"));
    }
}
