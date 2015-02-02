package su.problems.tree;

import org.junit.Assert;
import org.junit.Test;
import su.TestUtils;
import su.dataStructure.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshat on 2/1/2015.
 */
public class TestBSTToDLL {

    @Test
    public void testComputeForIncompleteBST()
    {
        Node bst = TestUtils.createBinaryTree(getIntegerList());
        Node head = new BSTToDLL().compute(bst);
        String str = "";
        while(head!=null)
        {
            str += head.getIntData() + ",";
            head = head.right;
        }

        Assert.assertEquals("1,2,4,5,7,8,11",str.substring(0,str.length()-1));
    }

    private List<Integer> getIntegerList() {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(-1);
        integerList.add(4);
        integerList.add(2);
        integerList.add(8);
        integerList.add(1);
        integerList.add(null);
        integerList.add(5);
        integerList.add(11);
        integerList.add(null);
        integerList.add(null);
        integerList.add(null);
        integerList.add(null);
        integerList.add(null);
        integerList.add(7);
        return integerList;
    }
}
