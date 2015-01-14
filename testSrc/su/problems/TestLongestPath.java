package su.problems;

import junit.framework.Assert;
import org.junit.Test;
import su.dataStructure.Node;

/**
 * Created by Akshat on 5/20/2014.
 */
public class TestLongestPath {

    @Test
    public void testConvert2dArrayToTree()
    {
        int[][] array = new int[][]{
            new int[] {1,2},
            new int[] {3,4},
        };
        LongestPath longestPath = new LongestPath();
        Node root = new Node(array[0][0],0);
        longestPath.convert2dArrayToTree(array, 0, 0, root);
        Assert.assertEquals("wrong value", 4, (int)root.left.right.getIntData());
    }

    @Test
    public void testConvert2dArrayToTreeForBiggerArray()
    {
        int[][] array = new int[][]{
                new int[] {1, 2, 3, 4},
                new int[] {2, 2, 3, 4},
                new int[] {3, 2, 3, 4},
                new int[] {4, 5, 6, 7},
        };
        LongestPath longestPath = new LongestPath();
        Node root = new Node(array[0][0],0);
        longestPath.convert2dArrayToTree(array, 0, 0, root);
        Assert.assertEquals("wrong value", 7, (int)root.left.right.left.right.left.right.getIntData());
    }
}
