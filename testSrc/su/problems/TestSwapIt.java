package su.problems;

import com.sun.org.apache.bcel.internal.generic.SWAP;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshat on 7/27/2014.
 */
public class TestSwapIt {

    @Test
    public void testGenerate()
    {
        List<Integer> array = new ArrayList<Integer>();
        array.add(8);
        array.add(9);
        array.add(11);
        array.add(2);
        array.add(1);

        int swaps = 70;

        SwapIt swapIt = new SwapIt();
        List<Integer> output = new ArrayList<Integer>();
        output.add(1);
        output.add(2);
        output.add(8);
        output.add(9);
        output.add(11);

        Assert.assertEquals("wrong sequence", listToString(output), listToString(swapIt.generate(array, swaps)));
    }

    private String listToString(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int ele : list)
        {
            stringBuilder.append(ele + " ");
        }
        return stringBuilder.toString();
    }
}
