package su.problems;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Akshat on 1/29/2015.
 */
public class LexicographicSorting implements Comparator<String> {
    public List<String> sort(List<String> list) {

        Collections.sort(list);
        list.forEach(System.out::println);
        return list;
    }

    @Override
    public int compare(String s1, String s2)
    {
        int minLen = s1.length() > s2.length() ? s2.length() : s1.length();
        for(int i=0;i<minLen;i++)
        {
            if(s1.charAt(i)>s2.charAt(i))
            {
              return 1;
            }else if(s1.charAt(i)>s2.charAt(i))
            {
                return -1;
            }
        }
        return 0;
    }
}
