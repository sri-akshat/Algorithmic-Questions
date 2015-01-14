package su.problems;

import org.junit.Assert;
import su.TestUtils;
import su.dataStructure.Node;

import java.util.ArrayList;

/**
 * Created by Akshat on 1/16/2015.
 */
public class TestPruneTree {

    @org.junit.Test
    public void testRemoveNodeForLTkLength()
    {
        Node binaryTree = TestUtils.createBinaryTree(getIntegerList());
        PruneTree pruneTree = new PruneTree();
        Assert.assertNotNull(binaryTree.left.right);
        binaryTree.setLevel(1);
        pruneTree.removeNodeForLTkLength(binaryTree, 4, 1);
        Assert.assertNull(binaryTree.left.right.getData());
    }

    @org.junit.Test
    public void testRemoveNodeForLTkLength1()
    {
        Node binaryTree = TestUtils.createBinaryTree(getIntegerList());
        PruneTree pruneTree = new PruneTree();
        Assert.assertNotNull(binaryTree.left.right);
        binaryTree.setLevel(1);
        pruneTree.removeNodeForLTkLength(binaryTree, 5, 1);
        Assert.assertNull(binaryTree.getData());
        Assert.assertNull(binaryTree.left.getData());
        Assert.assertNull(binaryTree.right.getData());
        Assert.assertNull(binaryTree.left.right.getData());
        Assert.assertNull(binaryTree.left.left.getData());
        Assert.assertNull(binaryTree.right.right.getData());
    }

    private static ArrayList<Integer> getIntegerList() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(-1);  // unused 0th index
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(null);
        numbers.add(6);
        numbers.add(7);
        numbers.add(null);
        numbers.add(null);
        numbers.add(null);
        numbers.add(null);
        numbers.add(null);
        numbers.add(8);
        return numbers;
    }
}
