package su;

import junit.framework.Assert;
import org.junit.Test;
import su.dataStructure.*;
import su.dataStructure.Node;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 8/29/13
 * Time: 10:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestBinarySearchTree {

    @Test
    public void testFind()
    {
        su.dataStructure.Node binaryTree = TestUtils.createBinaryTree(getIntegerList());
        BinarySearchTree bst = new BinarySearchTree();
        Assert.assertTrue(bst.find(binaryTree, 18));
        Assert.assertFalse(bst.find(binaryTree, 9));
    }

    @Test
    public void testDelete()
    {
        su.dataStructure.Node binaryTree = TestUtils.createBinaryTree(getIntegerList());
        BinarySearchTree bst = new BinarySearchTree();
        Assert.assertTrue(bst.find(binaryTree, 18));
        Node newTree = bst.delete(binaryTree, 18);
        Assert.assertFalse(bst.find(newTree, 18));
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
