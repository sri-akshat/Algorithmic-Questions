package su.problems;

import org.junit.Assert;
import org.junit.Test;
import su.TestUtils;
import su.dataStructure.Node;

import java.util.ArrayList;

/**
 * Created by Akshat on 6/12/2014.
 */
public class TestDistantNodes {

    @Test
    public void testCalculateNodesForLeftTree()
    {
        DistantNodes distantNodes = new DistantNodes();
        Node targetNode = new Node(3);
        Node binaryTree = TestUtils.createBinaryTree(getIntegerList());
        distantNodes.calculateNodes(binaryTree, targetNode, 2);

        TreeDistance treeDistance = new TreeDistance();
        ArrayList<Integer> result = new ArrayList<>();
        treeDistance.calculateDistantNodes(binaryTree, 3, 2, result);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(15));
        Assert.assertTrue(result.contains(7));
    }

    @Test
    public void testCalculateNodesForRightTree()
    {
        DistantNodes distantNodes = new DistantNodes();
        Node targetNode = new Node(17);
        Node binaryTree = TestUtils.createBinaryTree(getIntegerList());
        distantNodes.calculateNodes(binaryTree, targetNode, 2);

        TreeDistance treeDistance = new TreeDistance();
        ArrayList<Integer> result = new ArrayList<>();
        treeDistance.calculateDistantNodes(binaryTree, 17, 2, result);
        Assert.assertEquals(2,  result.size());
        Assert.assertTrue(result.contains(15));
        Assert.assertTrue(result.contains(20));
    }

    @Test
    public void testGetKDistantNodes(){
        DistantNodes distantNodes = new DistantNodes();
        Node binaryTree = TestUtils.createBinaryTree(getIntegerList());
        Assert.assertEquals("Wrong number of nodes", 4 ,distantNodes.getKDistantNodes(binaryTree, 2).size());

        TreeDistance treeDistance = new TreeDistance();
        Assert.assertEquals(4, treeDistance.getDistantNodesInSubTree(binaryTree, 2, 0, new ArrayList<>()).size());
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
