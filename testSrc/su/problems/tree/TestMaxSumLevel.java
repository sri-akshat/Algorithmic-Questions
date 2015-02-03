package su.problems.tree;

import org.junit.Assert;
import org.junit.Test;
import su.TestUtils;
import su.dataStructure.Node;

import java.util.ArrayList;

/**
 * Created by Akshat on 2/2/2015.
 */
public class TestMaxSumLevel {

    @Test
    public void testCompute()
    {
        Node root = TestUtils.createBinaryTree(getIntegerList());
        MaxSumLevel maxSumLevel = new MaxSumLevel();
        maxSumLevel.compute(root, 0, 0);
        Assert.assertEquals(1, maxSumLevel.maxLevel);
    }

    @Test
    public void testCompute1()
    {
        Node root = TestUtils.createBinaryTree(getIntegerList1());
        MaxSumLevel maxSumLevel = new MaxSumLevel();
        maxSumLevel.compute(root, 0, 0);
        Assert.assertEquals(2, maxSumLevel.maxLevel);
    }

    private static ArrayList<Integer> getIntegerList() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(-1);  // unused 0th index
        numbers.add(15);
        numbers.add(6);
        numbers.add(18);
        numbers.add(-3);
        numbers.add(-7);
        numbers.add(-17);
        numbers.add(-20);
        return numbers;
    }

    private static ArrayList<Integer> getIntegerList1() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(-1);  // unused 0th index
        numbers.add(15);
        numbers.add(6);
        numbers.add(18);
        numbers.add(3);
        numbers.add(7);
        numbers.add(17);
        numbers.add(20);
        return numbers;
    }
}
