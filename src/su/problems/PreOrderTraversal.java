package su.problems;

import su.dataStructure.Node;
import su.dataStructure.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 1/27/13
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */

public class PreOrderTraversal {

    public String preOrderTraverseRecursive(Node treeRoot){
        StringBuilder sb = new StringBuilder();
        return preOrderTraverseRecursive(treeRoot, sb).substring(0, sb.length() - 1);
    }

    private StringBuilder preOrderTraverseRecursive(Node treeRoot, StringBuilder sb) {
        if(treeRoot != null){
            sb.append(treeRoot.getIntData()+",");
            preOrderTraverseRecursive(treeRoot.left,sb);
            preOrderTraverseRecursive(treeRoot.right,sb);
        }
        return sb;
    }

    public String preOrderTraverseIterative(Node treeRoot){

        Node node = treeRoot;
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack(Integer.MAX_VALUE);

        do{
            while(node.left != null){
                sb.append(node.getIntData()+",");
                stack.push(node);
                node = node.left;
            }

            sb.append(node.getIntData()+",");

            node = (Node) stack.pop();
            node = node.right;
        }while (!stack.isEmpty() || node != null);

        return sb.substring(0,sb.length()-1);
    }
}
