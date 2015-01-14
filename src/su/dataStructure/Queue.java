package su.dataStructure;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 1/28/13
 * Time: 10:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Queue {

    private int maxSize = 0;
    private int size = 0;
    private ArrayList<Node> list;

    public Queue(int maxSize){
        this.maxSize = maxSize;
        list = new ArrayList<Node>();
    }

    public void push(Node node){
        if(size >= maxSize){
            throw new RuntimeException("queue full !!");
        }else{
            list.add(node);
            ++size;
        }
    }

    public Node pop(){
        if(size > 0){
            Node temp = (Node) list.get(0);
            list.remove(0);
            --size;
            return temp;
        }else{
            throw new RuntimeException("queue already empty !!");
        }
    }

    public boolean isEmpty(){
        return list.size() == 0;
    }
}
