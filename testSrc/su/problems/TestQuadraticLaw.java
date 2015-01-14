package su.problems;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Akshat on 10/4/2014.
 */
public class TestQuadraticLaw {

    @Test
    public void testGetTime()
    {
        QuadraticLaw quadraticLaw = new QuadraticLaw();
        Assert.assertEquals(178770270, quadraticLaw.getTime(31958809614643170L));
    }

    @Test
    public void testGetTime1()
    {
        QuadraticLaw quadraticLaw = new QuadraticLaw();
        Assert.assertEquals(999999999, quadraticLaw.getTime(1000000000000000000L));
    }

    @Test
    public void testGetTime2()
    {
        QuadraticLaw quadraticLaw = new QuadraticLaw();
        Assert.assertEquals(0, quadraticLaw.getTime(1));
    }

    @Test
    public void testGetTime3()
    {
        QuadraticLaw quadraticLaw = new QuadraticLaw();
        Assert.assertEquals(1, quadraticLaw.getTime(2));
    }

}
