package su.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Akshat on 1/2/2015.
 */
/* Generate possible words

e.g. - Gi -> Hi

functions provided - :
    char[] getNearByChars(char)
    boolean isWord(String)

Algorithm

1. Gi
       G => g,f,h
       i => i,u,o
       permutations => gi, gu, go
                       fi, fu, fo
                       hi, hu, ho

   Hello
       H => h,g,j
       e => e,w,r
       l => l,k,m
       l => l,k,m
       o => o,i,p

                       #
       h                g                j
   e   w    r
 l k m




     hello    h    h
     ello     e    he
     llo      l    hel
     lo

*/

public class NearbyWords {

    private Map<Character, char[]> characterMap = new HashMap<>();

    public NearbyWords() {
        characterMap.put('h', new char[]{'h','g','j'});
        characterMap.put('e', new char[]{'e','w','r'});
        characterMap.put('l', new char[]{'l','k','m'});
        characterMap.put('o', new char[]{'o','i','p'});
        characterMap.put('g', new char[]{'g','f','h'});
        characterMap.put('i', new char[]{'i','u','o'});
    }

    public List<String> getNearbyWords(String input){
        List<String> list = new ArrayList<>();
        for(String s : genPermutations(input))
        {
            if(isWord(s)){
                list.add(s);
            }
        }
        return list;
    }

    private List<String> genPermutations(String input)
    {
        if(input.isEmpty())
            return new ArrayList<>();

        List<String> list = genPermutations(input.substring(1));
        List<String> newList = new ArrayList<>();

        for(char nearByChar : getNearByChars(input.charAt(0)))
        {
            if(list.isEmpty())
            {
                newList.add(nearByChar + "");
            }else {

                for (String word : list) {
                    newList.add(nearByChar + word);
                }
            }
        }

        return newList;
    }

    private char[] getNearByChars(char curr) {

        return characterMap.get(curr);
    }

    private boolean isWord(String permutation) {
        return permutation.equalsIgnoreCase("Hello") ||
                permutation.equalsIgnoreCase("Jello") ||
                permutation.equalsIgnoreCase("Hi") ||
                permutation.equalsIgnoreCase("Go");
    }


}