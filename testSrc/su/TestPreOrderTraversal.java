package su;

import org.junit.Test;
import org.junit.Assert;
import su.dataStructure.Node;
import su.problems.PreOrderTraversal;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 1/27/13
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestPreOrderTraversal {

    @Test
    public void testPreOrderTraverseRecursive(){
        Node binaryTree = TestUtils.createBinaryTree(getIntegerList());
        String preOrderTraverseString = new PreOrderTraversal().preOrderTraverseRecursive(binaryTree);
        Assert.assertEquals("Wrong pre order traversal", preOrderTraverseString, "1,2,4,5,3,6");
    }

    @Test
    public void testPreOrderTraverseIterative(){
        Node binaryTree = TestUtils.createBinaryTree(getIntegerList());
        String preOrderTraverseString = new PreOrderTraversal().preOrderTraverseIterative(binaryTree);
        Assert.assertEquals("Wrong pre order traversal", preOrderTraverseString, "1,2,4,5,3,6");
    }

    static ArrayList<Integer> getIntegerList() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(-1);  // unused 0th index
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        return numbers;
    }
}
