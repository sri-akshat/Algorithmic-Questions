package su.problems.tree;

import su.dataStructure.Node;

/**
 * Created by Akshat on 2/1/2015.
 */
public class BSTToDLL {

    public Node compute(Node root)
    {
        Node node = buildDLL(root);
        return inOrderPredecessor(node);
    }

    private Node buildDLL(Node root) {
        if(root!=null && root.getData()!=null)
        {
            buildDLL(root.left);

            Node r1 = root;
            Node inOrderSuccessor = (r1.left==null||r1.left.getData()==null)?null:inOrderSuccessor(r1.left);
            if(inOrderSuccessor!=null && inOrderSuccessor.getData()!=null) {
                System.out.println(root.getIntData() + "ka left = "+inOrderSuccessor.getIntData());
                root.left = inOrderSuccessor;
                System.out.println(inOrderSuccessor.getIntData() + "ka right = "+root.getIntData());
                inOrderSuccessor.right = root;
            }
        }

        if(root!=null && root.getData()!=null)
        {
            buildDLL(root.right);

            Node r2 = root;
            Node inOrderPredecessor = (r2.right==null||r2.right.getData()==null)?null:inOrderPredecessor(r2.right);

            if(inOrderPredecessor!=null && inOrderPredecessor.getData()!=null) {
                System.out.println(root.getIntData() + "ka right = "+inOrderPredecessor.getIntData());
                root.right = inOrderPredecessor;
                System.out.println(inOrderPredecessor.getIntData() + "ka left = "+root.getIntData());
                inOrderPredecessor.left = root;
            }
        }

        return root;
    }

    private Node inOrderSuccessor(Node root) {

        while(root.right!=null && root.right.getData()!=null)
            root = root.right;

        return root;
    }

    private Node inOrderPredecessor(Node root) {

        while(root.left!=null && root.left.getData()!=null)
            root = root.left;

        return root;
    }
}
