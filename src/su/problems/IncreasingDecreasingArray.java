package su.problems;

/**
 * Created by Akshat on 1/18/2015.
 *
 *  Find element in an array which have elements in first increasing and then decreasing order.
 *
 */
public class IncreasingDecreasingArray {

    public boolean search(int[] array, int query){

        int hillTop = hillTopBST(array, 0, array.length-1);
        return bst(array, query, 0, hillTop) || rBST(array, query, hillTop+1, array.length-1);
    }

    private int hillTopBST(int[] array, int start, int end)
    {
        if(start>end)
            return -1;

        int mid = (start + end)/2;
        if(array[mid]>array[mid-1] && array[mid]>array[mid+1])
        {
            return mid;
        }

        if(array[mid]>array[mid-1] && array[mid]<array[mid+1])
            return hillTopBST(array, mid+1, end);
        if(array[mid]<array[mid-1] && array[mid]>array[mid+1])
            return hillTopBST(array, start, mid-1);

        return -1;
    }

    private boolean bst(int[] array, int query, int start, int end)
    {
        if(start>end)
            return false;

        int mid = (start+end)/2;

        if(query == array[mid])
            return true;
        if(query > array[mid])
            return bst(array, query, mid+1, end);
        if(query < array[mid])
            return bst(array, query, start, mid-1);

        return false;
    }



    private boolean rBST(int[] array, int query, int start, int end)
    {
        if(start>end)
            return false;

        int mid = (start+end)/2;

        if(query == array[mid])
            return true;
        if(query < array[mid])
            return bst(array, query, mid+1, end);
        if(query > array[mid])
            return bst(array, query, start, mid-1);

        return false;
    }
}
