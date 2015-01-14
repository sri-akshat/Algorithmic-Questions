package su.dataStructure;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 8/29/13
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearchTree {

    public boolean find(Node node, int key) {

        while(node != null && key != node.getIntData())
        {
            if(key < node.getIntData())
            {
                node = node.left;
            }else{
                node = node.right;
            }
        }

        if(node == null)
            return false;
        else
            return true;
    }

    public Node delete(Node node, int i) {

        Node newTreeNode1;
        Node newTreeNode2;

        if(node.left == null || node.right == null)
        {
            newTreeNode1 = node;
        }else{
            newTreeNode1 = treeSuccessor(node);
        }

        if(newTreeNode1.left != null)
        {
            newTreeNode2 = newTreeNode1.left;
        }else{
            newTreeNode2 = newTreeNode1.right;
        }

        if(newTreeNode2 != null)
        {
            newTreeNode2.parent = newTreeNode1.parent;
        }

        if(newTreeNode1.parent == null)
        {
            node = newTreeNode2;
        }else{
            if(newTreeNode1.getIntData() == newTreeNode1.parent.left.getIntData())
            {
                newTreeNode1.parent.left = newTreeNode2;
            }else{
                newTreeNode1.parent.right = newTreeNode2;
            }
        }

        if(newTreeNode1 != node)
        {
            node.setData(newTreeNode1.getData());
        }
        return newTreeNode1;
    }

    private Node treeSuccessor(Node node) {

        if(node.right != null)
        {
            return treeMin(node.right);
        }
        Node newNode = node.parent;
        while(newNode != null && node.getIntData() == newNode.right.getIntData())
        {
            node = newNode;
            newNode = newNode.parent;
        }
        return newNode;
    }

    private Node treeMin(Node node) {

        while(node.left!=null)
        {
            node = node.left;
        }
        return node;  //To change body of created methods use File | Settings | File Templates.
    }
}
