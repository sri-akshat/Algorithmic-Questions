package su;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshat on 5/7/2014.
 */
public class TestUtils {

    public static su.dataStructure.Node createBinaryTree() {

        ArrayList<Integer> numbers = getIntegerList();
        su.dataStructure.Node root = new su.dataStructure.Node(numbers.get(1));
        root.parent = null;
        root.setIndex(1);

        int index = 0;
        return createBinaryTreeRecursive(root, numbers);
    }

    public static su.dataStructure.Node createBinaryTree(List<Integer> numbers) {

        su.dataStructure.Node root = new su.dataStructure.Node(numbers.get(1));
        root.parent = null;
        root.setIndex(1);

        int index = 0;
        return createBinaryTreeRecursive(root, numbers);
    }

    public static su.dataStructure.Node createBinaryTreeRecursive(su.dataStructure.Node root, List<Integer> numbers) {

        if(root.left==null && 2*root.getIndex() < numbers.size()){
            root.left = new su.dataStructure.Node(numbers.get(2*root.getIndex()), 2*root.getIndex());
            root.left.parent = root;
            createBinaryTreeRecursive(root.left, numbers);
        }
        if(root.right==null && 2*root.getIndex()+1 < numbers.size()){
            root.right = new su.dataStructure.Node(numbers.get(2*root.getIndex()+1),2*root.getIndex()+1);
            root.right.parent = root;
            createBinaryTreeRecursive(root.right, numbers);
        }
        return root;
    }

    private static ArrayList<Integer> getIntegerList() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(-1);  // unused 0th index
        numbers.add(15);
        numbers.add(6);
        numbers.add(18);
        numbers.add(3);
        numbers.add(7);
        numbers.add(17);
        numbers.add(20);
        return numbers;
    }

}
