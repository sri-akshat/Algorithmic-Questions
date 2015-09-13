package su.problems.tree;

import su.dataStructure.Node;

import java.util.*;

/**
 * Created by Akshat on 2/3/2015.
 */
public class ClockwisePerimeter {

    public String computeRecursive(Node node)
    {
        StringBuilder stringBuilder = new StringBuilder();
        Set<Integer> perimeterSet = new LinkedHashSet<>();
        printRight(node, perimeterSet);
        printLeaves(node, perimeterSet);
        printLeft(node, perimeterSet);
        perimeterSet.forEach(i->stringBuilder.append(i+","));
        return stringBuilder.substring(0, stringBuilder.length()-1);
    }

    private void printLeaves(Node node, Set<Integer> perimeter) {

        if(node==null)
            return;

        if(node.isLeaf()) {
            perimeter.add(node.getIntData());
        }

        if(node.right!=null)
        {
            printLeaves(node.right, perimeter);
        }

        if(node.left!=null){
            printLeaves(node.left, perimeter);
        }
    }

    private void printLeft(Node node, Set<Integer> perimeter) {
        if(node==null)
            return;

        if(node.left!=null)
        {
            printLeft(node.left, perimeter);
        }else{
            printLeft(node.right, perimeter);
        }

        perimeter.add(node.getIntData());
    }

    private Node printRight(Node node, Set<Integer> perimeter) {

        if(node==null)
            return null;

        perimeter.add(node.getIntData());

        if(node.right!=null)
        {
            printRight(node.right, perimeter);
        }else{
            printRight(node.left, perimeter);
        }

        return node;
    }

    public String compute(Node node) {

        Queue<Integer> right = new LinkedList<>();
        Stack<Integer> left = new Stack<>();
        Stack<Integer> bottom = new Stack<>();

        Queue<Node> queue = new LinkedList<>();
        Node dummyNode = new Node(-1);
        queue.add(node);
        queue.add(dummyNode);

        while(!queue.isEmpty())
        {
            Node curr = queue.poll();
            System.out.println(curr.getIntData());

            if(queue.peek() == dummyNode)
            {
                if(!isLeaf(curr))
                    right.add(curr.getIntData());
            }

            if(curr == dummyNode)
            {
                Node next = queue.peek();
                if(next != null)
                {
                    queue.add(curr);
                    if(!isLeaf(next))
                        left.add(next.getIntData());
                }else{
                    break;
                }
            }

            if(curr!=dummyNode && isLeaf(curr))
                bottom.push(curr.getIntData());

            if(curr.left!=null)
                queue.add(curr.left);

            if(curr.right!=null)
                queue.add(curr.right);
        }

        StringBuilder stringBuilder = new StringBuilder();
        right.forEach(i->stringBuilder.append(i+","));
        while(!bottom.isEmpty())
        {
            stringBuilder.append(bottom.pop() + ",");
        }
        while(!left.isEmpty())
        {
            stringBuilder.append(left.pop()+",");
        }
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }

    private boolean isLeaf(Node curr) {
        return curr.left==null && curr.right==null;
    }
}
