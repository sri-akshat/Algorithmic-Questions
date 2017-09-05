package su.problems.codeJam;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by asrivastava6 on 8/28/16.
 */
public class TestSherlockAndParentheses {

    @Test
    public void testCompute(){
        SherlockAndParentheses sherlockAndParentheses = new SherlockAndParentheses();
        Assert.assertEquals(sherlockAndParentheses.compute(1, 0), 0);
        Assert.assertEquals(sherlockAndParentheses.compute(1, 1), 1);
        Assert.assertEquals(sherlockAndParentheses.compute(3, 2), 3);
        Assert.assertEquals(sherlockAndParentheses.compute(14, 6), 21);
    }

}
