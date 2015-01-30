package su.problems;

import org.junit.Assert;
import su.TestUtils;
import su.dataStructure.Node;

/**
 * Created by Akshat on 1/19/2015.
 */
public class TestTreeDiameter {

    @org.junit.Test
    public void testCompute()
    {
        Node node = TestUtils.createBinaryTree();
        TreeDiameter longestDistanceBetween2Nodes = new TreeDiameter();
        longestDistanceBetween2Nodes.compute(node);
        Assert.assertEquals(4, longestDistanceBetween2Nodes.maxDia);
    }
}
