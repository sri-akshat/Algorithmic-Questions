package su.problems;

import java.util.*;

/**
 * Created by Akshat on 1/3/2015.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int row) {

        if(row == 1)
        {
            List<List<Integer>> set = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(1);

            set.add(list);
            return set;
        }
        if(row == 2)
        {
            List<List<Integer>> set = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();

            list1.add(1);
            set.add(list1);

            list.add(1);
            list.add(2);
            list.add(1);

            set.add(list);
            return set;
        }

        List<List<Integer>> arr = generate(row-1);
        List<Integer> newList = new ArrayList<>();
        List<Integer> list = arr.get(arr.size() - 1);
        for(int i=0; i < list.size(); i++)
        {
            if(list.get(i)==1)
                newList.add(1);

            if(i<list.size()-1)
                newList.add(list.get(i)+list.get(i+1));
        }
        arr.add(newList);
        return arr;
    }
}
