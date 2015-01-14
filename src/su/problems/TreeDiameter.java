package su.problems;

import su.dataStructure.Node;

/**
 * Created by Akshat on 1/19/2015.
 */
public class TreeDiameter {

    int maxDia = 0;
    public int compute(Node node) {

        int leftDia = -1;
        int rightDia = -1;

        if(node.left!=null)
            leftDia = compute(node.left);

        if(node.right!=null)
            rightDia = compute(node.right);

        if(leftDia+rightDia > maxDia)
            maxDia = leftDia+rightDia;

        return maxDia;
    }
}
