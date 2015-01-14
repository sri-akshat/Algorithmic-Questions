package su;

import org.junit.Assert;
import org.junit.Test;
import su.dataStructure.*;
import su.problems.LeastCommonAncestor;

import java.util.ArrayList;

/**
 * Created by Akshat on 5/7/2014.
 */
public class TestLeastCommonAncestor {

    @Test
    public void testEvaluate()
    {
        su.dataStructure.Node binaryTree = TestUtils.createBinaryTree(getIntegerList());
        LeastCommonAncestor leastCommonAncestor = new LeastCommonAncestor();
        Assert.assertEquals("wrong lca", 15, leastCommonAncestor.evaluate(binaryTree, 3, 17));
        Assert.assertEquals("wrong lca", 18, leastCommonAncestor.evaluate(binaryTree, 17, 18));

    }

    private ArrayList<Integer> getIntegerList() {
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
