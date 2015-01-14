package su.problems;

import java.util.*;

/**
 * Created by Akshat on 9/19/2014.
 */
public class MirrorsAndTree {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {

            int arrayLen = scanner.nextInt();
            int[] array = new int[arrayLen + 1];
            int[] leftArray = new int[arrayLen + 1];
            int[] rightArray = new int[arrayLen + 1];

            for (int j = 1; j < arrayLen; j++) {
                array[j] = scanner.nextInt();
            }

            evaluate(array, leftArray, rightArray);
            scanner.next();
        }
    }

    protected static void evaluate(int[] array, int[] leftArray, int[] rightArray) {
        System.out.println(array[1]);
        Set printed = new HashSet();
        int[] leftArrayIndex = new int[array.length];
        printRight(rightArray,array,2,3,printed);
        printLeft(leftArrayIndex,leftArray,array,2,3);

        for(int k = 1;k<rightArray.length;k++)
        {
            if(rightArray[k]!=0) {
                System.out.println(rightArray[k]);
            }
        }
        for(int k = 1;k<leftArray.length;k++)
        {
            if(leftArray[k]!=0 && !printed.contains(leftArrayIndex[k]))
                System.out.println(leftArray[k]);
        }
        System.out.println("");
    }

    private static void printLeft(int[] leftArrayIndex, int[] leftArray, int[] array, int start, int end) {

        Queue queue = new LinkedList();
        Queue indexQueue = new LinkedList();
        for(int i=start;i<=end;i++) {
            if(array[i]!=0) {
                queue.add(array[i]);
                indexQueue.add(i);
            }
        }

        int height = start/2;
        leftArray[height] = queue.isEmpty()? 0 : (Integer)queue.peek();
        leftArrayIndex[height] = indexQueue.isEmpty()? 0 : (Integer)indexQueue.peek();
        if(end*2+1 <= array.length)
            printLeft(leftArrayIndex, leftArray, array, 2 * start, end * 2 + 1);
    }

    private static void printRight(int[] rightArray, int[] array, int start, int end, Set printed) {

        Stack stack = new Stack();
        int lastPos = 0;
        for(int i=start;i<=end;i++) {
            if(array[i]!=0) {
                stack.add(array[i]);
                lastPos = i;
            }
        }

        int height = start/2;
        rightArray[height] = stack.isEmpty()? 0 : (Integer) stack.pop();
        if(rightArray[height]!=0)
            printed.add(lastPos);
        if(end*2+1 <= array.length)
            printRight(rightArray, array, 2*start, end*2+1, printed);
    }


}
