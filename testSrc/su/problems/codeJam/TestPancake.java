package su.problems.codeJam;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by asrivastava6 on 4/9/16.
 */
public class TestPancake {

    @Test
    public void testEvaluateFlips(){
        Pancake pancake = new Pancake();
        Assert.assertEquals(1, pancake.evaluateFlips("-"));
        Assert.assertEquals(1, pancake.evaluateFlips("-+"));
        Assert.assertEquals(2, pancake.evaluateFlips("+-"));
        Assert.assertEquals(0, pancake.evaluateFlips("+++"));
        Assert.assertEquals(3, pancake.evaluateFlips("--+-"));
        Assert.assertEquals(8, pancake.evaluateFlips("+-+-+-+-+"));
    }
}
