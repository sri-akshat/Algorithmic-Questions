package su.problems;

import org.junit.Assert;
import su.TestUtils;
import su.dataStructure.Node;

import java.util.ArrayList;

/**
 * Created by Akshat on 1/12/2015.
 */
public class TestTreeRightView {

    @org.junit.Test
    public void testCompute()
    {
        Node binaryTree = TestUtils.createBinaryTree(getIntegerList());
        TreeRightView treeRightView = new TreeRightView();
        Assert.assertEquals("15,6,3,4", treeRightView.computeView(binaryTree));


    }

    private static ArrayList<Integer> getIntegerList() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(-1);  // unused 0th index
        numbers.add(15);
        numbers.add(6);
        numbers.add(18);
        numbers.add(3);
        numbers.add(7);
        numbers.add(17);
        numbers.add(20);
        numbers.add(4);
        numbers.add(5);
        return numbers;
    }
}
