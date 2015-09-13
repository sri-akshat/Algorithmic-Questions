package su.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akshat on 1/13/2015.
 */
public class NumToWord{

    Map<Integer, String> constantMap = new HashMap<Integer, String>();
    Map<Integer, String> placeMap = new HashMap<Integer, String>();


    public NumToWord(){
        constantMap.put(1,"ONE");
        constantMap.put(2,"TWO");
        constantMap.put(3,"THREE");
        constantMap.put(4,"FOUR");
        constantMap.put(5,"FIVE");
        constantMap.put(6,"SIX");
        constantMap.put(7,"SEVEN");
        constantMap.put(8,"EIGHT");
        constantMap.put(9,"NINE");
        constantMap.put(10,"TEN");
        constantMap.put(11,"ELEVEN");
        constantMap.put(12,"TWELVE");
        constantMap.put(13,"THIRTEEN");
        constantMap.put(14,"FOURTEEN");
        constantMap.put(15,"FIFTEEN");
        constantMap.put(16,"SIXTEEN");
        constantMap.put(17,"SEVENTEEN");
        constantMap.put(18,"EIGHTEEN");
        constantMap.put(19,"NINETEEN");
        constantMap.put(20,"TWENTY");
        constantMap.put(30,"THIRTY");
        constantMap.put(40,"FOURTY");
        constantMap.put(50,"FIVTY");
        constantMap.put(60,"SIXTY");
        constantMap.put(70,"SEVENTY");
        constantMap.put(80,"EIGHTY");
        constantMap.put(90,"NINETY");

        placeMap.put(6,"LAKH");
        placeMap.put(5,"THOUSAND");
        placeMap.put(4,"THOUSAND");
        placeMap.put(3,"HUNDRED");

    }
    public String getWord(int[] arr, StringBuilder sb)
    {
        if(arr.length==0)
            return sb.substring(0,sb.length()-1);

        int curr ;
        if(arr.length%2!=0){
            if(arr.length<4)
                curr = arr[0];
            else
                curr = arr[0]*10;
        }else{
            if(arr.length<4)
                curr = arr[0]*10;
            else
                curr = arr[0];
        }

        sb.append(constantMap.get(curr)).append(" ");

        String place = placeMap.get(arr.length);
        if(place!=null && !place.equalsIgnoreCase(placeMap.get(arr.length-1)))
            sb.append(place).append(" ");

        int[] newArr = new int[arr.length-1];
        System.arraycopy(arr,1,newArr,0, arr.length-1);

        return getWord(newArr, sb);
    }
}
