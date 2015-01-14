package su.problems;

import su.dataStructure.Node;

/**
 * Created by Akshat on 1/10/2015.
 */
public class MirrorTreeSum {
    public void evaluate(Node rootLNR, Node rootRNL) {
        if(rootLNR.left!=null && rootRNL.right!=null)
        {
            evaluate(rootLNR.left, rootRNL.right);
        }

        System.out.println(rootLNR.getIntData()+rootRNL.getIntData());
//        rootLNR.setData(rootLNR.getIntData()+rootRNL.getIntData());

        if(rootLNR.right!=null && rootRNL.left!=null)
        {
            evaluate(rootLNR.right, rootRNL.left);
        }
    }
}
