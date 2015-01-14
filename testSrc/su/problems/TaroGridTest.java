package su.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Akshat on 8/30/2014.
 */
public class TaroGridTest {

    @Test
     public void testGetNumber()
    {
        TaroGrid taroGrid = new TaroGrid();
        String[] grid = {"BWW",
                "BBB",
                "BWB"};
        Assert.assertEquals("wrong occurence", 3, taroGrid.getNumber(grid)) ;
    }

    @Test
    public void testGetNumber1()
    {
        TaroGrid taroGrid = new TaroGrid();
        String[] grid = {"BBWWBBWW",
                "BBWWBBWW",
                "WWBBWWBB",
                "WWBBWWBB",
                "BBWWBBWW",
                "BBWWBBWW",
                "WWBBWWBB",
                "WWBBWWBB"};
        Assert.assertEquals("wrong occurence", 2, taroGrid.getNumber(grid)) ;
    }
}
