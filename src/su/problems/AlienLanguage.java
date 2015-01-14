package su.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akshat on 8/11/2014.
 */

public class AlienLanguage{

    public String evaluate(String[] words){

        Map<Character, String> relationshipMap = genRelationship(words, new HashMap<>());
        Map<Character, String> flattenRelationshipMap = flattenRelationships(relationshipMap);
        /*
         find and return entry in flattenRelationshipMap that satisfies value.size == sizeOf(relationshipMap)
         rationale -:
         relationshipMap =>
            a -> c, d -> a, b -> d
            size = 3
         flattenRelationshipMap
            a -> c, d -> ac, b -> dac
            size(dac) = 3
         return "b"+"dac"
        */
        for(Map.Entry<Character, String> entry : flattenRelationshipMap.entrySet())
        {
            if(entry.getValue().length() == flattenRelationshipMap.size())
                return entry.getKey()+entry.getValue();
        }

        return null;
    }

    /**
     *  Recursive code that keeps on flattening the map until progress is being made
     */
    int count = 0;
    private Map<Character, String> flattenRelationships(Map<Character, String> map)
    {
        boolean isProgressMade = false;

        for(Map.Entry<Character, String> entry: map.entrySet())
        {
            String val = map.get(entry.getValue().charAt(entry.getValue().length()-1));
            if(val !=null)
            {
                entry.setValue(entry.getValue()+val);
                isProgressMade = true;
                count++;
            }
        }

        if(isProgressMade)
            flattenRelationships(map);
        System.out.println(count);
        return map;
    }

    /**
     * Recursive code, that checks the 0th index of previous and current word
     * if(prev!=next) -> record the relation prev -> next, goto next word
     * else recurse for next char of previous and current word
     *
     */
    private Map<Character, String> genRelationship(String[] words, Map<Character, String> map)
    {
        if(words.length == 0)
            return map;

        for(int i=1; i<words.length;i++)
        {
            char prev = words[i-1].charAt(0);
            char curr = words[i].charAt(0);
            if(prev!=curr)
            {
                map.put(prev, curr+"");
            }else{
                map = genRelationship(new String[]{words[i - 1].substring(1), words[i].substring(1)}, map);
            }

        }
        return map;
    }
}
