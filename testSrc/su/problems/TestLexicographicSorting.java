package su.problems;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshat on 1/29/2015.
 */
public class TestLexicographicSorting {

    @org.junit.Test
    public void testSort()
    {
        List<String> list = new ArrayList<>();
        list.add("Zak");
        list.add("Ybk");
        list.add("Yak");
        list.add("Pak");
        list.add("Hak");
        list.add("Fak");
        list.add("Dak");
        LexicographicSorting obj = new LexicographicSorting();
        List<String> sortedList = obj.sort(list);
        Assert.assertEquals("Dak", sortedList.get(0));
        Assert.assertEquals("Fak", sortedList.get(1));
        Assert.assertEquals("Hak", sortedList.get(2));
        Assert.assertEquals("Pak", sortedList.get(3));
        Assert.assertEquals("Yak", sortedList.get(4));
        Assert.assertEquals("Ybk", sortedList.get(5));
        Assert.assertEquals("Zak", sortedList.get(6));
    }
}
