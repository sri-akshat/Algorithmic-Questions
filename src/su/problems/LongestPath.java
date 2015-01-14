package su.problems;

import su.dataStructure.Node;

/**
 * Created by Akshat on 5/20/2014.
 */
public class LongestPath {

    protected void convert2dArrayToTree(int[][] array, int i, int j, Node node)
    {
        int left = i+1;
        int right = j+1;

        if(left < array.length) {
            node.left = new Node(array[left][j], node.getIndex() + 1);
            convert2dArrayToTree(array, left, j, node.left);
        }

        if(right<array[i].length) {
            node.right = new Node(array[i][right], node.getIndex() + 1);
            convert2dArrayToTree(array, i, right, node.right);
        }

    }


}
