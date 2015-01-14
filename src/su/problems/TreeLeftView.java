package su.problems;

import su.dataStructure.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Akshat on 1/12/2015.
 */
public class TreeLeftView {
    public String computeView(Node node) {

        if(node==null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);

        StringBuilder stringBuilder = new StringBuilder();

        do{
            Node currNode = queue.remove();

            if(currNode==null){
                if(queue.peek()!=null) {
                    queue.add(null);
                }else{
                    break;
                }
            }else {
                if (queue.peek() == null)
                    stringBuilder.append(currNode.getIntData()+",");
                queue.add(currNode.left);
                queue.add(currNode.right);
            }

        }while(true);

        return stringBuilder.substring(0,stringBuilder.length()-1);
    }
}
