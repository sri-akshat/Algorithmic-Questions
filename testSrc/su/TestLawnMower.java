package su;

import junit.framework.Assert;
import org.junit.Test;
import su.problems.LawnMower;

/**
 * Created with IntelliJ IDEA.
 * User: Akshat
 * Date: 4/13/13
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestLawnMower {

    @Test
    public void testIsDesignFeasible1 ()
    {
        StringBuffer testSize = new StringBuffer("10  000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001");
        System.out.println(testSize.reverse().hashCode());
        System.out.println(testSize.hashCode());
        int[][] lawn = {{2,1,2},{1,1,1},{2,1,2}};
        LawnMower lawnMower = new LawnMower();
        Assert.assertTrue("design should be true",lawnMower.isDesignFeasible(lawn, 3, 3));
    }

    @Test
    public void testIsDesignFeasible2 ()
    {
        int[][] lawn = {{2,2,2,2,2},{2,1,1,1,2},{2,1,2,1,2},{2,1,1,1,2},{2,2,2,2,2}};
        LawnMower lawnMower = new LawnMower();
        Assert.assertFalse("design should be false", lawnMower.isDesignFeasible(lawn, 5, 5));
    }

    @Test
    public void testIsDesignFeasible3 ()
    {
        int[][] lawn = {{1,2,1}};
        LawnMower lawnMower = new LawnMower();
        Assert.assertTrue("design should be true", lawnMower.isDesignFeasible(lawn, 1, 3));
    }

    @Test
    public void testIsDesignFeasible4 ()
    {
        int[][] lawn = {{2,2,2},{5,4,5},{3,3,3}};
        LawnMower lawnMower = new LawnMower();
        Assert.assertTrue("design should be true",lawnMower.isDesignFeasible(lawn, 3, 3));
    }
}
