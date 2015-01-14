package su.problems;


import su.TestUtils;
import su.dataStructure.Node;

import java.util.ArrayList;

/**
 * Created by Akshat on 1/10/2015.
 */
public class TestMirrorTreeSum {

    @org.junit.Test
    public void testEvaluate()
    {
        Node binaryTree = TestUtils.createBinaryTree(getIntegerList());
        MirrorTreeSum mirrorTreeSum = new MirrorTreeSum();
        mirrorTreeSum.evaluate(binaryTree, binaryTree);
//        Assert.assertEquals(30, binaryTree.getIntData().intValue());
//        Assert.assertEquals(24, binaryTree.left.getIntData().intValue());
//        Assert.assertEquals(24, binaryTree.right.getIntData().intValue());
//        Assert.assertEquals(23, binaryTree.left.left.getIntData().intValue());
//        Assert.assertEquals(24, binaryTree.left.right.getIntData().intValue());
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
