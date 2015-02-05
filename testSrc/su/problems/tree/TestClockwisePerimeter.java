package su.problems.tree;

import org.junit.Assert;
import org.junit.Test;
import su.TestUtils;
import su.dataStructure.Node;

/**
 * Created by Akshat on 2/3/2015.
 */
public class TestClockwisePerimeter {

    @Test
    public void testCompute()
    {
        Node node = TestUtils.createBinaryTree();
        ClockwisePerimeter clockwisePerimeter = new ClockwisePerimeter();
        Assert.assertEquals("15,18,20,17,7,3,6",clockwisePerimeter.compute(node));
    }

    @Test
    public void testComputeRecursive()
    {
        Node node = TestUtils.createBinaryTree();
        ClockwisePerimeter clockwisePerimeter = new ClockwisePerimeter();
        Assert.assertEquals("15,18,20,17,7,3,6",clockwisePerimeter.computeRecursive(node));
    }

}
