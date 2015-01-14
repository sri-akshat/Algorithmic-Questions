package su.problems;

import org.junit.Assert;
import su.TestUtils;
import su.dataStructure.Node;

/**
 * Created by Akshat on 1/18/2015.
 */
public class TestBSTSum {

    @org.junit.Test
    public void testCompute()
    {
        Node node = TestUtils.createBinaryTree();
        BSTSum bstSum = new BSTSum();
        bstSum.compute(node,0);
        Assert.assertEquals(70, node.getIntData().intValue());
        Assert.assertEquals(83, node.left.getIntData().intValue());
        Assert.assertEquals(38, node.right.getIntData().intValue());
        Assert.assertEquals(86, node.left.left.getIntData().intValue());
        Assert.assertEquals(77, node.left.right.getIntData().intValue());
        Assert.assertEquals(20, node.right.right.getIntData().intValue());
        Assert.assertEquals(55, node.right.left.getIntData().intValue());
    }
}
