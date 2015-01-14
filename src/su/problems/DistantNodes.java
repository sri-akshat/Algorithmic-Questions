package su.problems;

import su.dataStructure.Node;
import su.dataStructure.Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshat on 6/12/2014.
 */
public class DistantNodes {

    protected List<Node> getKDistantNodes(Node root, int k)
    {
        int level = 0;
        Queue queue = new Queue(Integer.MAX_VALUE);
        Node dummyNode = new Node(-1);
        List<Node> nodes = new ArrayList<Node>();
        queue.push(root);
        queue.push(dummyNode);

        while(!queue.isEmpty())
        {
            Node current = queue.pop();
            if(current == dummyNode) {
                level++;
                queue.push(dummyNode);
                current = queue.pop();
                if(level > k)
                {
                    return nodes;
                }
            }
            if(level == k)
                nodes.add(current);

            if(current.left!=null)
                queue.push(current.left);

            if(current.right!=null)
                queue.push(current.right);
        }
        return nodes;
    }




    public int calculateNodes(Node root, Node targetNode, int distance) {

        if(root == null)
        {
            return -1;
        }

        if(root.getIntData() == targetNode.getIntData())
        {
            for(Node node : getKDistantNodes(root, distance))
            {
                System.out.println(node.getIntData());
            }
            return 0;
        }

        // see if target is found in left sub tree

        int leftDistance = calculateNodes(root.left, targetNode, distance);

        if(leftDistance != -1)
        {
            if(leftDistance + 1 == distance)
            {
                System.out.println(root.getIntData());
            }else{
                for(Node node : getKDistantNodes(root.right, distance - leftDistance - 2))
                {
                    System.out.println(node.getData());
                }
            }

            return leftDistance + 1;
        }

        // see if target is found in right sub tree

        int rightDistance = calculateNodes(root.right, targetNode, distance);

        if(rightDistance != -1)
        {
            if(rightDistance + 1 == distance)
            {
                System.out.print(root.getIntData());
            }else{
                for(Node node : getKDistantNodes(root.left, distance - rightDistance - 2))
                {
                    System.out.println(node.getData());
                }
            }

            return leftDistance + 1;
        }

        return -1;
    }
}
