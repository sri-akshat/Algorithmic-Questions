package su.problems;

import su.dataStructure.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Akshat on 1/12/2015.
 */
public class TreeRightView {
    public String computeView(Node node) {
        if(node==null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(queue.peek().getIntData()+",");

        do{
            Node currNode = queue.remove();

            if(currNode==null){
                if(queue.peek()!=null) {
                    queue.add(null);
                    stringBuilder.append(queue.peek().getIntData()+",");
                }else{
                    break;
                }
            }else {
                queue.add(currNode.left);
                queue.add(currNode.right);
            }

        }while(true);

        return stringBuilder.substring(0,stringBuilder.length()-1);
    }
}
