package su.problems;

import su.dataStructure.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Akshat on 1/18/2015.
 */
public class TreeRelation {

    public boolean areCousins(Node root, int x, int y)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);

        do{
            Node curr = queue.remove();
            if(curr==null){
                if(queue.peek()!=null)
                    queue.add(null);
                else
                    break;
            }else{
                if(curr.getIntData()==x){
                    while(queue.peek()!=null){
                        curr = queue.remove();
                        if(curr.getIntData()==y)
                        {
                            return true;
                        }
                    }
                    return false;
                }

                if(curr.getIntData()==y){
                    while(queue.peek()!=null){
                        curr = queue.remove();
                        if(curr.getIntData()==x)
                        {
                            return true;
                        }
                    }
                    return false;
                }

                queue.add(curr.left);
                queue.add(curr.right);
            }
        }while(true);

        return false;
    }
}
