package su.problems;

import java.util.Scanner;

/**
 * Created by Akshat on 9/13/2014.
 */
public class EndGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {

            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            int m = scanner.nextInt();

            int endPointY = n;
            int endPointX = b;

            int pawnRow = a;
            pawnRow = m ==0 ? pawnRow+1: pawnRow;
            if((pawnRow-1 <=2 && n-b <= 2)&&(c==pawnRow+2 && (d==b-1 || d==b || d==b+1)))
            {
                System.out.println("White Wins");
                continue;
            }

            if(m == 0)
            {
                a++;
            }else{
                a--;
            }
//            System.out.println("pawn distance"+pawnDistance(a,endPointY));
//            System.out.println("king distance"+kingDistance(d,c,endPointX,endPointY));

            if(pawnDistance(a,endPointY) < kingDistance(d,c,endPointX,endPointY) - 1)
            {
                System.out.println("White Wins");
            }else{
                System.out.println("Draw");
            }

        }
    }

    static double  pawnDistance(double x1, double n)
    {
     return n - x1;
    }

    static double  kingDistance(double x1, double y1, double x2, double y2)
    {
        return ((x2-x1) > (y2-y1)) ? x2-x1 : y2 - y1;
    }


}
