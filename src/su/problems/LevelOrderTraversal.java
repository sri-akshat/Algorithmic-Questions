package su.problems;

import su.dataStructure.Node;
import su.dataStructure.Queue;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 1/28/13
 * Time: 9:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class LevelOrderTraversal {

   public ArrayList<ArrayList> levelOrder(Node root) {
       ArrayList<ArrayList> array = new ArrayList<ArrayList>(10);
       return levelOrderIterative(root, array, new Queue(Integer.MAX_VALUE));
   }
// Start typing your Java solution below
// DO NOT write main() function
    private ArrayList<ArrayList> levelOrderIterative(Node root, ArrayList<ArrayList> array, Queue queue){
        queue.push(root);
        do{
            root = queue.pop();
            try{
                array.get(root.getLevel()).add(root.getIntData());
            }catch(IndexOutOfBoundsException e){
                array.add(new ArrayList());
                array.get(root.getLevel()).add(root.getIntData());
            }
            if(root.left != null){
                root.left.setLevel(root.getLevel()+1);
                queue.push(root.left);
            }
            if(root.right != null){
                root.right.setLevel(root.getLevel()+1);
                queue.push(root.right);
            }

        }while(!queue.isEmpty());
    return array;
    }

    public void printLevelOrderTree(Node root)
    {
        java.util.Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        do{
            root = queue.remove();
            if(root==null ){
                System.out.println("");
                queue.add(null);
                continue;
            }
            else
                System.out.print(root.getIntData());

            if(root.left!=null)
                queue.add(root.left);
            if(root.right!=null)
                queue.add(root.right);

        }while(root!=null && queue.peek()!=null);

    }

}

