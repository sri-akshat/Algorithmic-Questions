package su.problems;

import org.junit.*;
import org.junit.Test;

/**
 * Created by Akshat on 1/4/2015.
 */
public class TestRoute {

    @Test
    public void testIsPossible(){

        int[] array = {1,2,0,1,0,1};
        Route route = new Route(array);
        Assert.assertFalse(route.isPossible(5));
    }

    @Test
    public void testIsPossible1(){

        int[] array = {1,2,0,1,1,1};
        Route route = new Route(array);
        Assert.assertTrue(route.isPossible(5));
    }
}
