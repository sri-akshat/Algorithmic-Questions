package su.problems;

import java.util.Scanner;

/**
 * Created by Akshat on 9/28/2014.
 */
public class AToB {

    int v = 1000000007;
    public long[] populateB(long[] A)
    {
        int N = A.length;
        long[] B = new long[N+1];
        for(int i=1;i<=N;i++)
        {
            B[i]=1;
            for(int j=1;j<N;j++)
            {
                if(i!=j)
                {

                    B[i]= (B[i]%v * A[j]%v) ;
                    while(B[i] > 10000) {
                        B[i] %= v;
                    }
                }
            }
        }
        return B;
    }

    public static void main(String[] args)
    {
        AToB aToB = new AToB();
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong()+1;
        scanner.nextLine();
        long[] A = new long[(int) num];
        String str = scanner.nextLine();
        int p = 1;
        for(String s: str.split(" "))
        {
            A[p] = Long.parseLong(s);
            p++;
        }
        long Q = scanner.nextLong();
        scanner.nextLine();
        for(long i=0;i<Q;i++)
        {

            str = scanner.nextLine();
            String[] split = str.split(" ");
            int instr = Integer.parseInt(split[0]);
            if(instr==0)
            {
                long ID = Long.parseLong(split[1]);
                long V = Long.parseLong(split[2]);
                A[((int) ID)] = V;
            }else{
                long ID = Long.parseLong(split[1]);
                long[] B = aToB.populateB(A);
                System.out.println((int)(B[((int) ID)]));
            }
        }
    }

}
