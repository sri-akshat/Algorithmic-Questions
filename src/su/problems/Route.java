package su.problems;

/**
 * Created by Akshat on 1/4/2015.
 */
public class Route{

    private int[] array;

    public Route(int[] array){
        this.array = array;
    }

    public boolean isPossible(int index)
    {
        if(index==0)
            return true;
        for(int i=index-1;i>-1;i--)
        {
            if(array[i] == index-i)
            {
                return isPossible(i);
            }
        }
        return false;
    }

}