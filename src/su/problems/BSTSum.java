package su.problems;

import su.dataStructure.Node;

/**
 * Created by Akshat on 1/18/2015.
 */
public class BSTSum {
    public int compute(Node node, int sum){

        if(node.right!=null)
            sum = compute(node.right, sum);

        sum += node.getIntData();
        node.setData(sum);

        if(node.left!=null)
            sum = compute(node.left, sum);
        return sum;
    }
}
