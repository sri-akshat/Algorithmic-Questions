package su.problems;

import org.junit.Assert;

/**
 * Created by Akshat on 2/6/2015.
 */
public class TestLuckyNumber {

    @org.junit.Test
    public void testComputeFor4()
    {
        LuckyNumber luckyNumber = new LuckyNumber();
        Assert.assertEquals("5",luckyNumber.compute("4"));
    }
    @org.junit.Test
    public void testCompute48()
    {
        LuckyNumber luckyNumber = new LuckyNumber();
        Assert.assertEquals("53",luckyNumber.compute("48"));
    }
    @org.junit.Test
    public void testCompute130()
    {
        LuckyNumber luckyNumber = new LuckyNumber();
        Assert.assertEquals("333",luckyNumber.compute("130"));
    }
    @org.junit.Test
    public void testCompute98()
    {
        LuckyNumber luckyNumber = new LuckyNumber();
        Assert.assertEquals("333",luckyNumber.compute("98"));
    }
    @org.junit.Test
    public void testCompute36()
    {
        LuckyNumber luckyNumber = new LuckyNumber();
        Assert.assertEquals("53",luckyNumber.compute("36"));
    }
    @org.junit.Test
    public void testCompute54()
    {
        LuckyNumber luckyNumber = new LuckyNumber();
        Assert.assertEquals("55",luckyNumber.compute("54"));
    }

    @org.junit.Test
    public void testComputeFor65()
    {
        LuckyNumber luckyNumber = new LuckyNumber();
        Assert.assertEquals("333",luckyNumber.compute("65"));
        Assert.assertEquals("33",luckyNumber.compute("6"));
        Assert.assertEquals("333",luckyNumber.compute("178"));
        Assert.assertEquals("335",luckyNumber.compute("334"));
        Assert.assertEquals("353",luckyNumber.compute("335"));
        Assert.assertEquals("353",luckyNumber.compute("336"));
        Assert.assertEquals("55",luckyNumber.compute("44"));
        Assert.assertEquals("5533333",luckyNumber.compute("5357432"));
        Assert.assertEquals("535",luckyNumber.compute("534"));
    }
}
