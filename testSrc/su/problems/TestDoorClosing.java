package su.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Akshat on 1/12/2015.
 */
public class TestDoorClosing {

    @Test
    public void testCompute(){
        DoorClosing doorClosing = new DoorClosing();
        Assert.assertEquals("Alice",doorClosing.compute("_|_"));
        Assert.assertEquals("Alice",doorClosing.compute("|||"));
        Assert.assertEquals("Alice",doorClosing.compute("|__"));
        Assert.assertEquals("Alice",doorClosing.compute("|__||_|"));
        Assert.assertEquals("Alice",doorClosing.compute("_|_"));
        Assert.assertEquals("Bob",doorClosing.compute("_|_|"));
    }
}
