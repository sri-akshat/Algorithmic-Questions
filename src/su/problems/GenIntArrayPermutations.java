package su.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshat on 1/21/2015.
 */
public class GenIntArrayPermutations {

    private List<List<Integer>> permutations = new ArrayList<>();
    public void compute(List<Integer> arr, List<Integer> permutation) {

        if(arr.isEmpty()) {
            System.out.println();
            permutation.forEach(System.out::print);
            permutations.add(permutation);
            return;
        }

        for(int j=0;j<arr.size();j++)
        {
            List<Integer> newPermutation = new ArrayList<>(permutation);
            newPermutation.add(arr.get(j));
            List<Integer> newList = new ArrayList<>(arr.subList(0, j));
            newList.addAll(arr.subList(j+1, arr.size()));
            compute(newList, newPermutation);
        }
    }

    public List<List<Integer>> getPermutations() {
        return permutations;
    }
}
