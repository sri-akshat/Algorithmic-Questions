package su.problems;

import su.dataStructure.Node;

/**
 * Created by Akshat on 1/27/2015.
 */
public class LCABinaryTree {

    public Node lca(Node node, int target1, int target2){

        if(node==null)
            return node;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if(node.getIntData() == target1 || node.getIntData() == target2)
        {
            return node;
        }

        Node left = lca(node.left, target1, target2);
        Node right = lca(node.right, target1, target2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if(left!=null && right!=null) {
            return node;
        }

        // Otherwise check if left subtree or right subtree is LCA
        return left!=null?left:right;
    }
}
