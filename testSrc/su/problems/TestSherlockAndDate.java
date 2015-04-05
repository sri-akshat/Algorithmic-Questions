package su.problems;

import org.junit.Assert;

/**
 * Created by Akshat on 2/14/2015.
 */
public class TestSherlockAndDate {

    @org.junit.Test
    public void testCompute()
    {
        SherlockAndDate sherlockAndDate = new SherlockAndDate();
        String date1 = "01:01:0001";
        String date2 = "01:02:0003";
        Assert.assertEquals(1,sherlockAndDate.compute(date1, date2));
    }

    @org.junit.Test
    public void testCompute1()
    {
        SherlockAndDate sherlockAndDate = new SherlockAndDate();
        String date1 = "05:02:2015";
        String date2 = "05:02:2017";
        Assert.assertEquals(0,sherlockAndDate.compute(date1, date2));
    }
}
