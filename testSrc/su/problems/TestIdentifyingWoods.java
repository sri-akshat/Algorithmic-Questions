package su.problems;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Akshat on 10/4/2014.
 */
public class TestIdentifyingWoods {

    @Test
    public void testCheck()
    {
        String s = "oxoxoxox";
        String t = "ooxxoo";
        IdentifyingWood identifyingWood = new IdentifyingWood();
        Assert.assertEquals("Nope.",identifyingWood.check(s,t));
    }

    @Test
    public void testCheck1()
    {
        String s = "absdefgh";
        String t = "asdf";
        IdentifyingWood identifyingWood = new IdentifyingWood();
        Assert.assertEquals("Nope.",identifyingWood.check(s,t));
    }
}
