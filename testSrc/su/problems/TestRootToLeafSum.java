package su.problems;

import org.junit.Assert;
import su.TestUtils;
import su.dataStructure.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshat on 1/18/2015.
 */
public class TestRootToLeafSum {

    @org.junit.Test
    public void testCompute()
    {
        Node node = TestUtils.createBinaryTree();
        RootToLeafSum rootToLeafSum = new RootToLeafSum();
        List<Integer> list = rootToLeafSum.compute(node, 0, new ArrayList<Integer>());
        Assert.assertEquals(4, list.size());
        Assert.assertTrue(list.contains(24));
        Assert.assertTrue(list.contains(28));
        Assert.assertTrue(list.contains(50));
        Assert.assertTrue(list.contains(53));
    }
}
