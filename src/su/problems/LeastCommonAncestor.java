package su.problems;

import su.dataStructure.Node;

/**
 * Created by Akshat on 5/7/2014.
 *
 * Given values of two nodes in a Binary Search Tree, write a program to find the Lowest Common Ancestor (LCA).
 * You may assume that both the values exist in the tree.
 */
public class LeastCommonAncestor {

    public int evaluate(Node binaryTree, int i, int j) {
        if(binaryTree.getIntData() > i && binaryTree.getIntData() > j)
            return evaluate(binaryTree.left, i, j);
        if(binaryTree.getIntData() < i && binaryTree.getIntData() < j)
            return evaluate(binaryTree.right, i, j);
        return binaryTree.getIntData();
    }
}
