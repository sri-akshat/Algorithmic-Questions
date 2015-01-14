package su.problems;

import su.dataStructure.Link;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Akshat
 * Date: 12/26/12
 * Time: 10:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class sortByFrequency {

    public static void main(String[] args) {

        Integer[] array = {4,5,4,5,4,5,4,8,8,7,7};

        int max = 0;
        for (Integer i : array)
        {
            if(i>max)
                max = i;
        }

        ArrayList<Integer> freqArray = new ArrayList<Integer>(max+1);
        for(int i = 0 ; i<max+1;i++){
            freqArray.add(0);
        }
        int maxFreq=0;
        for (Integer i : array)
        {
            if(freqArray.get(i)!=null){
                Integer temp = freqArray.get(i);
                freqArray.set(i, ++temp);
                if(maxFreq<temp)
                    maxFreq = temp;
            }
        }

        ArrayList<Link> arrayOfLink = new ArrayList<Link>(maxFreq+1);

        for(int i = 0 ; i<maxFreq+1;i++){
            arrayOfLink.add(null);
        }

        Map<Integer, Link> headerMap = new HashMap<Integer, Link>();

        for(int i = 1; i<freqArray.size() ; i++){
            if(freqArray.get(i)!=null){

                if(arrayOfLink.get(freqArray.get(i))==null){
                    Link current = new Link(i,freqArray.get(i));
                    arrayOfLink.set(freqArray.get(i), current);
                    headerMap.put(freqArray.get(i), current);
                }else{
                    Link endLink = arrayOfLink.get(freqArray.get(i));
                    endLink.next = new Link(i, freqArray.get(i));
                    arrayOfLink.set(freqArray.get(i), endLink.next);
                }
            }
        }

        for(int i = arrayOfLink.size()-1; i>0; i--){
            Link link = arrayOfLink.get(i);
            if(link !=null){
                System.out.print(link.toString(headerMap.get(i)));
            }
        }
    }

}

