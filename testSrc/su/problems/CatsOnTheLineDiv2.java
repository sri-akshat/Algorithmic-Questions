package su.problems;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Akshat on 8/30/2014.
 */
public class CatsOnTheLineDiv2 {

    String getAnswer(int[] position, int[] count, int time){

        int[] array = new int[3000];
        for(int i =0;i<3000;i++)
        {
            array[i] = 0;
        }
        int maxI = -1;
        int maxFreq = 0;
        for(int i=0;i<position.length;i++)
        {
            if(count[i] > maxFreq)
            {
                maxFreq = count[i];
                maxI = i;
            }
            array[position[i]+1000] = count[i];
        }


        int start = maxI - (maxFreq / 2) + 1000;
        int end = maxI + (maxFreq / 2) + 1000;
        int actTime = maxFreq / 2 ;
        if(start<0)
            start = 0;
        for(int k= start; k<=end; k++)
        {
            if(array[k] > 0 && k!= maxI+1000)
            {
                actTime ++;
            }
        }
        if(actTime <= time)
            return "Possible";
        return "Impossible";
    }

    @Test
     public void test()
    {
        CatsOnTheLineDiv2 catsOnTheLineDiv2 = new CatsOnTheLineDiv2();
        int[] position = {5, 0, 2};
        int[] count = {2, 3, 5};
        int time = 2;
        Assert.assertEquals("Impossible",catsOnTheLineDiv2.getAnswer(position,count,time));
    }

    @Test
    public void test1()
    {
        CatsOnTheLineDiv2 catsOnTheLineDiv2 = new CatsOnTheLineDiv2();
        int[] position = {5, 1, -10, 7, 12, 2, 10, 20};
        int[] count = {3, 4, 2, 7, 1, 4, 3, 4};
        int time = 6;
        Assert.assertEquals("Possible",catsOnTheLineDiv2.getAnswer(position,count,time));
    }

    @Test
    public void test2()
    {
        CatsOnTheLineDiv2 catsOnTheLineDiv2 = new CatsOnTheLineDiv2();
        int[] position = {0};
        int[] count = {7};
        int time = 3;
        Assert.assertEquals("Possible",catsOnTheLineDiv2.getAnswer(position,count,time));
    }

    @Test
    public void test3()
    {
        CatsOnTheLineDiv2 catsOnTheLineDiv2 = new CatsOnTheLineDiv2();
        int[] position = {40, -12, 79, 86, -25, 47, 9, 31, -65, 50, 49, 12, 43, -40, -8, 81, 6, 2, -32, 13, -51, 37, -87, -92, -1, -37, -83};
        int[] count = {21, 3, 43, 30, 30, 31, 10, 19, 18, 44, 22, 40, 35, 43, 9, 33, 16, 19, 21, 12, 44, 0, 16, 33, 34, 15, 0};
        int time = 88;
        Assert.assertEquals("Impossible",catsOnTheLineDiv2.getAnswer(position,count,time));
    }
}
