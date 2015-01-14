package su.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshat on 1/9/2015.
 */
public class SubWord
{
    public List<String> findSubWords(String input) {

        if(input.isEmpty())
            return new ArrayList<String>();

        List<String> subWords = findSubWords(input.substring(1));
        for(int i=0;i<input.length();i++)
        {
            String subWord = input.substring(0, i+1);
            if(isWord(subWord))
                subWords.add(subWord);
        }
        return subWords;
    }

    private boolean isWord(String subWord) {
        return (subWord.equalsIgnoreCase("on")||
           subWord.equalsIgnoreCase("one")||
           subWord.equalsIgnoreCase("honey")||
           subWord.equalsIgnoreCase("pot"));
    }
}
