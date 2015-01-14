package su.problems;

import java.util.Scanner;

/**
 * Created by Akshat on 9/1/2014.
 */
public class Productive {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            int side = scanner.nextInt();
            int[] array = new int[side*side];
            int[] maxArray = new int[side*side];
            int[] posArray = new int[side*side];
            int sum = 0;
            for(int k=0;k<side;k++)
            {
                for(int j=0;j<side;j++)
                {
                    array[side*k + j] = scanner.nextInt();
                    posArray[side*k+j] = side*k+j;
                }
            }

            maxArray = array.clone();
            int n = maxArray.length;
            for (int j = 1; j < n; j++) {
                int key = maxArray[j];
                int pos = posArray[j];
                int i1 = j-1;
                while ( (i1 > -1) && ( maxArray [i1] > key ) ) {
                    maxArray [i1+1] = maxArray [i1];
                    posArray[i1+1] = posArray[i1];
                    i1--;
                }
                maxArray[i1+1] = key;
                posArray[i1+1] = pos;
            }

            for(int h=(side*side)-1;h>-1;h--) {
                if(maxArray[h]!=0) {
                    sum += maxArray[h];
                    int column = posArray[h]%side;
                    int row = posArray[h]/side;
                    for(int p = 0;p<side;p++)
                    {
                        for(int y=0;y<side*side;y++) {
                            boolean esc = false;
                            boolean esc1 = false;
                            if(posArray[y]== side * row + p)
                            {
                                maxArray[y] = 0;
                                esc = true;
                            }
                            if(posArray[y]== column + p * side)
                            {
                                maxArray[y] = 0;
                                esc1 = true;
                            }
                            if(esc && esc1)
                            {
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println(sum);
        }


        
    }

}
