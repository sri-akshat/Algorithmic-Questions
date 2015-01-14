package su.problems;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Akshat on 7/29/2014.
 */
public class TestMagguSubstring {

    @Test
    public void testEvaluate()
    {
        MagguSubstring magguSubstring = new MagguSubstring();
        Assert.assertEquals("wrong count", 4, magguSubstring.evaluate("AXBC"));
    }


}
