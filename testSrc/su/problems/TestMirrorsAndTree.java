package su.problems;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Akshat on 9/19/2014.
 */
public class TestMirrorsAndTree {

    @Test
    public void testEvaluate()
    {
        int[] array = {0,1, 3, 0, 0, 0, 0, 0};
        new MirrorsAndTree().evaluate(array, new int[9], new int[9]);

    }

    @Test
     public void testEvaluate1()    {
        int[] array = {0,1,2,3,4,5,6,7,0,0,0,0,0,0,0,0};
        new MirrorsAndTree().evaluate(array, new int[18], new int[18]);

    }

    @Test
     public void testEvaluate2()
    {
        int[] array = {0,1,2,3,0,5,4,0,0,0,9,7,0,9,0,0,0,0,0,0,0,22,8,9,0,0,0,0,0,0,0,0,0,0};
        new MirrorsAndTree().evaluate(array, new int[106], new int[106]);

    }

    @Test
    public void testEvaluate3()
    {
        int[] array = {0,1, 7, 7, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0,0};
        new MirrorsAndTree().evaluate(array, new int[106], new int[106]);

    }

    @Test
    public void testEvaluate4()
    {
        int[] array = {0,1, 5, 5, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0,0};
        new MirrorsAndTree().evaluate(array, new int[106], new int[106]);

    }


}
