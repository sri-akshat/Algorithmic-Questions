package su.problems;

import org.junit.Assert;
import su.TestUtils;
import su.dataStructure.Node;

/**
 * Created by Akshat on 1/18/2015.
 */
public class TestTreeRelation {

    @org.junit.Test
    public void testAreCousins()
    {
        Node node = TestUtils.createBinaryTree();
        TreeRelation treeRelation = new TreeRelation();
        Assert.assertTrue(treeRelation.areCousins(node, 3, 17));
    }

    @org.junit.Test
    public void testAreCousins1()
    {
        Node node = TestUtils.createBinaryTree();
        TreeRelation treeRelation = new TreeRelation();
        Assert.assertFalse(treeRelation.areCousins(node, 3, 15));
    }
}
