package su.problems;

import su.dataStructure.Node;

import java.util.List;

/**
 * Created by Akshat on 1/18/2015.
 */
public class RootToLeafSum {
    public List<Integer> compute(Node node, int sum, List<Integer> list){

        if(node.left!=null){
            compute(node.left, sum+node.getIntData(), list);
        }

        if(node.right!=null){
            compute(node.right, sum+node.getIntData(), list);
        }

        if(node.left==null && node.right==null)
        {
            list.add(sum+node.getIntData());
        }
        return list;
    }

}
