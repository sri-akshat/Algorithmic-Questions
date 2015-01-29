package su.problems;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshat on 1/21/2015.
 */
public class TestGenIntArrayPermutations {

    @org.junit.Test
    public void testCompute(){
        GenIntArrayPermutations genIntArrayPermutations = new GenIntArrayPermutations();
        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);
        inputList.add(4);
        inputList.add(5);
        List<Integer> newList = new ArrayList<>();
        genIntArrayPermutations.compute(inputList, newList);
        Assert.assertEquals(120, genIntArrayPermutations.getPermutations().size());
    }
}
