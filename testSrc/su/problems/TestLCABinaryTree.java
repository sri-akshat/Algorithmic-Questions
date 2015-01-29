package su.problems;

import org.junit.Assert;
import su.TestUtils;
import su.dataStructure.Node;

/**
 * Created by Akshat on 1/27/2015.
 */
public class TestLCABinaryTree {

    @org.junit.Test
    public void testLca()
    {
        Node node = TestUtils.createBinaryTree();
        LCABinaryTree lcaBinaryTree = new LCABinaryTree();
        Assert.assertEquals(15,lcaBinaryTree.lca(node, 3, 17).getIntData().intValue());
    }
}
