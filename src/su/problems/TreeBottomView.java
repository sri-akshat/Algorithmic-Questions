package su.problems;

import su.dataStructure.Node;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Akshat on 1/12/2015.
 */
public class TreeBottomView{

    private Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

    public String computeView(Node node){

        StringBuilder sb = new StringBuilder();
        compute(node);
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            sb.append(entry.getValue() + ",");
        }
        return sb.substring(0, sb.length()-1);
    }

    public void compute(Node node)
    {
        map.put(node.getIndex(), node.getIntData());

        if(node.left!=null){
            node.left.setIndex(node.getIndex()-1);
            compute(node.left);
        }

        if(node.right!=null){
            node.right.setIndex(node.getIndex()+1);
            compute(node.right);
        }

    }
}