package su.problems.tree;

import su.dataStructure.Node;

/**
 * Created by Akshat on 2/2/2015.
 */
public class MaxSumLevel {

    static int maxLevel = -1;
    static int maxSum = 0;
    public void compute(Node root, int sum, int level) {

        if(root==null)
            return;

        sum += root.getIntData();

        if(sum > maxSum)
        {
            maxSum = sum;
            maxLevel = level;
        }

        System.out.println("root="+root.getIntData()+" sum="+sum+" level="+level);
        compute(root.left, sum , level + 1);
        compute(root.right, sum , level + 1);
    }
}
