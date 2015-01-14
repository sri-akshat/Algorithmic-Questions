package su;

import org.junit.Assert;
import org.junit.Test;
import su.dataStructure.Node;
import su.problems.LevelOrderTraversal;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 2/3/13
 * Time: 1:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestLevelOrderTraversal {

    @Test
    public void testLevelOrder(){
        Node binaryTree = TestUtils.createBinaryTree(getIntegerList());
        ArrayList<ArrayList> array = new LevelOrderTraversal().levelOrder(binaryTree);
        Assert.assertEquals("Wrong level order traversal", array.get(0).get(0), 1);
        Assert.assertEquals("Wrong level order traversal", array.get(1).get(0), 2);
        Assert.assertEquals("Wrong level order traversal", array.get(1).get(1), 3);
        Assert.assertEquals("Wrong level order traversal", array.get(2).get(0), 4);
        Assert.assertEquals("Wrong level order traversal", array.get(2).get(1), 5);
        Assert.assertEquals("Wrong level order traversal", array.get(2).get(2), 6);
    }



    private ArrayList<Integer> getIntegerList() {
        ArrayList<Integer> numbers = TestPreOrderTraversal.getIntegerList();
        return numbers;
    }

    @Test
    public void testPrintLevelOrderTree(){
        Node binaryTree = TestUtils.createBinaryTree(getIntegerList());
        new LevelOrderTraversal().printLevelOrderTree(binaryTree);
    }
}
