package su.problems;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
 Output: Order of characters is 'b', 'd', 'a', 'c'
 Note that words are sorted and in the given language "baa"
 comes before "abcd", therefore 'b' is before 'a' in output.
 Similarly we can find other orders.

 Input:  words[] = {"caa", "aaa", "aab"}
 Output: Order of characters is 'c', 'a', 'b'
 */
public class AlienLanguageTest {

    @Test
    public void evaluate()
    {
        String words[] = {"baa", "abcd", "abca", "cab", "cad"};
        AlienLanguage alienLanguage = new AlienLanguage();
        Assert.assertEquals("wrong order", "bdac", alienLanguage.evaluate(words));
    }

    @Test
    public void evaluate1()
    {
        String words[] = {"caa", "aaa", "aab"};
        AlienLanguage alienLanguage = new AlienLanguage();
        Assert.assertEquals("wrong order", "cab", alienLanguage.evaluate(words));
    }

    @Test
    public void evaluate2()
    {
        String words[] = {"ze", "yf", "xd", "wd", "vd", "ua", "tt", "sz", "rd", "qd", "pz", "op", "nw", "mt", "ln", "ko", "jm", "il", "ho", "gk", "fa", "ed", "dg", "ct", "bb", "ba"};
        AlienLanguage alienLanguage = new AlienLanguage();
        Assert.assertEquals("wrong order", "zyxwvutsrqponmlkjihgfedcba", alienLanguage.evaluate(words));
    }

}
