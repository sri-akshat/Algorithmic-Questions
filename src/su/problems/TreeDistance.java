package su.problems;

/**
 * Created by Akshat on 1/12/2015.
 */

import su.dataStructure.Node;

import java.util.ArrayList;
import java.util.List;

/**    Algorithm
 1. Find target node
 2. when found, collect child nodes at k distance
 3. with every unwind check the node(parent to target) for distance, if unequal calc k-2 distant for left/right child
 **/

public class TreeDistance{

    public int calculateDistantNodes(Node node, int target, int distance, List<Integer> result)
    {
        if(node==null)
            return -1;

        if(node.getIntData()==target)
        {
            result.addAll(getDistantNodesInSubTree(node, distance, 0, new ArrayList()));
            return 0;
        }

        // left sub tree

        int currDistance = calculateDistantNodes(node.left, target, distance, result);

        if(currDistance!=-1)
        {
            if(currDistance+1 == distance){
                result.add(node.getIntData());
            }else{
                result.addAll(getDistantNodesInSubTree(node.right, distance-2, 0, new ArrayList()));
            }
            return currDistance+1;
        }

        // right sub tree

        currDistance = calculateDistantNodes(node.right, target, distance, result);

        if(currDistance!=-1)
        {
            if(currDistance+1 == distance){
                result.add(node.getIntData());
            }else{
                result.addAll(getDistantNodesInSubTree(node.left, distance-2, 0, new ArrayList()));
            }
            return currDistance+1;
        }

        return -1;
    }

    protected List<Integer> getDistantNodesInSubTree(Node node, int distance, int currDistance, List<Integer> result)
    {
        if(node==null)
            return result;

        if(currDistance == distance)
            result.add(node.getIntData());

        if(node.left!=null)
            getDistantNodesInSubTree(node.left, distance, currDistance+1, result);

        if(node.right!=null)
            getDistantNodesInSubTree(node.right, distance, currDistance+1, result);

        return result;
    }

}