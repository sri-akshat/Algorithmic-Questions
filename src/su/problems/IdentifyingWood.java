package su.problems;

/**
 * Created by Akshat on 10/4/2014.
 */
public class IdentifyingWood {

    public String check(String str1, String str2)
    {
        int i = 0;
        int j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if(j == str2.length()){
            return "Yep, it's wood.";
        }else{
            return "Nope.";
        }
    }
}
